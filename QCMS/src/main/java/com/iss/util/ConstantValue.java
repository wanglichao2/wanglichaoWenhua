package com.iss.util;

/**
 * 常量值对象
 */
public class ConstantValue {
	//在httpsession中存储当前登录用户对象
	public final static String SESSION_USER = "sessionUser";
	
	//在httpsession中存储当前登录用户参数配置
	public final static String SESSION_USER_CONFIG = "sessionUserConfig";
	
	//在httpsession中存储当前登录用户名
	public final static String SESSION_LOGIN_USERNAME = "sessionUserName";

	//在httpsession中存储当前登陆用户密码
	public final static String SESSION_LOGIN_PASSWORD = "sessionPassword";
	
	//在httpsession中存储当前微信用户的OpenId
	public final static String SESSION_USER_OPENID = "sessionUserOpenId";
	
	//在httpsession中存储当前微信用户信息
	public final static String SESSION_WECHAT_USER = "sessionWeChatUser";
	
	//在httpsession中存储当前登录用户节点集合
	public final static String SESSION_USER_NODE = "userNodeSet";
	
	//在httpsession中存储当前系统用户集合
	public final static String SESSION_USER_DATA = "userData";
	
	//在httpsession中存储当前系统部门集合
	public final static String SESSION_GROUP_DATA = "groupData";
	
	//模板下载目录
	public static String TEMPLATE_DIR = PropertiesUtil.getPropery("template_dir");
}
