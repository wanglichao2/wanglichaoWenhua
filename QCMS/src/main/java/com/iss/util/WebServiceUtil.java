package com.iss.util;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;


//import org.apache.axiom.om.OMElement;
//import org.apache.axis2.AxisFault;
//import org.apache.axis2.addressing.EndpointReference;
//import org.apache.axis2.client.Options;
//import org.apache.axis2.rpc.client.RPCServiceClient;
//import org.apache.axis2.transport.http.HTTPConstants;
import org.apache.commons.httpclient.ConnectTimeoutException;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.endpoint.ClientImpl;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.cxf.transports.http.configuration.HTTPClientPolicy;

import com.iss.vo.InterfaceConfig;
import com.iss.vo.NetBarBean;

public class WebServiceUtil {
	private static JaxWsDynamicClientFactory clientFactory = JaxWsDynamicClientFactory.newInstance();

	public static Client createWsClient(InterfaceConfig config) {
		ClientImpl client = (ClientImpl) clientFactory.createClient(config
				.getUrl());
		client.setSynchronousTimeout(20000);
		HTTPConduit conduit = (HTTPConduit) client.getConduit();
		HTTPClientPolicy policy = new HTTPClientPolicy();
		policy.setConnectionTimeout(10000); // 连接超时时间
		policy.setReceiveTimeout(20000);// 请求超时时间.
		policy.setAsyncExecuteTimeout(10000);
		policy.setAsyncExecuteTimeoutRejection(true);
		conduit.setClient(policy);
		return client;
	}

	/*public static String netBarSyncLoginAxis2(InterfaceConfig config)throws Exception {
		try {
			// 使用RPC方式调用WebService
			RPCServiceClient serviceClient = new RPCServiceClient();
			// 指定调用WebService的URL
			EndpointReference targetEPR = new EndpointReference(config.getUrl());
			Options options = serviceClient.getOptions();
			// 确定目标服务地址
			options.setTo(targetEPR);
			options.setProperty(HTTPConstants.SO_TIMEOUT, 10000);
			options.setProperty(HTTPConstants.CONNECTION_TIMEOUT, 10000);
			// 确定调用方法
//			options.setAction("urn:getPrice");
			*//**
			 * 指定要调用的方法及WSDL文件的命名空间 如果 webservice 服务端由axis2编写 命名空间
			 * 不一致导致的问题 org.apache.axis2.AxisFault: java.lang.RuntimeException:
			 * Unexpected subelement arg0
			 *//*
			QName qname = new QName("http://loginInfo.interfaceImp.netbar.ccm.gov", config.getMethod());
			// 指定getPrice方法的参数值
			Object[] parameters = new Object[] { config.getUsername() ,config.getPassword()};
			// 指定getPrice方法返回值的数据类型的Class对象
			Class[] returnTypes = new Class[] { ArrayList.class };
			// 调用方法一 传递参数，调用服务，获取服务返回结果集
			OMElement element = serviceClient.invokeBlocking(qname, parameters);
			// 值得注意的是，返回结果就是一段由OMElement对象封装的xml字符串。
			// 我们可以对之灵活应用,下面我取第一个元素值，并打印之。因为调用的方法返回一个结果
			String result = element.getFirstElement().getText();
			System.out.println(result);
			return result;
			// 调用方法二 getPrice方法并输出该方法的返回值
//			Object[] response = serviceClient.invokeBlocking(qname, parameters,returnTypes);
			// String r = (String) response[0];
		}catch (AxisFault e) {
			System.out.println("-----------"+e.getMessage());
			e.printStackTrace();
			if(e.getMessage().contains("timeout")){
				throw new Exception("服务器连接超时");
			}
		}	catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return null;
	}
	
	public static List<NetBarBean> netBarSyncDataAxis2(InterfaceConfig config,
			String key, String endtime)throws Exception {
		try {
			// 使用RPC方式调用WebService
			RPCServiceClient serviceClient = new RPCServiceClient();
			// 指定调用WebService的URL
			EndpointReference targetEPR = new EndpointReference(config.getUrl());
			Options options = serviceClient.getOptions();
			// 确定目标服务地址
			options.setTo(targetEPR);
			options.setProperty(HTTPConstants.SO_TIMEOUT, 10000);
			options.setProperty(HTTPConstants.CONNECTION_TIMEOUT, 10000);
			*//**
			 * 指定要调用的方法及WSDL文件的命名空间 如果 webservice 服务端由axis2编写 命名空间
			 * 不一致导致的问题 org.apache.axis2.AxisFault: java.lang.RuntimeException:
			 * Unexpected subelement arg0
			 *//*
			QName qname = new QName("http://placeInfo.interfaceImp.netbar.ccm.gov", config.getMethod());
			// 指定getPrice方法的参数值
			Object[] parameters = new Object[] { key ,endtime};
			// 指定getPrice方法返回值的数据类型的Class对象
			Class[] returnTypes = new Class[] { ArrayList.class };
			// 值得注意的是，返回结果就是一段由OMElement对象封装的xml字符串。
			// 我们可以对之灵活应用,下面我取第一个元素值，并打印之。因为调用的方法返回一个结果
			Object[] response = serviceClient.invokeBlocking(qname, parameters,returnTypes);
			List<NetBarBean> list = (List<NetBarBean>) response[0];
			return list;
		}catch (AxisFault e) {
			System.out.println("-----------"+e.getMessage());
			e.printStackTrace();
			if(e.getMessage().contains("timeout")){
				throw new Exception("服务器连接超时");
			}
		}	catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return null;
	}*/

	public static String netBarSyncLogin(InterfaceConfig config)throws Exception {
		long start = System.currentTimeMillis();
		System.out.println("start====>" + start);
		Object[] result = null;
		try {
			Client client = createWsClient(config);
			Object[] params = new Object[] { config.getUsername(),
					config.getPassword() };
			result = client.invoke(config.getMethod(), params);
		} catch (ConnectException ce) {
			ce.printStackTrace();
			throw new Exception("WebService连接服务端超时");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		} finally {
			long end = System.currentTimeMillis();
			System.out.println("end====>" + end + "---->" + (end - start)/ 1000);
		}
		System.out.println(result[0]);
		return result == null ? null : (String) result[0];
	}
	
	//场所信息上传
	public static String netbarInfoUpload(String key,InterfaceConfig config,List<?> list)throws Exception{
		Client client = createWsClient(config);
		Object[] result = null;
		try {
			Object[] params = new Object[] { key, list };
			result = client.invoke(config.getMethod(), params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("调用上报网吧信息接口失败:"+e.getMessage());
		}
		String resp=(String)result[0];
		return resp;
	}
	
	//1.场所实施信息上传
	public static String netbarInfoDeploy(String key,InterfaceConfig config,List<?> list)throws Exception{
			Client client = createWsClient(config);
			Object[] result = null;
			try {
				Object[] params = new Object[] { key, list };
				result = client.invoke(config.getMethod(), params);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new Exception("调用上报网吧实施信息接口失败:"+e.getMessage());
				
			}
			String resp=(String)result[0];
			return resp;
		}
	
	

	public static List<NetBarBean> netBarSyncData(InterfaceConfig config,
			String key, String endtime) throws Exception {
		/*
		 * String key=netBarSyncLogin(config); if(key==null){ throw new
		 * Exception("接口登录认证失败"); }
		 */
		Client client = createWsClient(config);
		Object[] result = null;
		try {
			Object[] params = new Object[] { key, endtime };
			result = client.invoke(config.getMethod(), params);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("调用网吧数据下载接口失败:"+e.getMessage());
		}
		List<NetBarBean> list = (List<NetBarBean>) result[0];
		return list;
	}

	public static void main(String[] args) {
		InterfaceConfig config = new InterfaceConfig();
		config.setUrl("http://192.168.70.39:8080/netbar/services/loginInfo?wsdl");
		config.setUsername("410000");
		config.setPassword("000000");
		config.setMethod("login");
		try {
//			String key = netBarSyncLogin(config);
//			createWsAxis2(config);
//			System.out.println(key);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
