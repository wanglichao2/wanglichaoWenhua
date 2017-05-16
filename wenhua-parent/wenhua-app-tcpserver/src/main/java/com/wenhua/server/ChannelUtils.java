package com.wenhua.server;

import java.net.InetSocketAddress;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;

public class ChannelUtils {

	/**
	 * 获取Channel短id
	 * @param ctx
	 * @return
	 */
	protected static String getChannelShortId(ChannelHandlerContext ctx) {
		Channel channel = ctx.channel();
		ChannelId id = channel.id();
		String shortId = id.asShortText();
		return shortId;
	}
	
	/**
	 * 获取对方IP地址
	 * @param ctx
	 * @return
	 */
	protected static String getRemoteIp(ChannelHandlerContext ctx) {
		InetSocketAddress remoteAddress = (InetSocketAddress)ctx.channel().remoteAddress();
		String ip = remoteAddress.getAddress().getHostAddress();
		return ip;
	}
	
	private ChannelUtils() {
	}
}
