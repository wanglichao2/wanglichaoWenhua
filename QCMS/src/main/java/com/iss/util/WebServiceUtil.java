package com.iss.util;

import java.net.ConnectException;
import java.util.List;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

import com.iss.vo.InterfaceConfig;
import com.iss.vo.NetBarBean;

public class WebServiceUtil {
	private static JaxWsDynamicClientFactory clientFactory = JaxWsDynamicClientFactory.newInstance(); 
	
	
	public static Client createWsClient(InterfaceConfig config){
        Client client = clientFactory.createClient(config.getUrl());  
        HTTPConduit conduit = (HTTPConduit) client.getConduit();
        HTTPClientPolicy policy = new HTTPClientPolicy();
        policy.setConnectionTimeout(10000); //连接超时时间
        policy.setReceiveTimeout(20000);//请求超时时间.
        conduit.setClient(policy);
        return client;
	}
	
	public static String netBarSyncLogin(InterfaceConfig config)throws Exception{
		long start=System.currentTimeMillis();
		System.out.println("start====>"+start);
		Object[] result=null;
		try {
			Client client=createWsClient(config);
			Object[]params=new Object[]{config.getUsername(),config.getPassword()};
			result = client.invoke(config.getMethod(),params);
		}catch(ConnectException ce){
			ce.printStackTrace();
			throw new Exception("WebService连接服务端超时");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}finally{
			long end=System.currentTimeMillis();
			System.out.println("end====>"+end+"---->"+(end-start)/1000);
		}
        System.out.println(result[0]); 
        return result==null?null:(String)result[0];
	}
	
	public static List<NetBarBean> netBarSyncData(InterfaceConfig config,String key,String endtime)throws Exception{
		/*String key=netBarSyncLogin(config);
		if(key==null){
			throw new Exception("接口登录认证失败");
		}*/
		Client client=createWsClient(config);
		Object[] result=null;
		try {
			Object[]params=new Object[]{key,endtime};
			result = client.invoke(config.getMethod(),params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<NetBarBean> list=(List<NetBarBean>)result[0];
        return list;
	}
	
	
	public static void main(String[] args){
		
		
		
		
	}

}
