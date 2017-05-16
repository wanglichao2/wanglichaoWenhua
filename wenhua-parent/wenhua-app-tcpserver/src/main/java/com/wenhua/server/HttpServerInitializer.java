package com.wenhua.server;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

public class HttpServerInitializer extends ChannelInitializer<SocketChannel> implements ApplicationContextAware {

	private ApplicationContext applicationContext;


	@Override
	protected void initChannel(SocketChannel ch) throws Exception {
		 // server端发送的是httpResponse，所以要使用HttpResponseEncoder进行编码
        ch.pipeline().addLast(new HttpResponseEncoder());
        // server端接收到的是httpRequest，所以要使用HttpRequestDecoder进行解码
        ch.pipeline().addLast(new HttpRequestDecoder());
        ChannelHandlerHttp handler = this.applicationContext.getBean("channelHandlerHttp", ChannelHandlerHttp.class);
		ch.pipeline().addLast(handler);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
}
