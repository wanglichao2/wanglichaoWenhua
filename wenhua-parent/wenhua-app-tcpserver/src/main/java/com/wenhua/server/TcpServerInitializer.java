package com.wenhua.server;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.wenhua.proto.WenhuaMsg;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.timeout.ReadTimeoutHandler;

public class TcpServerInitializer extends ChannelInitializer<SocketChannel> implements ApplicationContextAware {

	private ApplicationContext applicationContext;
	private int timeoutSeconds;
	
	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		ChannelPipeline pipeline = ch.pipeline();
		// OUT registe before IN
		pipeline.addLast(new LengthFieldPrepender(4));
		pipeline.addLast(new ProtobufEncoder());
		
		pipeline.addLast(new LengthFieldBasedFrameDecoder(1024 * 1024 * 10, 0, 4, 0, 4));
		pipeline.addLast(new ProtobufDecoder(WenhuaMsg.Message.getDefaultInstance()));
		
		pipeline.addLast(new ReadTimeoutHandler(timeoutSeconds * 3));
		//business logical
		pipeline.addLast(this.applicationContext.getBean("channelHandlerWenhuaMsg", ChannelHandlerWenhuaMsg.class));
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	public int getTimeoutSeconds() {
		return timeoutSeconds;
	}

	public void setTimeoutSeconds(int timeoutSeconds) {
		this.timeoutSeconds = timeoutSeconds;
	}

}
