package com.wenhua.server;

import static com.wenhua.server.ChannelUtils.getChannelShortId;
import static io.netty.handler.codec.http.HttpResponseStatus.OK;
import static io.netty.handler.codec.http.HttpVersion.HTTP_1_1;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.wenhua.server.vo.StatAreaVo;
import com.wenhua.server.vo.StatBarVo;
import com.wenhua.svr.component.StatAreaInstanceCacher;
import com.wenhua.svr.component.StatBarInstancerCacher;
import com.wenhua.svr.domain.NetBar;
import com.wenhua.svr.domain.StatAreaInstance;
import com.wenhua.svr.domain.StatAreaInstanceCity;
import com.wenhua.svr.domain.StatBarInstance;
import com.wenhua.svr.exception.AuthBarNotExistException;
import com.wenhua.svr.exception.AuthBarNotValidException;
import com.wenhua.svr.service.AuthService;
import com.wenhua.util.BarIdUtils;
import com.wenhua.util.base.AjaxResult;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpContent;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.handler.timeout.TimeoutException;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;

public class ChannelHandlerHttp extends ChannelInboundHandlerAdapter {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private static final String URL_PROVINCE = "/province/";
	private static final String URL_CITY = "/city/";
	private static final String URL_AREA = "/area/";
	private static final String URL_UPDATE_AREA = "/update_area/";
	private static final String URL_UPDATE_BAR = "/update_bar/";
	private static final String URL_ADD_BAR = "/add_bar/";
	private static final String URL_PROVINCE_USER="/user/province/";
	private static final String URL_CITY_USER = "/user/city/";
	private static final String URL_AREA_USER = "/user/area/";
	
	
	private static final String SEP = "/";
	
	protected static final String IS_BAR_DELETED = "IS_BAR_DELETED";

	private HttpRequest request = null;
	private String uri = null;
	private String param = null;
	
	private AuthService authService;
	

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		super.channelActive(ctx);
	}
	
	private String getRemoteIp(ChannelHandlerContext ctx) {
		InetSocketAddress remoteAddress = (InetSocketAddress)ctx.channel().remoteAddress();
		String ip = remoteAddress.getAddress().getHostAddress();
		return ip;
	}

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

		List<Object> list = null;
		
		if (msg instanceof HttpRequest) {
			request = (HttpRequest) msg;

			uri = request.uri();
			logger.info(String.format("##Http reqest uri: %s, remoteIp: %s", uri, getRemoteIp(ctx)));
		}
		if (msg instanceof HttpContent) {
			
			try {
				
				if(null == uri) {
					invalidRequestCloseChannel(ctx);
					return;
					
				} else if(uri.startsWith(URL_PROVINCE)) {
					param = uri.substring(URL_PROVINCE.length(), uri.length());
					logger.info(String.format("##Uri begin with: %s, param is: %s", URL_PROVINCE, param));
					list = doProvince();
					
				} else if(uri.startsWith(URL_CITY)) {
					param = uri.substring(URL_CITY.length(), uri.length());
					logger.info(String.format("##Uri begin with: %s, param is: %s", URL_CITY, param));
					list = doCity(param);
					
				} else if(uri.startsWith(URL_AREA)) {
					param = uri.substring(URL_AREA.length(), uri.length());
					logger.info(String.format("##Uri begin with: %s, param is: %s", URL_AREA, param));
					list = doArea(param);
				} else if(uri.startsWith(URL_UPDATE_BAR)) {
					param = uri.substring(URL_UPDATE_BAR.length(), uri.length());
					logger.info(String.format("##Uri begin with: %s, param is: %s", URL_UPDATE_BAR, param));
					doUpdateBar(param);
				
				} else if(uri.startsWith(URL_ADD_BAR)) {
					param = uri.substring(URL_ADD_BAR.length(), uri.length());
					logger.info(String.format("##Uri begin with: %s, param is: %s", URL_ADD_BAR, param));
					doAddBar(param);
					
				} else if(uri.startsWith(URL_UPDATE_AREA)) {
					param = uri.substring(URL_AREA.length(), uri.length());
					
					String[] params = param.split(SEP);
					
					if(null == params || 3 != params.length) {
						invalidRequestCloseChannel(ctx);
						return;
					}
					
					int maxbar = 0;
					int maxPc = 0;
					String areaCode = params[0];
					try {
						maxbar = Integer.parseInt(params[1]);
						maxPc = Integer.parseInt(params[2]);
					} catch (Exception e) {
						invalidRequestCloseChannel(ctx);
						return;
					}
					
					//更新 区域的网吧数与PC数
					StatAreaInstanceCacher.updateArea(areaCode, maxbar, maxPc);
					
				} else if(uri.startsWith(URL_PROVINCE_USER)) {//用户省下所属城市
					param = uri.substring(URL_PROVINCE_USER.length(), uri.length());
					logger.info(String.format("##Uri begin with: %s, param is: %s", URL_PROVINCE_USER, param));
					if(!"".equals(param))
						list = doProvince(Long.parseLong(param));
					else
						logger.error("user is null ");
					
				} else if(uri.startsWith(URL_CITY_USER)) { //用户城市下所属区域
					param = uri.substring(URL_CITY_USER.length(), uri.length());
					logger.info(String.format("##Uri begin with: %s, param is: %s", URL_CITY_USER, param));
					String params[]=param.split(":");
					list = doCity(Long.parseLong(params[0]),params[1]);
					
				} else if(uri.startsWith(URL_AREA_USER)) {
					param = uri.substring(URL_AREA_USER.length(), uri.length());
					logger.info(String.format("##Uri begin with: %s, param is: %s", URL_AREA_USER, param));
					list = doArea(param);
				}else {
					invalidRequestCloseChannel(ctx);
					return;
				}
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
				invalidRequestCloseChannel(ctx, e);
				return;
			}
			
			AjaxResult ajaxResult = AjaxResult.getSuccess("success");
			if(null != list) {
				ajaxResult.addValue("stat", list);
			}

			String res = JSON.toJSONString(ajaxResult);
			logger.info(String.format("response: %s", res));

			FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, OK,
					Unpooled.wrappedBuffer(res.getBytes("UTF-8")));
			response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
			response.headers().set(HttpHeaderNames.CONTENT_LENGTH, response.content().readableBytes());
			if (HttpUtil.isKeepAlive(request)) {
				response.headers().set(HttpHeaderNames.CONNECTION, "keep-alive");
			}
			ctx.write(response);
			ctx.flush();
		}
		super.channelRead(ctx, msg);
	}

	/**
	 * 更新缓存的网吧实时信息 与 相关的区域实时缓存信息
	 * @param param 新增的网吧ID
	 * @throws AuthBarNotExistException
	 * @throws AuthBarNotValidException
	 */
	private void doAddBar(String param) throws AuthBarNotExistException, AuthBarNotValidException {
		if(!BarIdUtils.isValid(param)) {
			throw new AuthBarNotExistException();
		}
		
		NetBar netBar = authService.getNetBar(param);
		
		if(null == netBar) {
			throw new AuthBarNotExistException();
		}
		
		if(!netBar.isValid()) {
			throw new AuthBarNotValidException(
					String.format("##The added bar: %s is not valid. Status of bar is: %d", netBar.getId(), netBar.getIsdeleted()));
		}

		//更新该网吧实时信息缓存
		StatBarInstancerCacher.addOrUpdate(netBar);
		// 新增了网吧 更新所在区域的最大网吧数 与 PC数
		updateStatAreaInstanceCacher(netBar);
	}

	/**
	 * 更新缓存的网吧实时信息 与 相关的区域实时缓存信息
	 * @param param 更新或者删除的网吧ID
	 * @throws AuthBarNotExistException
	 */
	private void doUpdateBar(String param) throws AuthBarNotExistException {
		if(!BarIdUtils.isValid(param)) {
			throw new AuthBarNotExistException(String.format("##The barId: %s is not valid", param));
		}
		NetBar netBar = authService.getNetBar(param);
		
		if(null == netBar) {
			throw new AuthBarNotExistException(String.format("##The barId: %s is not exist", param));
		}
		
		//更新该网吧实时信息缓存
		StatBarInstancerCacher.addOrUpdate(netBar);
		
		if(!netBar.isValid()) {
//			//更新该网吧所在 区 市 省 实时缓存信息
//			StatAreaInstanceCacher.inactiveBar(netBar.getId());
			StatBarInstancerCacher.updateCache(netBar.getId(), null, true);
			
			ChannelHandlerContext ctx = ChannelGroups.getChannelContext(netBar.getId());
			if(null != ctx) {
				/** 如果网吧在线 將Channel 标识 该channel的网吧已被删除 */
				Attribute<Object> attr = ctx.channel().attr(AttributeKey.valueOf(IS_BAR_DELETED));
				attr.set(true);
				
				ChannelGroups.close(netBar.getId());
			}
			
		}
		updateStatAreaInstanceCacher(netBar);
	}
	
	/**
	 * 更新区域缓存信息的最大网吧数与最大PC数
	 * @param netBar
	 */
	private void updateStatAreaInstanceCacher(NetBar netBar) {
		String areaCode = BarIdUtils.getAreaCode(netBar.getId());
		int maxBar = authService.countNetBarByAreaCode(areaCode);
		int maxPc = authService.countNetBarPcByAreaCode(areaCode);
		StatAreaInstanceCacher.updateArea(areaCode, maxBar, maxPc);
	}

	private List<Object> doArea(String areaCode) {

		List<Object> list = new ArrayList<Object>();
		
		List<StatBarInstance> bars = StatBarInstancerCacher.getBarInArea(areaCode);
		for(StatBarInstance bar : bars) {
			list.add(StatBarVo.newOne(bar.getBarId(), bar.getBarName(), bar.getOnline(), bar.getOffline(), bar.getValid(), bar.getServerVersion()));
		}
		return list;
	}

	private List<Object> doCity(String cityCode) {
		List<Object> list = new ArrayList<Object>();
		
		StatAreaInstanceCity city = (StatAreaInstanceCity)StatAreaInstanceCacher.get(cityCode);
		for(StatAreaInstance area : city.getAreas()) {
			StatAreaVo v = StatAreaVo.newOne(
					area.getCode(), 
					area.getName(), 
					area.getOnline().get(), 
					area.getAreaMaxBar() - area.getOnline().get(), 
					area.getAreaMaxPc(), 
					area.getLoginTotal());
			
			list.add(v);
		}
		return list;
	}

	private List<Object> doProvince() {
		List<Object> list = new ArrayList<Object>();
		
		List<StatAreaInstance> cities = StatAreaInstanceCacher.getAllCity();
		for(StatAreaInstance city : cities) {
			StatAreaVo v = StatAreaVo.newOne(
					city.getCode(), 
					city.getName(), 
					city.getOnline().get(), 
					city.getOffline(),
					city.getAreaMaxPc(), 
					city.getLoginTotal());
			
			list.add(v);
		}
		return list;
	}
	
	private List<Object> doProvince(Long userId) {
		if(userId==null)return null;
		List<String> citycodes= this.authService.getCityCodesByUserId(userId);
		if(citycodes==null || citycodes.size()==0)return null;
		List<Object> list = new ArrayList<Object>();
		for(String citycode:citycodes){
			StatAreaInstance city=(StatAreaInstance)StatAreaInstanceCacher.getCity(citycode);
			List<Object> arealist=(List<Object>) this.doCity(userId, citycode);
			int online=0,offline=0,areaMaxPc=0,loginTotal=0;
			if(arealist!=null && !arealist.isEmpty()){
				for(Object obj:arealist){
					StatAreaVo area=(StatAreaVo)obj;
					online+=area.getOnline();
					offline+=area.getOffline();
					areaMaxPc+=area.getPcTotal();
					loginTotal+=area.getLogin();
				}
				
			}
			StatAreaVo v = StatAreaVo.newOne(
					city.getCode(), 
					city.getName(), 
					online, 
					offline,
					areaMaxPc, 
					loginTotal);
			list.add(v);
		}
		
		
		/*List<StatAreaInstance> cities = StatAreaInstanceCacher.getAllCity();
		for(StatAreaInstance city : cities) {
			boolean isExist=false;
			for(String citycode:citycodes){
				if(city.getCode().equals(citycode)){
					isExist=true;
					break;
				}
			}
			if(isExist){
				StatAreaVo v = StatAreaVo.newOne(
						city.getCode(), 
						city.getName(), 
						city.getOnline().get(), 
						city.getOffline(),
						city.getAreaMaxPc(), 
						city.getLoginTotal());
				list.add(v);
			}
		}*/
		return list;
	}
	
	private List<Object> doCity(Long userId,String cityCode) {
		if(userId==null || "".equals(cityCode))return null;
		List<Object> list = new ArrayList<Object>();
		List<String> districtCodes= this.authService.getDistrictCodeByUserId(userId,cityCode);
		StatAreaInstanceCity city = (StatAreaInstanceCity)StatAreaInstanceCacher.get(cityCode);
		for(StatAreaInstance area : city.getAreas()) {
			boolean isExist=false;
			for(String dist:districtCodes){
				if(dist.equals(area.getCode())){
					isExist=true;
					break;
				}
			}
			if(isExist){
				StatAreaVo v = StatAreaVo.newOne(
						area.getCode(), 
						area.getName(), 
						area.getOnline().get(), 
						area.getAreaMaxBar() - area.getOnline().get(), 
						area.getAreaMaxPc(), 
						area.getLoginTotal());
				list.add(v);
			}
		}
		return list;
	}
	
	/*private List<Object> doArea(String areaCode) {

		List<Object> list = new ArrayList<Object>();
		
		List<StatBarInstance> bars = StatBarInstancerCacher.getBarInArea(areaCode);
		for(StatBarInstance bar : bars) {
			list.add(StatBarVo.newOne(bar.getBarId(), bar.getBarName(), bar.getOnline(), bar.getOffline(), bar.getValid(), bar.getServerVersion()));
		}
		return list;
	}*/

	
	
	/**
	 * 请求不合法 关闭Channel
	 * @param ctx
	 * @throws UnsupportedEncodingException 
	 */
	private void invalidRequestCloseChannel(ChannelHandlerContext ctx) throws UnsupportedEncodingException {
		invalidRequestCloseChannel(ctx, null);
	}
	
	/**
	 * 请求不合法 关闭Channel
	 * @param ctx
	 * @param e
	 * @throws UnsupportedEncodingException 
	 */
	private void invalidRequestCloseChannel(ChannelHandlerContext ctx, Throwable e) throws UnsupportedEncodingException {
		AjaxResult result = null;
		if(null == e) {
			result = AjaxResult.getError(String.format("##HttpServer invalid uri: %s", request.uri()));
		} else {
			result = AjaxResult.getError(String.format("##HttpServer invalid uri: %s, exception msg: %s", request.uri(), e.getMessage()));
		}
		
		String res = JSON.toJSONString(result);
		logger.info(String.format("response: %s", res));

		FullHttpResponse response = new DefaultFullHttpResponse(HTTP_1_1, OK,
				Unpooled.wrappedBuffer(res.getBytes("UTF-8")));
		response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
		response.headers().set(HttpHeaderNames.CONTENT_LENGTH, response.content().readableBytes());
		if (HttpUtil.isKeepAlive(request)) {
			response.headers().set(HttpHeaderNames.CONNECTION, "keep-alive");
		}
		ChannelFuture future = ctx.write(response);
		ctx.flush();
		logger.warn(String.format("##HttpServer request invalid. Return response: %s", res));
		future.addListener(ChannelFutureListener.CLOSE);
	}

	public void setAuthService(AuthService authService) {
		this.authService = authService;
	}
	
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		if(cause instanceof TimeoutException) {
			logger.info(String.format("##Time out ChannelShortId: %s remoteId: %s", getChannelShortId(ctx), getRemoteIp(ctx)));
		} else if(cause instanceof IOException) {
			logger.error(String.format("##exceptionCaught ChannelShortId: %s remoteId: %s excpetionMsg: %s", getChannelShortId(ctx), getRemoteIp(ctx), cause.getMessage()));
		} else {
			logger.error(String.format("##exceptionCaught ChannelShortId: %s remoteId: %s excpetionMsg: %s", getChannelShortId(ctx), getRemoteIp(ctx), cause.getMessage()), cause);
		}
		ctx.close();
	}
	
}
