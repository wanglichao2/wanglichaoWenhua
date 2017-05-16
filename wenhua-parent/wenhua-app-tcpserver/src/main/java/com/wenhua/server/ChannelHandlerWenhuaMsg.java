package com.wenhua.server;

import static com.wenhua.server.ChannelUtils.getChannelShortId;
import static com.wenhua.server.ChannelUtils.getRemoteIp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.google.protobuf.ByteString;
import com.google.protobuf.InvalidProtocolBufferException;
import com.wenhua.proto.Wenhua;
import com.wenhua.proto.Wenhua.AuthInfo;
import com.wenhua.proto.Wenhua.FileBar;
import com.wenhua.proto.Wenhua.FileInfo;
import com.wenhua.proto.Wenhua.FileInfoList;
import com.wenhua.proto.Wenhua.FileInfoList.Builder;
import com.wenhua.proto.Wenhua.PcInfo;
import com.wenhua.proto.Wenhua.PcInfoList;
import com.wenhua.proto.Wenhua.PcInstantInfo;
import com.wenhua.proto.Wenhua.PcInstantInfoList;
import com.wenhua.proto.Wenhua.ServerInfo;
import com.wenhua.proto.WenhuaMsg;
import com.wenhua.proto.WenhuaMsg.Message;
import com.wenhua.svr.component.StatAreaInstanceCacher;
import com.wenhua.svr.component.StatBarInstancerCacher;
import com.wenhua.svr.domain.BarAuthInfo;
import com.wenhua.svr.domain.BarConfig;
import com.wenhua.svr.domain.BarFileBar;
import com.wenhua.svr.domain.BarFileInfo;
import com.wenhua.svr.domain.BarPcInstantInfo;
import com.wenhua.svr.domain.NetBar;
import com.wenhua.svr.exception.AuthBarNotExistException;
import com.wenhua.svr.exception.AuthBarNotValidException;
import com.wenhua.svr.exception.AuthSignNotValidException;
import com.wenhua.svr.exception.FileNotExistException;
import com.wenhua.svr.exception.SystemException;
import com.wenhua.svr.service.AuthService;
import com.wenhua.util.BarIdUtils;
import com.wenhua.util.tools.NumberUtil;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.TimeoutException;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;

public class ChannelHandlerWenhuaMsg extends ChannelInboundHandlerAdapter {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private static final String METHOD_NAME_IS_NULL = "MethodNameIsNull";
	
	private static final String BAR_ID = "BAR_ID";
	
	private static final String TCP_SERVER = "TCP_SERVER";
	
	private Map<Integer, String> codeMaps;
	
	private AuthService authService;
	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		
		logger.debug("###################################");
		logger.debug("###################################");
		ctx.channel().toString();
		logger.debug(String.format("##Active ChannelShortId: %s remoteId: %s", getChannelShortId(ctx), getRemoteIp(ctx)));
		logger.debug("###################################");
		logger.debug("###################################");
		
		ChannelGroups.add(ctx);
		
		super.channelActive(ctx);
	}
	
	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		logger.debug("###################################");
		logger.debug("###################################");
		logger.debug(String.format("##Inactive ChannelShortId: %s remoteId: %s", getChannelShortId(ctx), getRemoteIp(ctx)));
		logger.debug("###################################");
		logger.debug("###################################");
		
		ChannelGroups.discard(ctx);
		
		boolean isBarDeleted = false;
		
		/** 將Channel 标识 该channel的网吧已被删除 */
		Attribute<Object> attr = ctx.channel().attr(AttributeKey.valueOf(ChannelHandlerHttp.IS_BAR_DELETED));
		Object object = attr.get();
		if(null != object && (Boolean)object) {
			isBarDeleted = true;
		}
		
		StatAreaInstanceCacher.inactiveBar(getBarId(ctx));
		StatBarInstancerCacher.updateCache(getBarId(ctx), null, isBarDeleted);
		
		ctx.close();
		
		super.channelInactive(ctx);
	}
	
	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		logger.debug(String.format("##Read ChannelShortId: %s remoteId: %s", getChannelShortId(ctx), getRemoteIp(ctx)));
		WenhuaMsg.Message message = (WenhuaMsg.Message) msg;
		
		long id = message.getId();
		String methodName = message.getMethod();

		logMsg(ctx, message);
		
		TcpMethod method = TcpMethod.getEnumFromString(methodName);
		
		if(null == method || 0 == id) {
			invalidRequestCloseChannel(ctx, id, 1001, methodName, null);
			return;
			
		} else if(TcpMethod.Authentication.equals(method)) {
			doAuthentication(ctx, message);
			
		} else {
			
			String barId = getBarId(ctx);
			if(null == barId) {
				invalidRequestCloseChannel(ctx, id, 1005, methodName, null);
				return;
			}
			logger.info(String.format("##BarId exist ChannelShortId: %s remoteId: %s MessageId: %s barId: %s", getChannelShortId(ctx), getRemoteIp(ctx), message.getId(), barId));
			
			switch(method) {
			
				/** 获取文件 */
				case GetFile :
					doGetFile(ctx, message);
					
				break;
				/** 获取信息 */
				case GetConfig : 
					doGetConfig(ctx, message);
					
				break;
				case GetFileInfoList : 
					doGetFileInfoList(ctx, message);
					
				break;
				/** 上报客户机实时信息列表 */
				case SetInstantPcInfoList : 
					doSetInstantPcInfoList(ctx, message);
					
				break;
				/** 上报客户机信息列表 */
				case SetPcInfoList : 
					doSetPcInfoList(ctx, message);
					
				break;
				/** 上报服务器信息 */
				case SetServerInfo : 
					doSetServerInfo(ctx, message);
					
				break;
				default : 
					;
				break;
			} //switch end
			
		}
		
		super.channelRead(ctx, msg);
	}

	private static String getBarId(ChannelHandlerContext ctx) {
		Channel channel = ctx.channel();
		Attribute<Object> attr = channel.attr(AttributeKey.valueOf(BAR_ID));
		
		if(null == attr) return null;
		Object target = attr.get();
		
		if(null == target) return null;
		
		String barId = (String)target;
		return barId;
	}

	/**
	 * 获取文件
	 * @param ctx
	 * @param message
	 */
	private void doGetFile(ChannelHandlerContext ctx, Message message) {
		ByteString fileIdBytes = message.getContent();
		int fileId = NumberUtil.byte4ToInt(fileIdBytes.toByteArray(), 0);
		logger.info(String.format("##GetFile ChannelShortId: %s  RemoteIp: %s MessageId: %s fildId: %s", getChannelShortId(ctx), getRemoteIp(ctx), message.getId(), String.valueOf(fileId)));;
		
		byte[] target = null;
		Message response = null;
		try {
			com.wenhua.svr.domain.FileInfo fileInfo = authService.getFileById(fileId);
			
			target = fileInfo.getData();
			response = getResponseMsg(ctx, message.getId(), 0, codeMaps.get(0), ByteString.copyFrom(target), message.getMethod());
			
			if(logger.isInfoEnabled()) {
				logger.info(
						String.format(
								"##GetFile ChannelShortId: %s  RemoteIp: %s MessageId: %s return fildId: %s fileName: %s fileSize: %d", 
								getChannelShortId(ctx), 
								getRemoteIp(ctx), 
								message.getId(),
								String.valueOf(fileId),
								fileInfo.getFilename(),
								target.length
								));;
			}
			
		} catch (FileNotExistException e) {
			logger.error(String.format("##GetFile ChannelShortId: %s  RemoteIp: %s fildId: %s error FileNotFound", getChannelShortId(ctx), getRemoteIp(ctx), String.valueOf(fileId)));
			response = getResponseMsg(ctx, message.getId(), 1006, codeMaps.get(106), ByteString.copyFrom(target), message.getMethod());
		} catch (SystemException e) {
			response = getResponseMsg(ctx, message.getId(), 1007, codeMaps.get(1007), ByteString.copyFrom(target), message.getMethod());
		}
		
		
		ctx.writeAndFlush(response);
	
	}

	/**
	 * 请求不合法 关闭Channel
	 * @param ctx
	 * @param id
	 * @param exceptCode
	 * @param methodName
	 */
	private void invalidRequestCloseChannel(ChannelHandlerContext ctx, long id, int exceptCode, String methodName, Throwable cause) {
		String exceptMsg;
		String method;
		method = null == methodName ? METHOD_NAME_IS_NULL : methodName;
		exceptMsg = codeMaps.get(exceptCode);
		
		Message responseMsg = getResponseMsg(ctx, id, exceptCode, exceptMsg, null, method);
		ChannelFuture future = ctx.writeAndFlush(responseMsg);
		future.addListener(ChannelFutureListener.CLOSE);
		
		logger.error(String.format("##%s return message invalid ChannelShortId: %s  RemoteIp: %s exceptCode: %d exceptMs: %s throwable: %s", 
				method, 
				getChannelShortId(ctx), 
				getRemoteIp(ctx),
				exceptCode,
				exceptMsg,
				null != cause ? cause.getMessage() : "no throwable"
				));
	}

	private Message getResponseMsg(ChannelHandlerContext ctx, long id, int exceptCode, String exceptMsg, ByteString content, String methodName) {
		Message response = WenhuaMsg.Message.newBuilder()
			.setId(id)
			.setMethod(null == methodName ? METHOD_NAME_IS_NULL : methodName)
			.setContent(null == content ? ByteString.copyFrom(exceptMsg.getBytes()) : content)
			.setExceptCode(exceptCode)
			.setExceptMsg(exceptMsg)
			.build();
		
		logger.info(
				String.format(
						"##Do response is ChannelShortId: %s  RemoteIp: %s MessageId: %d ExceptCode: %d ExceptMsg: %s Method: %s", 
						getChannelShortId(ctx),
						getRemoteIp(ctx),
						id,
						exceptCode,
						exceptMsg,
						methodName
						));
		
		return response;
	}

	private FileInfoList getFromPair(List<BarFileInfo> list1, List<BarFileBar> list2) {
		
		Builder builder = Wenhua.FileInfoList.newBuilder();
		
		if(null != list1 && 0 != list1.size()) {
			for(BarFileInfo fileInfo : list1) {
				FileInfo f = Wenhua.FileInfo.newBuilder()
					.setAction(fileInfo.getAction())
					.setApplyAllBar(fileInfo.isApplyAllBar())
					.setFilename(fileInfo.getFileName())
					.setFlag(fileInfo.getFlag())
					.setId(fileInfo.getId())
					.setMd5(null == fileInfo.getMd5() ? "" : fileInfo.getMd5())
					.setType(fileInfo.getType())
					.setVersion(null == fileInfo.getVersion() ? "" : fileInfo.getVersion())
					.build();
				
				builder.addInfos(f);
			}
		}
		
		if(null != list2 && 0 != list2.size()) {
			for(BarFileBar fileBar : list2) {
				com.wenhua.proto.Wenhua.FileBar.Builder b = Wenhua.FileBar.newBuilder()
					.setFileID(fileBar.getFileId());
				
				b.addAllBarID(fileBar.getBarIdList());
				
				FileBar fb = b.build();
				
				builder.addFileBars(fb);
			}
		}
		
		return builder.build();
	}

	/**
	 * 获取文件信息列表
	 * @param ctx
	 * @param message
	 */
	private void doGetFileInfoList(ChannelHandlerContext ctx, Message message) {
		String barId = getBarId(ctx);
		
		logger.info(String.format("##GetFileInfoList ChannelShortId: %s  RemoteIp: %s MessageId: %s barId:%s", getChannelShortId(ctx), getRemoteIp(ctx), message.getId(), barId));
		
		int exceptCode =0;
		String exceptMsg = null;
		ByteString content = null;
		
		try {
//			authService.updateVersion(barId, serverVersion, clientVersion);
			List<BarFileInfo> barFileInfoList = authService.getBarFileInfoList(barId);
			List<BarFileBar> barFileBarList = authService.getBarFileBarList(barId);
			
			Wenhua.FileInfoList fileInfoList = getFromPair(barFileInfoList, barFileBarList);
			exceptCode = 0;
			exceptMsg = codeMaps.get(exceptCode);
			content = fileInfoList.toByteString();
			
			if(logger.isInfoEnabled()) {
				logger.info(
						String.format(
								"##GetFileInfoList return ChannelShortId: %s  RemoteIp: %s MessageId: %s barId:%s barFileInfoList: %s barFileBarList: %s", 
								getChannelShortId(ctx), 
								getRemoteIp(ctx), 
								message.getId(),
								barId,
								JSON.toJSONString(barFileInfoList),
								JSON.toJSONString(barFileBarList)
								));
				
				
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			exceptCode = 1004;
			exceptMsg = codeMaps.get(exceptCode);
			content = ByteString.copyFromUtf8(String.valueOf(false));
		}
		
		Message response = getResponseMsg(ctx, message.getId(), exceptCode, exceptMsg, content, message.getMethod());
		ctx.writeAndFlush(response);
		
	}

	/**
	 * 上报客户机实时信息列表
	 * @param ctx
	 * @param message
	 */
	private void doSetInstantPcInfoList(ChannelHandlerContext ctx, Message message) {
		PcInstantInfoList pcInstantInfoList = null;
		try {
			pcInstantInfoList = Wenhua.PcInstantInfoList.parseFrom(message.getContent());
		} catch (InvalidProtocolBufferException e) {
			invalidRequestCloseChannel(ctx, message.getId(), 1009, message.getMethod(), e);
			return;
		}
		List<PcInstantInfo> infosList = pcInstantInfoList.getInfosList();
		logger.info(String.format("##SetInstantPcInfoList ChannelShortId: %s RemoteIp: %s MessageId: %s PcInstantInfoListSize: %d", getChannelShortId(ctx), getRemoteIp(ctx), message.getId(), null == infosList ? 0 : infosList.size()));
		
		List<BarPcInstantInfo> barPcInstantInfoList = new ArrayList<BarPcInstantInfo>(null == infosList ? 0 : infosList.size());
		
		if(null != infosList) {
			for(PcInstantInfo info : infosList) {
				BarPcInstantInfo pc = new BarPcInstantInfo();
				pc.setMac(info.getMac());
				pc.setPowerOn(info.getIsPowerOn());
				pc.setPowerDuration(info.getPoweronDuration());
				pc.setWenhuaDuration(info.getWenhuaDuration());
				pc.setRunWenhua(info.getIsRunWenhua());
				pc.setUserLogin(info.getIsUserLogin());
				
				barPcInstantInfoList.add(pc);
			}
		}
		
		if(logger.isInfoEnabled()) {
			logger.info(
					String.format(
							"##SetInstantPcInfoList ChannelShortId: %s RemoteIp: %s MessageId: %s PcInstantInfoList: %s", 
							getChannelShortId(ctx), 
							getRemoteIp(ctx), 
							message.getId(),
							JSON.toJSONString(barPcInstantInfoList)
							));
		}
		
		
		int exceptCode = 0;
		String exceptMsg = codeMaps.get(exceptCode);
		ByteString content = null;
//		try {
//			statService.updateBarInstanceInfo(getBarId(ctx), barPcInstantInfoList);
//			content = ByteString.copyFromUtf8(String.valueOf(true));
//			exceptCode = 0;
//			exceptMsg = codeMaps.get(exceptCode);
//		} catch (Exception e) {
//			logger.error(e.getMessage(), e);
//			exceptCode = 1004;
//			exceptMsg = codeMaps.get(exceptCode);
//			content = ByteString.copyFromUtf8(String.valueOf(false));
//		}
		
		/** 1. 更新网吧信息缓存 */
		StatBarInstancerCacher.updateCache(getBarId(ctx), barPcInstantInfoList, false);
		
//		if(null != currentInstance) {
//			/** 2. 更新区域信息缓存 */
//			StatAreaInstanceCacher.update(getBarId(ctx), currentInstance.getLogin());
//		}
		
		Message response = getResponseMsg(ctx, message.getId(), exceptCode, exceptMsg, content, message.getMethod());
		ctx.writeAndFlush(response);
		
	}

	/**
	 * 上报客户机信息列表
	 * @param ctx
	 * @param message
	 */
	private void doSetPcInfoList(ChannelHandlerContext ctx, Message message) {
		PcInfoList pcInfoList = null;
		try {
			pcInfoList = Wenhua.PcInfoList.parseFrom(message.getContent());
		} catch (InvalidProtocolBufferException e) {
			logger.error(String.format("##SetPcInfoList ChannelShortId: %s RemoteIp: MessageId: %s %s InvalidProtocol", getChannelShortId(ctx), getRemoteIp(ctx), message.getId()), e);
			return;
		}
		List<PcInfo> infosList = pcInfoList.getInfosList();
		logger.info(String.format("##SetPcInfoList ChannelShortId: %s RemoteIp: %s MessageId: %s PcInfoListSize: %d", getChannelShortId(ctx), getRemoteIp(ctx), message.getId(), null == infosList ? 0 : infosList.size()));
		
		if(null == infosList || 0 == infosList.size()) return;
		
		List<com.wenhua.svr.domain.PcInfo> barPcInfoList = new ArrayList<com.wenhua.svr.domain.PcInfo>(infosList.size());
		for(PcInfo info : infosList) {
			com.wenhua.svr.domain.PcInfo pc = com.wenhua.svr.domain.PcInfo.newOne(
					info.getMac(), 
					info.getIp(), 
					info.getPcname(), 
					info.getOsType(), 
					info.getOsVersion(), 
					info.getWenhuaVer(),
					String.valueOf(getBarId(ctx)), 
					TCP_SERVER);
			
			barPcInfoList.add(pc);
		}
		
		if(logger.isInfoEnabled()) {
			logger.info(
					String.format(
							"##SetPcInfoList ChannelShortId: %s RemoteIp: %s MessageId: %s PcInfoList: %s", 
							getChannelShortId(ctx), 
							getRemoteIp(ctx), 
							message.getId(),
							JSON.toJSONString(barPcInfoList)));
		}
		
		int exceptCode = 0;
		String exceptMsg = null;
		ByteString content = null;
		
		try {
			authService.updatePcInfoList(getBarId(ctx), barPcInfoList);
			exceptCode = 0;
			exceptMsg = codeMaps.get(exceptCode);
			content = ByteString.copyFromUtf8(String.valueOf(true));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			exceptCode = 1004;
			exceptMsg = codeMaps.get(exceptCode);
			content = ByteString.copyFromUtf8(String.valueOf(false));
		}
		
		Message response = getResponseMsg(ctx, message.getId(), exceptCode, exceptMsg, content, message.getMethod());
		ctx.writeAndFlush(response);
		
	}

	/**
	 * 上报服务器信息
	 * @param ctx
	 * @param message
	 * @throws AuthBarNotExistException 
	 */
	private void doSetServerInfo(ChannelHandlerContext ctx, Message message) throws AuthBarNotExistException {
		ServerInfo serverInfo = null;
		try {
			serverInfo = Wenhua.ServerInfo.parseFrom(message.getContent());
		} catch (InvalidProtocolBufferException e) {
			logger.error(String.format("##SetServerInfo ChannelShortId: %s RemoteIp: %s MessageId: %s InvalidProtocol", getChannelShortId(ctx), getRemoteIp(ctx), message.getId()), e);
			return;
		}
		logger.info(
				String.format(
						"##SetServerInfo ChannelShortId: %s remoteIp: %s messageId: %s mac: %s ip: %s pcname: %s os_type: %d os_version:%s wenhua_ver:%s", 
						getChannelShortId(ctx),
						getRemoteIp(ctx), 
						message.getId(),
						serverInfo.getMac(), 
						serverInfo.getIp(), 
						serverInfo.getPcname(), 
						serverInfo.getOsType(), 
						serverInfo.getOsVersion(),
						serverInfo.getWenhuaVer()
						)
				);
		
		com.wenhua.svr.domain.ServerInfo si = com.wenhua.svr.domain.ServerInfo.newOne(
				String.valueOf(getBarId(ctx)),
				serverInfo.getMac(), 
				serverInfo.getIp(), 
				serverInfo.getPcname(), 
				serverInfo.getOsType(),
				serverInfo.getOsVersion(),
				serverInfo.getWenhuaVer(),
				TCP_SERVER);
		
		int exceptCode = 0;
		String exceptMsg = null;
		ByteString content = null;
		try {
			authService.setServerInfo(si);
			exceptCode = 0;
			exceptMsg = codeMaps.get(exceptCode);
			content = ByteString.copyFromUtf8(String.valueOf(true));
		} catch (AuthBarNotExistException e) {
			exceptCode = 1002;
			exceptMsg = codeMaps.get(exceptCode);
			content = ByteString.copyFromUtf8(String.valueOf(false));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			exceptMsg = codeMaps.get(exceptCode);
			content = ByteString.copyFromUtf8(String.valueOf(false));
		}
		
		Message response = getResponseMsg(ctx, message.getId(), exceptCode, exceptMsg, content, message.getMethod());
		
		ctx.writeAndFlush(response);
	}

	private void doGetConfig(ChannelHandlerContext ctx, Message message) throws AuthBarNotExistException {
		ByteString content = message.getContent();
		String barId = content.toStringUtf8();
		logger.info(String.format("##GetConfig ChannelShortId: %s RemoteIp: %s MessageId: %s BarId: %s", getChannelShortId(ctx), getRemoteIp(ctx), message.getId(), barId));
		
		int exceptCode = 0;
		String exceptMsg = null;
		try {
			BarConfig myConfig = authService.getBarConfig(barId);
			exceptCode = 0;
			exceptMsg = codeMaps.get(exceptCode);
			com.wenhua.proto.Wenhua.BarConfig config = Wenhua.BarConfig.newBuilder()
					.setFreqInstantPcInfo(myConfig.getFreqInstantPcInfo())
					.setBarID(barId)
					.build();
			content = config.toByteString();
			
			logger.info(String.format(
					"##GetConfig ChannelShortId: %s RemoteIp: %s MessageId: %s BarId: %s return: freqInstancePcInfo [%d] barId [%s]", 
					getChannelShortId(ctx),
					getRemoteIp(ctx),
					message.getId(),
					barId,
					myConfig.getFreqInstantPcInfo(),
					barId
					));
			
		} catch (AuthBarNotExistException e) {
			exceptCode = 1002;
			exceptMsg = codeMaps.get(exceptCode);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			exceptCode = 1004;
			exceptMsg = codeMaps.get(exceptCode);
			content = ByteString.copyFromUtf8(String.valueOf(false));
		}
		
		Message response = getResponseMsg(ctx, message.getId(), exceptCode, exceptMsg, content, message.getMethod());
		
		ctx.writeAndFlush(response);
	}

	/**
	 * 处理验证请求
	 * @param message
	 * @throws AuthSignNotValidException 
	 * @throws AuthBarNotExistException 
	 */
	private void doAuthentication(ChannelHandlerContext ctx, Message message) {
		AuthInfo authInfo = null;
		try {
			authInfo = Wenhua.AuthInfo.parseFrom(message.getContent());
		} catch (InvalidProtocolBufferException e) {
			invalidRequestCloseChannel(ctx, message.getId(), 1009, message.getMethod(), e);
			return;
		}
		String barID = authInfo.getBarID();
		logger.info(String.format("##Authentication ChannelShortId: %s RemoteIp: %s MessageId: %s BarId: %s When: %s Sign: %s", getChannelShortId(ctx), getRemoteIp(ctx), message.getId(), barID, authInfo.getWhen(), authInfo.getSign()));
		
		int exceptCode = 0;
		String exceptMsg = null;
		ByteString content = null;
		boolean close = false;
		
		try {
			NetBar bar = authService.isAuth(new BarAuthInfo(barID, authInfo.getWhen(), authInfo.getSign()));
			exceptCode = 0;
			exceptMsg = codeMaps.get(exceptCode);
			content = ByteString.copyFromUtf8(String.valueOf(true));
			
			/** 將Channel关联BarId */
			Attribute<Object> attr = ctx.channel().attr(AttributeKey.valueOf(BAR_ID));
			attr.set(barID);
			
			/** channel池中关联网吧id与channel */
			ChannelGroups.bind(barID, ctx);
			
			StatAreaInstanceCacher.activeBar(barID);
			StatBarInstancerCacher.addOrUpdate(bar);
			
			String areaCode = BarIdUtils.getAreaCode(barID);
			int maxBar = authService.countNetBarByAreaCode(areaCode);
			int maxPc = authService.countNetBarPcByAreaCode(areaCode);
			StatAreaInstanceCacher.updateArea(areaCode, maxBar, maxPc);
			
		} catch (AuthBarNotExistException e) {
			close = true;
			exceptCode = 1002;
			exceptMsg = codeMaps.get(exceptCode);
			content = ByteString.copyFromUtf8(String.valueOf(false));
		} catch (AuthSignNotValidException e) {
			close = true;
			exceptCode = 1003;
			exceptMsg = codeMaps.get(exceptCode);
			content = ByteString.copyFromUtf8(String.valueOf(false));
		} catch (AuthBarNotValidException e) {
			close = true;
			exceptCode = 1008;
			exceptMsg = codeMaps.get(exceptCode);
			content = ByteString.copyFromUtf8(String.valueOf(false));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			close = true;
			exceptCode = 1004;
			exceptMsg = codeMaps.get(exceptCode);
			content = ByteString.copyFromUtf8(String.valueOf(false));
		}
		
		Message response = getResponseMsg(ctx, message.getId(), exceptCode, exceptMsg, content, message.getMethod());
		ChannelFuture future = ctx.writeAndFlush(response);
		
		if(close) {
			future.addListener(ChannelFutureListener.CLOSE);
		}
	}
	
	private void logMsg(ChannelHandlerContext ctx, WenhuaMsg.Message message) {
		String content = String.format(
			"##From ChannelShortId: %s remoteIp: [%s] ReceivedMsg: Id[%d] Method[%s] ReturnCode[%d] ReturnMsg[%s]", 
			getChannelShortId(ctx),
			getRemoteIp(ctx),
			message.getId(),
			message.getMethod(), 
			message.getExceptCode(),
			message.getExceptMsg()
			);
		logger.info(
				content
				);
	}
	
	@Override
	public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
//		logger.debug(String.format("##readComplete ChannelShortId: %s remoteId: %s", getChannelShortId(ctx), getRemoteIp(ctx)));
		super.channelReadComplete(ctx);
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		
		if(cause instanceof TimeoutException) {
			logger.info(String.format("##Time out ChannelShortId: %s remoteId: %s barId: %s", getChannelShortId(ctx), getRemoteIp(ctx), getBarId(ctx)));
		} else if(cause instanceof IOException) {
			logger.error(String.format("##exceptionCaught ChannelShortId: %s remoteId: %s excpetionMsg: %s", getChannelShortId(ctx), getRemoteIp(ctx), cause.getMessage()));
		} else {
			logger.error(String.format("##exceptionCaught ChannelShortId: %s remoteId: %s excpetionMsg: %s", getChannelShortId(ctx), getRemoteIp(ctx), cause.getMessage()), cause);
		}
		ctx.close();
//		super.exceptionCaught(ctx, cause);
	}

	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}

	public Map<Integer, String> getCodeMaps() {
		return codeMaps;
	}

	public void setCodeMaps(Map<Integer, String> codeMaps) {
		this.codeMaps = codeMaps;
	}

}
