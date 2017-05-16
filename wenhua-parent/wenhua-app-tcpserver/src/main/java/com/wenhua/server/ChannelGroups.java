package com.wenhua.server;

import static com.wenhua.server.ChannelUtils.getRemoteIp;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wenhua.util.BarIdUtils;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.ChannelGroupFuture;
import io.netty.channel.group.ChannelMatcher;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;

public class ChannelGroups {

	private static final ChannelGroup CHANNEL_GROUP = new DefaultChannelGroup("ChannelGroups",
			GlobalEventExecutor.INSTANCE);
	
	/** 每个IP地址连接数的统计信息 */
	private static final Map<String, AtomicInteger> ipConnectCounter = new ConcurrentHashMap<>();
	
	/** 关联网吧 BAR_ID 与链接信息 */
	private static final Map<String, ChannelHandlerContext> BAR_CHANNEL_MAP = new ConcurrentHashMap<>();
	
	private static Logger logger = LoggerFactory.getLogger(ChannelGroups.class);
	
	public static void add(ChannelHandlerContext ctx) {
		Channel channel = ctx.channel();
		CHANNEL_GROUP.add(channel);
		
		String remoteIp = getRemoteIp(ctx);
		
		AtomicInteger counter = null;
		synchronized (ipConnectCounter) {
			counter = ipConnectCounter.get(remoteIp);
			if(null == counter) {
				counter = new AtomicInteger(0);
				ipConnectCounter.put(remoteIp, counter);
			}
		}
		int c = counter.incrementAndGet();
		
		
		
		logger.info(String.format("##Channel: %s is added into ChannelGroups, current size: %d. The connect num of Ip: [%s] is [%d]", channel.id().asLongText(), CHANNEL_GROUP.size(), remoteIp, c));
	}

	public static ChannelGroupFuture broadcast(Object msg) {
		return CHANNEL_GROUP.writeAndFlush(msg);
	}

	public static ChannelGroupFuture broadcast(Object msg, ChannelMatcher matcher) {
		return CHANNEL_GROUP.writeAndFlush(msg, matcher);
	}

	public static ChannelGroup flush() {
		return CHANNEL_GROUP.flush();
	}
	
	/**
	 * 根据barId获取channel
	 * @param barId
	 * @return
	 */
	public static ChannelHandlerContext getChannelContext(String barId) {
		return BAR_CHANNEL_MAP.get(barId);
	}
	
	/**
	 * 手动关闭某个网吧的channel
	 * @param barId
	 * @return
	 */
	public static boolean close(String barId) {
		if(!BarIdUtils.isValid(barId)) return false;
		ChannelHandlerContext ctx = BAR_CHANNEL_MAP.get(barId);
		if(null == ctx) return false;
		
		ctx.close();
		
		logger.info(String.format("##Channel of barId: [%s] is closed by forced", barId));
		return true;
	}

	public static boolean discard(ChannelHandlerContext ctx) {
		Channel channel = ctx.channel();
		boolean flag = CHANNEL_GROUP.remove(channel);
		
		String remoteIp = getRemoteIp(ctx);
		
		AtomicInteger counter = ipConnectCounter.get(remoteIp);
		int c = 0;
		if(null != counter) {
			c = counter.decrementAndGet();
			
			if(0 == c) {
				ipConnectCounter.remove(remoteIp);
			}
		}
		
		logger.debug("###################################");
		logger.debug("###################################");
		logger.info(String.format("##Channel: %s is removed from ChannelGroups, current size: %d. The connect num of Ip: [%s] is [%d]", channel.id().asShortText(), CHANNEL_GROUP.size(), remoteIp, c));
		logger.debug("###################################");
		logger.debug("###################################");
		return flag;
	}

	public static ChannelGroupFuture disconnect() {
		return CHANNEL_GROUP.disconnect();
	}

	public static ChannelGroupFuture disconnect(ChannelMatcher matcher) {
		return CHANNEL_GROUP.disconnect(matcher);
	}

	public static boolean contains(Channel channel) {
		return CHANNEL_GROUP.contains(channel);
	}

	public static int size() {
		int activeChannelSize = CHANNEL_GROUP.size();
		logger.info(String.format("##Get active channel size from channels group, size is: %s", activeChannelSize));
		return activeChannelSize;
	}
	
	/**
	 * 关联网吧ID与channel信息
	 * @param barId
	 * @param ctx
	 * @return
	 */
	public static void bind(String barId, ChannelHandlerContext ctx) {
		ChannelHandlerContext previous = BAR_CHANNEL_MAP.put(barId, ctx);
		// 关闭老的连接
		if(null != previous) {
			previous.close();
		}
	}
}
