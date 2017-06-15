package com.wenhua.server;

/**
 * 消息中Method字段的值
 * @author zhuzhaohua
 *
 */
public enum TcpMethod {
	
	/** 网吧服务端身份验证 */
	Authentication("Authentication"),
	/** 获取网吧配置 */
	GetConfig("GetConfig"),
	/** 上报服务器基本信息，没有变化则不会上报 */
	SetServerInfo("SetServerInfo"),
	/** 获取文件信息列表 */
	GetFileInfoList("GetFileInfoList"),
	/** 获取文件 */
	GetFile("GetFile"),
	/** 上报客户机基本信息列表，没有变化则不会上报 */
	SetPcInfoList("SetPcInfoList"),
	/** 上报客户机实时信息列表 */
	SetInstantPcInfoList("SetInstantPcInfoList"),
	/*上报网吧实时信息新*/
	SetBarInstantInfo("SetBarInstantInfo");
	private String name;
	
	/**
	 * 根据字符串获取枚举值
	 * @param string
	 * @return
	 */
	public static TcpMethod getEnumFromString(String string){
		if(null != string) {
			
			try {
				return Enum.valueOf(TcpMethod.class, string);
			} catch (IllegalArgumentException e) {
				return null;
			}
		} else {
			return null;
		}
	}
	
	private TcpMethod(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
