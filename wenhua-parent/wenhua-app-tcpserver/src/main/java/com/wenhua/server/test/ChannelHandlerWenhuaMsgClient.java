package com.wenhua.server.test;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.protobuf.ByteString;
import com.wenhua.proto.Wenhua;
import com.wenhua.proto.Wenhua.AuthInfo;
import com.wenhua.proto.Wenhua.AuthInfo.Builder;
import com.wenhua.proto.Wenhua.PcInfo;
import com.wenhua.proto.Wenhua.PcInfoList;
import com.wenhua.proto.Wenhua.PcInstantInfo;
import com.wenhua.proto.Wenhua.PcInstantInfoList;
import com.wenhua.proto.WenhuaMsg;
import com.wenhua.proto.WenhuaMsg.Message;
import com.wenhua.svr.domain.BarAuthInfo;
import com.wenhua.util.ByteUtil;
import com.wenhua.util.tools.DateUtils;
import com.wenhua.util.tools.NumberUtil;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class ChannelHandlerWenhuaMsgClient extends ChannelInboundHandlerAdapter {

	private Logger logger = LoggerFactory.getLogger(getClass());

	
	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {

		logger.info("MessageProto channelActive");

		WenhuaMsg.Message message = getAuthInfoMessage();
		
		System.out.println(ByteUtil.bytes2hex(message.toByteArray()));

		ctx.writeAndFlush(message);
		
		Thread.sleep(5 * 1000);
		
		message = getSetPcInstantInfoListMessage();
//		message = getFileInfoList();

		System.out.println(ByteUtil.bytes2hex(message.toByteArray()));
		
		ctx.writeAndFlush(message);
		
		super.channelActive(ctx);
	}
	
	@SuppressWarnings("unused")
	private Message getGetFileMessage() {
		com.wenhua.proto.WenhuaMsg.Message message = getNormalMessageBuilder(System.currentTimeMillis(), "GetFile", ByteString.copyFrom(NumberUtil.intToByte4(1000)), 0, "OK").build();
		
		return message;
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		logger.info("##read");
		WenhuaMsg.Message message = (WenhuaMsg.Message) msg;
		String content = String.format(
			"Id[%d] Method[%s] Content[%s] ReturnCode[%d] ReturnMsg[%s]", 
			message.getId(),
			message.getMethod(), 
			message.getContent().toStringUtf8(), 
			message.getExceptCode(),
			message.getExceptMsg()
			);
		logger.info(
				content
				);
		
//		message = getFileInfoList();
//		System.out.println(ByteUtil.bytes2hex(message.toByteArray()));
//		ctx.writeAndFlush(message);
//		logger.info("send to server");
		super.channelRead(ctx, msg);
	}
	
	@Override
	public void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception {
		
		logger.info("begin write");
		
		
		super.channelWritabilityChanged(ctx);
	}
	
	private WenhuaMsg.Message getFileInfoList() {
		
		Message message = getNormalMessageBuilder(System.currentTimeMillis(), "GetFileInfoList", null, 0, "OK").build();
		
		return message;
	}
	
	@SuppressWarnings("unused")
	private WenhuaMsg.Message getSetPcInstantInfoListMessage() {
		
		PcInstantInfoList list = Wenhua.PcInstantInfoList.newBuilder()
			.addInfos(getPcInstantInfo())
			.addInfos(getPcInstantInfo())
			.addInfos(getPcInstantInfo())
			.addInfos(getPcInstantInfo())
			.build();
		
		com.wenhua.proto.WenhuaMsg.Message message = getNormalMessageBuilder(System.currentTimeMillis(), "SetInstantPcInfoList", list.toByteString(), 0, "OK").build();
		
		return message;
	}
	
	private PcInstantInfo getPcInstantInfo() {
		PcInstantInfo pcInstantInfo = Wenhua.PcInstantInfo.newBuilder()
			.setIsPowerOn(true)
			.setIsUserLogin(true)
			.setWenhuaDuration(3600)
			.setPoweronDuration(3600)
			.setIsRunWenhua(true)
			.setMac("AA-BB-CC-DD-EE-FF")
			.build();
		return pcInstantInfo;
	}

	@SuppressWarnings("unused")
	private WenhuaMsg.Message setPcInfoList() {
		
		PcInfoList pcInfoList = Wenhua.PcInfoList.newBuilder()
			.addInfos(getPcInfo())
			.addInfos(getPcInfo())
			.build();
		
		com.wenhua.proto.WenhuaMsg.Message message = getNormalMessageBuilder(System.currentTimeMillis(), "SetPcInfoList", pcInfoList.toByteString(), 0, "OK").build();
		
		return message;
	}
	
	private Wenhua.PcInfo getPcInfo() {
		
		PcInfo pcInfo = Wenhua.PcInfo.newBuilder()
			.setIp("192.168.1.2")
			.setMac("11-22-33-44-55-66")
			.setPcname("PC-TEST")
			.setOsType(1)
			.setOsVersion("OS X")
			.build();
		
		return pcInfo;
	}
	
	/**
	 * 获取配置请求消息体
	 * @return
	 */
	@SuppressWarnings("unused")
	private WenhuaMsg.Message getBarConfig() {
//		Integer barId = Integer.valueOf(RandomNumberGenerator.generateNumber());
		Integer barId = 30;
		com.wenhua.proto.WenhuaMsg.Message.Builder builder = getNormalMessageBuilder(System.currentTimeMillis(), "GetConfig", ByteString.copyFrom(NumberUtil.intToByte4(barId)), 0, "OK");
		
		return builder.build();
	}
	
	/**
	 * 获取上报服务器配置消息体
	 * @return
	 */
	@SuppressWarnings("unused")
	private WenhuaMsg.Message getServerInfoMessage() {
		com.wenhua.proto.Wenhua.ServerInfo serverInfo = Wenhua.ServerInfo.newBuilder()
			.setIp("192.168.1.2")
			.setMac("00-AA-DD-FF-GG-HH")
			.setPcname("BOSS-PC")
			.setOsType(1)
			.setOsVersion("windows 7")
			.build();
		
		return getNormalMessageBuilder(System.currentTimeMillis(), "SetServerInfo", serverInfo.toByteString(), 0, "OK").build();
	}
	
	/**
	 * 获取验证消息体
	 * @return
	 */
	private WenhuaMsg.Message getAuthInfoMessage() {
		
		String barId = "4102020003";
		String when = DateUtils.getString(new Date());
		String key = "hn123wh";
		
		Builder builder = Wenhua.AuthInfo.newBuilder()
			.setBarID(barId)
//			.setSign(Md5Util.getMD5HexString(target))
			.setSign(BarAuthInfo.getMD5(barId, when, key))
			.setWhen(when);
			
		
		AuthInfo authInfo = builder.build();
		
		com.wenhua.proto.WenhuaMsg.Message.Builder normalMessageBuilder = getNormalMessageBuilder(System.currentTimeMillis(), "Authentication", authInfo.toByteString(), 0, "OK");
		
		return normalMessageBuilder.build();
	}

	private com.wenhua.proto.WenhuaMsg.Message.Builder getNormalMessageBuilder(
			Long id,
			String method,
			ByteString content,
			int exceptCode,
			String exceptMsg
			) {
		com.wenhua.proto.WenhuaMsg.Message.Builder builder = WenhuaMsg.Message.newBuilder().
				setId(id)
				.setMethod(method)
				.setExceptCode(exceptCode)
				.setExceptMsg(exceptMsg);
		
		if(null != content) {
			builder.setContent(content);
		}
		return builder;
	}

}
