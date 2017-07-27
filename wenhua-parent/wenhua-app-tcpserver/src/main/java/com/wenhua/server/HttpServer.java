package com.wenhua.server;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.google.protobuf.Method;
import com.wenhua.proto.WenhuaMsg;
import com.wenhua.server.vo.StatAreaVo;
import com.wenhua.server.vo.StatBarVo;
import com.wenhua.svr.component.StatAreaInstanceCacher;
import com.wenhua.svr.component.StatBarInstancerCacher;
/*import com.wenhua.svr.dao.UploadDao;*/
import com.wenhua.svr.domain.BarAuthInfo;
import com.wenhua.svr.domain.BarConfig;
import com.wenhua.svr.domain.BarOnlineStatistic;
import com.wenhua.svr.domain.NetBar;
import com.wenhua.svr.domain.StatAreaInstance;
import com.wenhua.svr.domain.StatAreaInstanceCity;
import com.wenhua.svr.exception.AuthBarNotExistException;
import com.wenhua.svr.exception.AuthBarNotValidException;
import com.wenhua.svr.exception.AuthSignNotValidException;
import com.wenhua.svr.service.AuthService;
import com.wenhua.svr.service.impl.AuthServiceImpl;
import com.wenhua.util.tools.DateUtils;

import gov.ccm.netbar.interfaceImp.controlInfo.CustomerOnlineInfo;
import gov.ccm.netbar.interfaceImp.controlInfo.ExigencyInfo;
import gov.ccm.netbar.interfaceImp.controlInfo.OnlineTimeTipInfo;
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
	private BarAuthInfo ba;
	private static final Map<String, BarOnlineStatistic> barOnlineStatisticCacher=new ConcurrentHashMap<String,BarOnlineStatistic>();
	private StatBarInstancerCacher sbicacher;
	private AuthService authService;
	private BarOnlineStatistic baronlinestatic;
	private ChannelHandlerWenhuaMsg channelhandlerwmsg;
	private StatBarInstancerCacher startbarinscacher;
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
			/*AuthService authService=startbarinscacher.getAuthService();
			   
			    	List<NetBar> lnetbar=authService.getAllBar();
			    	   for (NetBar netBar : lnetbar) {
						logger.info("网吧信息："+netBar.getNetbarName());
					}*/
			
			    	
			
			/*
             String barId="4101020020";
			BarOnlineStatistic bonlista=sbicacher.getBarOnLineStatisticsFromCache(barId);
			   int oNT=bonlista.getOnlineNumToday();
			   int onlineNumToda=oNT*3;
				List<NetBar> bars = authService.getAllBar();
                 for(int i=0;i<bars.size();i++){
                	 System.out.println("网吧数量："+bars.size());
                 }*/
			   
			/*AuthServiceImpl ausimpl=new AuthServiceImpl();
			int num=ausimpl.countNetBarPcInProvince();
			logger.info("============省内网吧的总数：====》"+num);*/
			
			//	logger.info("========是否可以查到所有的网吧信息呢？=======》"+n.getCityCode());
			        //   List<CustomerOnlineInfo> clist3=null;
			           
			      /// clist3=uploadDao.selectcustomeronlineInfo();
			      // for (CustomerOnlineInfo customerOnlineInfo : clist3) {
					//logger.info("====查询结果：=====>"+customerOnlineInfo.getNetbar_code());
				//}
			  boolean flag=true;
			  UploadgetData upgetdata=new UploadgetData();
			  String res="";
			     while(flag){
			    	 int result=0;
			    	   try {
						//Thread.sleep(1000*60*10);
			    		  Thread.sleep(20000);
			    		  
			    		  BarOnlineStatistic bolst=startbarinscacher.getBarOnLineStatisticsFromCache("4101020024");
			 			 logger.info("============>"+bolst.getBarName()+"=====今日累计====>"+bolst.getOnlineMaxToday()+"====网吧id===>"+bolst.getBarId());
						WebServiceUtilUpload webseruupload=new WebServiceUtilUpload();
						String key=webseruupload.login();
						 System.out.println("=====每10分钟登陆一下这个接口=======>"+key);
						 WenhuaMsg.Message message = (WenhuaMsg.Message) msg;
						// java.lang.reflect.Method method=ChannelHandlerWenhuaMsg.class.getDeclaredMethod("getBarId", Object.class);
						 //   method.setAccessible(true);
						   //  System.out.println("------>"+method);
						 
						 
						 
						 /*
						  *                  场所上网信息上传
						  * 首先，我要想获取到网吧id，那网吧必须要和中心建立连接，建立连接的前提是： 网吧端必须要和中心端认证通过，通过以后，调用
						  * package com.wenhua.svr.service 这个包下面的AuthService 这个接口的isAuth这个方法，会返回一个NetBar 的一个实体类，
						  * 然后我可以获取到网吧的编号
						  * 
						  * 然后我可以通过这个网吧的编号然后调用缓存
						  * package com.wenhua.svr.component;
						  *      StatBarInstancerCacher 这个类下面的getBarOnLineStatisticsFromCache（）这个方法，然后获取到实时的网吧在线信息
						  *      
						  *       
						  * 
						  * */
						 Date date= new Date();
						 int hours = date.getHours();
						 int minutes=date.getMinutes();
						 if(hours==23 &&hours<24 && minutes>=50){
							 /*   下面这个方法是：  场所上网信息上传            */
							 
							 /**
							  * 1.备份缓存数据
							  * 2把缓存数据整理上报
							  * 3.上报成功，上报旧数据，成功，就删除上报成功的数据，失败，就删除上个月之前的旧数据
							  * 4上报失败，入库，然后在删除上个月之前的旧数据
							  * 
							  *    
							  *    
							  *    
							  *    
							  */ 
							
							 
							 /*String barId="4101020020";
								BarOnlineStatistic bonlista=sbicacher.getBarOnLineStatisticsFromCache(barId);
								 List<CustomerOnlineInfo> clist=new ArrayList<CustomerOnlineInfo>(); 
							
								 int oNT=bonlista.getOnlineNumToday();
								 int onlineNumToda=oNT*3;
								 Date dateupload=new Date();
								 baronlinestatic.setOnlineNumToday(onlineNumToda);
								 baronlinestatic.setBarId(barId);
						           
								 
						
							            
							 res=webseruupload.sendCustomerOnlineInfo(clist);*/
						if(res.equals("successful")){
							//上报旧数据
							 /*   if(上报旧数据成功)
							  *  { 
							  *         分为多次上报
							  *         删除上报成功的旧数据
							  *    }else{
							  *         删除上个月之前的旧数据
							  *    }
							  *    
							  *    */
						}else{
							//把今日上报数据插入数据库，然后删除上个月之前的旧数据
							
						}
							/* if(upgetdata.getAll().size()>0){
									res= webseruupload.sendCustomerOnlineInfo(upgetdata.getAll());//返回上传的结果successful/failing
									System.out.println("===========线程调用上传的结果：=====》"+res);
									 if(res.equals("successful")){								
										List<CustomerOnlineInfo>  clist2= upgetdata.getAll();
								    	 for(int i=0;i<clist2.size();i++){
								    		String NetBar_code= clist2.get(i).getNetbar_code();
								    		 result= upgetdata.delte(NetBar_code);
								    		if(result>0){
								    			System.out.println("场所上网信息上传删除成功");
								    			// List<CustomerOnlineInfo> clist3= upgetdata.getAll();
								    			//上报旧数据，如何上报旧数据成功，就删除3日内的旧数据
								    			//删除上个月之前的数据   delete from t_up_customeronlineinfo where PERIOD_DIFF( date_format( now( ) , '%Y%m' ) , date_format( report_time, '%Y%m' ) ) =1
								    			
								    			
								    		}else if(result<0){
								    			System.out.println("场所上网信息上传删除失败！");
								    		}
								    	 }
									 }
							 }else if(result<0){
								 return; 
							 }*/
						/*	 上网时长提示信息上传
							 int result2=0;
							 if(upgetdata.getAllOnlineTimeTipInfo().size()>0){
								 res=webseruupload.sendOnlineTimeInfo(upgetdata.getAllOnlineTimeTipInfo());
								 if(res.equals("successful")){
									 List<OnlineTimeTipInfo> clist=upgetdata.getAllOnlineTimeTipInfo();
									  for (OnlineTimeTipInfo onlineTimeTipInfo : clist) {
										String netbarCode=onlineTimeTipInfo.getNetbarCode();
										 result2=upgetdata.delOnlineTimeTipInfoByNetbarCode(netbarCode);
										if(result2>0){
											logger.info("上网时长提示信息删除成功");
										}else if(result2<0){
											logger.info("上网时长提示信息删除失败");
										}
									}
								 }
							 }else if(result2<0){
								 return;
							 }
							 紧急状态信息上传 
							 int result3=0;
							 if(upgetdata.getAllExigencyInfo().size()>0){
								 res=webseruupload.sendExigencyInfo(upgetdata.getAllExigencyInfo());
								 if(res.equals("successful")){
									 List<ExigencyInfo> elist=upgetdata.getAllExigencyInfo();
									     for (ExigencyInfo exigencyInfo : elist) {
											String netbarCode=exigencyInfo.getNetbar_code();
											result3=upgetdata.delExigencyInfoByNetbarcode(netbarCode);
											if(result3>0){
												logger.info("紧急状态信息上传删除成功");
											}else if(result3<0){
												logger.info("紧急状态信息上传删除失败");
											}
										}
								 }
							 }else if(result3<0){
								 return;
							 }*/
							 
							 
							 
							 
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
