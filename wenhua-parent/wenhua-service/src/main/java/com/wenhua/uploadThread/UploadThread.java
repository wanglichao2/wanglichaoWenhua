package com.wenhua.uploadThread;

import java.io.File;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;



@Component
public class UploadThread {
	@PostConstruct
	public void log(){
		System.out.println("start log.......");
		new Thread(new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true){
					String fg="------------------------可以运行吗------------------------------------";
					System.out.println(fg);
					try {
						TimeUnit.SECONDS.sleep(30);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					
				}
				
			}
		}).start();
	}

}