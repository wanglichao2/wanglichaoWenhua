package com.wenhua.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class TcpServer {

	private static Logger logger = LoggerFactory.getLogger(TcpServer.class);
	
	private ChannelInitializer<SocketChannel> initializer;
	
	private EventLoopGroup bossGroup = null; // (1)
	private EventLoopGroup workerGroup = null;
	
	private int defaultPort = 9527;
	
	public TcpServer() {
		logger.info("##TcpServer bean inited");
	}
	
	public void start(int port) {
		
		
		try {
			ServerBootstrap b = getProtobufBootstrap(bossGroup, workerGroup);

			// Bind and start to accept incoming connections.
			ChannelFuture f = b.bind(port).sync(); // (7)
			logger.info("##TcpServer start at [" + port + "]...");
			// Wait until the server socket is closed.
			// In this example, this does not happen, but you can do that to
			// gracefully
			// shut down your server.
			f.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			logger.error("##TcpServer error", e);
		} finally {
			workerGroup.shutdownGracefully();
			bossGroup.shutdownGracefully();
			logger.info("##Server shutdown");
		}
	}

	private ServerBootstrap getProtobufBootstrap(EventLoopGroup bossGroup, EventLoopGroup workerGroup) {
		ServerBootstrap b = new ServerBootstrap(); // (2)
		
		b
			.group(bossGroup, workerGroup)
			.channel(NioServerSocketChannel.class) // (3)
			.childHandler(initializer)
			.option(ChannelOption.SO_BACKLOG, 128) // (5)
			/** 如果端口忙，但TCP状态位于 TIME_WAIT ，可以重用端口 */
			.option(ChannelOption.SO_REUSEADDR, true)
			.childOption(ChannelOption.SO_KEEPALIVE, true); // (6)
		return b;
	}
	
	public static void main(String[] args) {
		logger.info("##Wenhua Mesage Tcp Server starting...");
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ap = new ClassPathXmlApplicationContext("classpath:spring-context.xml");
		TcpServer tcpServer = ap.getBean("tcpServer", TcpServer.class);
		HttpServer httpServer = ap.getBean("httpServer", HttpServer.class);
		
		int tcpPort = 9527;
		int httpPort = 8088;
		if(null == args || 0 == args.length) {
			tcpPort = tcpServer.getDefaultPort();
		} else {
			try {
				tcpPort = Integer.parseInt(args[0]);
			} catch (Exception e) {
				tcpPort = tcpServer.getDefaultPort();
			}
			
			try {
				httpPort = Integer.parseInt(args[1]);
				httpServer.setDefaultPort(httpPort);
			} catch (NumberFormatException e) {
				httpPort = httpServer.getDefaultPort();
			}
		}
		
		Thread httpThread = new Thread(httpServer);
		httpThread.start();
		
		tcpServer.start(tcpPort);
		
	}

	public void setInitializer(ChannelInitializer<SocketChannel> initializer) {
		this.initializer = initializer;
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
	
}
