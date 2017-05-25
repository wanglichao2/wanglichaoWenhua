package com.iss.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.iss.entity.ProvinceCityBarEntity;

/**
 * http接口处理
 * @author gxie
 *
 */
public class HttpClientUtil {
	
	private static Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);
	
	/**
	 * 
	 * @param url
	 * @param param
	 * @return
	 * @throws IOException 
	 * @throws HttpException 
	 */
    public static JsonObject httpPost(String url) throws HttpException, IOException{
		//创建client对象
		HttpClient client = new HttpClient();
		//获取method
    	PostMethod method = new PostMethod(url);
    	//执行method
		client.executeMethod(method);
		//获取method返回的流
		InputStream stream = method.getResponseBodyAsStream(); 
		//读取流
		BufferedReader br = new BufferedReader(new InputStreamReader(stream, "UTF-8"));  
	    StringBuffer buf = new StringBuffer();  
	    String line;  
	    while (null != (line = br.readLine())) {  
	         buf.append(line).append("\n");  
	    }
	    //转换为json
	    JsonParser parse = new JsonParser();
	    return (JsonObject) parse.parse(buf.toString());
    }
    
    public static String netBarListHttpPost(String url){
    	String stat = "";
		try {
			JsonObject jsonObject = httpPost(url);
			int status = jsonObject.get("status").getAsInt();
	    	//判断请求是否成功
			if(status != 1){
	    		String message = jsonObject.get("message").getAsString();
	    		if(StringUtil.isNotEmpty(message)){
	    			logger.error(message);
	    		}
	    		return stat;
	    	}
	    	//json返回结果
			JsonElement je= jsonObject.get("values");
			if(je!=null){
				 JsonObject values =  je.getAsJsonObject();
			     stat = values.get("stat").toString();
			}
	       
		} catch (HttpException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
		return stat;
    }
    
    public static void netBarHttpPost(String url){
		try {
			long time = System.currentTimeMillis();
			System.out.println(time);
			JsonObject jsonObject = httpPost(url);
			System.out.println(System.currentTimeMillis()-time);
			int status = jsonObject.get("status").getAsInt();
	    	//判断请求是否成功
	    	if(status != 1){
	    		String message = jsonObject.get("message").getAsString();
	    		if(StringUtil.isNotEmpty(message)){
	    			logger.error(message);
	    		}
	    	}
	    	System.out.println(System.currentTimeMillis()-time);
		} catch (HttpException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			logger.error(e.getMessage());
			e.printStackTrace();
		}
    }
	
	public static void main(String[] args){
		//String result = HttpClientUtil.netBarListHttpPost("http://localhost:8088/province/",null);
		String result = HttpClientUtil.netBarListHttpPost("http://202.109.114.115:8088/city/411300");
		//String result = HttpClientUtil.netBarListHttpPost("http://localhost:8088/area/", "411212");
        //json结果转换为List集合
		try {
			if(StringUtil.isNotEmpty(result)){
				List<ProvinceCityBarEntity> list = JSON.parseArray(result, ProvinceCityBarEntity.class);  
				for (ProvinceCityBarEntity areasBarEntity : list) {
					System.out.println(areasBarEntity.getAreaCode() + ":" + areasBarEntity.getLogin());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		HttpClientUtil.netBarHttpPost("http://202.109.114.115:8088/update_bar/4101010001");
	}
}