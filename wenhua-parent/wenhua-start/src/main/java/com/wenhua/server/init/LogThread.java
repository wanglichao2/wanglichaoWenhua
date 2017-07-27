package com.wenhua.server.init;

import java.io.File;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.wenhua.server.ChannelGroups;
import com.wenhua.server.util.FileUtil;


@Component
public class LogThread {
	
	@PostConstruct
	public void log(){
		System.out.println("start log.......");
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					String fg="------------------------sssssssssssss------------------------------------";
					System.out.println(fg);
					try {
						TimeUnit.SECONDS.sleep(30);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					String path=FileUtil.class.getClassLoader().getResource("").getPath();
					String fileurl= path.substring(0,path.indexOf("wenhua-start"))+"log"+File.separator;
					String info=new Date()+ChannelGroups.showChannelInfo();
					FileUtil.writeContent(fileurl, "NETTY_CHANNEL.LOG", fg);
					FileUtil.writeContent(fileurl, "NETTY_CHANNEL.LOG", info);
				}
				
			}
		}).start();
	}

}
