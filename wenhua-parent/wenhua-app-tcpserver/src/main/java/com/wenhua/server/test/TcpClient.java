package com.wenhua.server.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wenhua.proto.WenhuaMsg;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;

public class TcpClient implements Runnable {
	
	private String remoteAddress;
	private int port;
	private int clientNum;
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	public TcpClient(String remoteAddress, int port, int clientNum) {
		this.remoteAddress = remoteAddress;
		this.port = port;
		this.clientNum = clientNum;
		System.out.println("Create " + clientNum + "; " + remoteAddress + " ;" + port);
		
	}

	public void start(String remoteAddress, int port) throws Exception {
		NioEventLoopGroup group = new NioEventLoopGroup(1);
		
		try {
			Bootstrap b = new Bootstrap();
			b
				.group(group)
				.channel(NioSocketChannel.class)
				.remoteAddress(remoteAddress, port)
				.handler(
						new ChannelInitializer<SocketChannel>() {
							protected void initChannel(SocketChannel ch) throws Exception {
								
								ChannelPipeline pipeline = ch.pipeline();
								
								pipeline.addLast(new LengthFieldPrepender(4));
								pipeline.addLast(new ProtobufEncoder());
								
								pipeline.addLast(new LengthFieldBasedFrameDecoder(1024 * 1024, 0, 4, 0, 4));
								pipeline.addLast(new ProtobufDecoder(WenhuaMsg.Message.getDefaultInstance()));
								
								pipeline.addLast(new ChannelHandlerWenhuaMsgClient());
							};
					});
			
			ChannelFuture f = b.connect().sync();
			
			Thread.sleep(60 * 1000);
			
			f.channel().close().sync();
			
		} finally {
			group.shutdownGracefully().sync();
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
//		for(int i = 0; i < 10000; i++) {
			TcpClient client = new TcpClient("127.0.0.1", 9527, 1);
//			TcpClient client = new TcpClient("202.109.114.115", 9527, 1);
			Thread t = new Thread(client);
			t.start();
			
			Thread.sleep(60 * 1000);
			
//		}
		
	}

	@Override
	public void run() {
		try {
			start(remoteAddress, port);
		} catch (Exception e) {
			logger.info("ClientNum: " + clientNum + " Msg: " + e.getMessage());
		}
	}
}
