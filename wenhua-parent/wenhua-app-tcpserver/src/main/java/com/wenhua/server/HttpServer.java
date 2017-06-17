package com.wenhua.server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.wenhua.server.vo.StatAreaVo;
import com.wenhua.server.vo.StatBarVo;
import com.wenhua.svr.component.StatAreaInstanceCacher;
import com.wenhua.svr.component.StatBarInstancerCacher;
/*import com.wenhua.svr.dao.UploadDao;*/
import com.wenhua.svr.domain.BarAuthInfo;
import com.wenhua.svr.domain.BarOnlineStatistic;
import com.wenhua.svr.domain.NetBar;
import com.wenhua.svr.domain.StatAreaInstance;
import com.wenhua.svr.domain.StatAreaInstanceCity;
import com.wenhua.svr.exception.AuthBarNotExistException;
import com.wenhua.svr.exception.AuthBarNotValidException;
import com.wenhua.svr.exception.AuthSignNotValidException;
import com.wenhua.svr.service.AuthService;
import com.wenhua.svr.service.impl.AuthServiceImpl;

import gov.ccm.netbar.interfaceImp.controlInfo.CustomerOnlineInfo;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import uploadutil.UploadgetData;
import uploadutil.WebServiceUtilUpload;

public class HttpServer implements Runnable {

	private EventLoopGroup bossGroup = null; // (1)
	private EventLoopGroup workerGroup = null;
	
	private int defaultPort = 8088;

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	private ChannelInitializer<SocketChannel> initializer = null;
	private ApplicationContext applicationContext;
	
	//private AuthService authService;
	//private  UploadDao uploadDao;
	public HttpServer(EventLoopGroup bossGroup, EventLoopGroup workerGroup) {
		logger.info("##HttpServer bean inited");
		bossGroup = new NioEventLoopGroup(); // (1)
		workerGroup = new NioEventLoopGroup();
	}

	@Override
	public void run() {
		List<StatAreaVo> list=null;
		

		try {
			ServerBootstrap b = getProtobufBootstrap(bossGroup, workerGroup);
			ChannelFuture f = b.bind(defaultPort).sync();
			logger.info("##HttpServer start at [" + defaultPort + "]...");
			logger.info("=============下面是我的上传的方法==============================");
			
			//StatBarInstancerCacher statBarinstcacher=new StatBarInstancerCacher();
			//BarOnlineStatistic baronlinestatistic=statBarinstcacher.getBarOnLineStatisticsFromCache("4101020017");
			         //  logger.info("在线数目======》"+baronlinestatistic.getOnlineNum());
			/*
			AuthServiceImpl ausimpl=new AuthServiceImpl();
			int num=ausimpl.countNetBarPcInProvince();
			logger.info("============省内网吧的总数：====》"+num);*/
			
			//	logger.info("========是否可以查到所有的网吧信息呢？=======》"+n.getCityCode());
			        //   List<CustomerOnlineInfo> clist3=null;
			           
			      /// clist3=uploadDao.selectcustomeronlineInfo();
			      // for (CustomerOnlineInfo customerOnlineInfo : clist3) {
					//logger.info("====查询结果：=====>"+customerOnlineInfo.getNetbar_code());
				//}
			  List<CustomerOnlineInfo> clist2=null;
			  boolean flag=true;
			  UploadgetData upgetdata=new UploadgetData();
			  String res="";
			     while(flag){
			    	 int result=0;
			    	   try {
						Thread.sleep(1000*60*10);
						WebServiceUtilUpload webseruupload=new WebServiceUtilUpload();
						String key=webseruupload.login();
						 System.out.println("=====每10分钟登陆一下这个接口=======>"+key);
						 Date date= new Date();
						 int hours = date.getHours();
						 if(hours>=23){
							 /*   下面这个方法是：  场所上网信息上传            */
							 if(upgetdata.getAll().size()>0){
									res= webseruupload.sendCustomerOnlineInfo(upgetdata.getAll());//返回上传的结果successful/failing
									System.out.println("===========线程调用上传的结果：=====》"+res);
									 if(res.equals("successful")){
									      clist2= upgetdata.getAll();
								    	 for(int i=0;i<clist2.size();i++){
								    		String NetBar_code= clist2.get(i).getNetbar_code();
								    		 result= upgetdata.delte(NetBar_code);
								    		if(result>0){
								    			System.out.println("删除成功");
								    			// List<CustomerOnlineInfo> clist3= upgetdata.getAll();
								    		}else if(result<0){
								    			System.out.println("删除失败！");
								    		}
								    	 }
									 }
							 }else if(result<0){
								 return; 
							 }
							 
							 
							 
							 
							 
						 }
					 }catch(Exception e){
						e.printStackTrace();
						
					 }
						
					
			     }
			       
		
			
			
			
			
			
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
