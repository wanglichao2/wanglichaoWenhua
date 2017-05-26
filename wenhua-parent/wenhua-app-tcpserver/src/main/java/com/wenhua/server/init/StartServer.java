package com.wenhua.server.init;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.wenhua.server.HttpServer;
import com.wenhua.server.TcpServer;

@Component
public class StartServer {
	private Logger log=LoggerFactory.getLogger(StartServer.class);
	
	@Autowired
	private TcpServer tcpServer;
	@Autowired
	private HttpServer httpServer;
	
	@PostConstruct
	public void start(){
		try {
			log.info("start to start http&tcp servee....");
//			int tcpPort = 9527;
			int httpPort = 8088;
			final Integer tcpPort = tcpServer.getDefaultPort();
			httpPort = httpServer.getDefaultPort();
				
			
			Thread httpThread = new Thread(httpServer);
			httpThread.start();
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					tcpServer.start(tcpPort);
				}
			}).start();
			
			log.info("finish to start http&tcp servee....");
		} catch (Exception e) {
			// TODO: handle exception
			log.error("",e);
		}
	}

}
