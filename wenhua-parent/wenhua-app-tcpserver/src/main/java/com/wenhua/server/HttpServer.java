package com.wenhua.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class HttpServer implements Runnable {

	private EventLoopGroup bossGroup = null; // (1)
	private EventLoopGroup workerGroup = null;
	
	private int defaultPort = 8088;

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private ChannelInitializer<SocketChannel> initializer = null;

	public HttpServer(EventLoopGroup bossGroup, EventLoopGroup workerGroup) {
		logger.info("##HttpServer bean inited");
		bossGroup = new NioEventLoopGroup(); // (1)
		workerGroup = new NioEventLoopGroup();
	}

	@Override
	public void run() {

		try {
			ServerBootstrap b = getProtobufBootstrap(bossGroup, workerGroup);
			ChannelFuture f = b.bind(defaultPort).sync();
			
			logger.info("##HttpServer start at [" + defaultPort + "]...");
			f.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

//		System.err.println(
//				"Open your web browser and navigate to " + (SSL ? "https" : "http") + "://127.0.0.1:" + PORT + '/');
	}

	private ServerBootstrap getProtobufBootstrap(EventLoopGroup bossGroup, EventLoopGroup workerGroup) {
		ServerBootstrap b = new ServerBootstrap();
		b
			.option(ChannelOption.SO_BACKLOG, 1024)
			.group(bossGroup, workerGroup)
			.channel(NioServerSocketChannel.class)
			.childHandler(initializer);

		return b;
	}

	public EventLoopGroup getBossGroup() {
		return bossGroup;
	}

	public void setBossGroup(EventLoopGroup bossGroup) {
		this.bossGroup = bossGroup;
	}

	public EventLoopGroup getWorkerGroup() {
		return workerGroup;
	}

	public void setWorkerGroup(EventLoopGroup workerGroup) {
		this.workerGroup = workerGroup;
	}

	public int getDefaultPort() {
		return defaultPort;
	}

	public void setDefaultPort(int defaultPort) {
		this.defaultPort = defaultPort;
	}

	public ChannelInitializer<SocketChannel> getInitializer() {
		return initializer;
	}

	public void setInitializer(ChannelInitializer<SocketChannel> initializer) {
		this.initializer = initializer;
	}

}
