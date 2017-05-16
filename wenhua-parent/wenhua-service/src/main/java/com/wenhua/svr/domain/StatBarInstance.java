package com.wenhua.svr.domain;

import java.util.List;

import com.alibaba.fastjson.JSON;

/**
 * 实时 网吧的 线终端数 离线终端数 有效终端数 登录人数
 * 
 * @author zhuzhaohua
 *
 */
public class StatBarInstance {

	private String barId;
	private String barName;
	private String serverVersion;
	private String clientVersion;
	
	/** 实时参数 */
	private int online = 0;
	private int offline = 0;
	private int valid = 0;
	private int login = 0;
	
	/** 最大参数 */
	private int maxOnline = 0;
	private int maxOffline = 0;
	private int maxValid = 0;
	private int maxLogin = 0;
	
	private StatBarInstance() {}

	public static StatBarInstance newOne(String barId, String barName, String serverVersion, String clientVersion, int clientTotal) {
		StatBarInstance instance = new StatBarInstance();
		instance.setBarId(barId);
		instance.setBarName(barName);
		instance.setServerVersion(serverVersion);
		instance.setClientVersion(clientVersion);
		// 初始化网吧实时缓存信息, 初始化的离线终端数为该网吧终端总数
		instance.setOffline(clientTotal);
		return instance;
	}
	
	/**
	 * 清0最大数值
	 */
	public void clearMax() {
		this.setMaxLogin(0);
		this.setMaxOffline(0);
		this.setMaxOnline(0);
		this.setMaxValid(0);
	}
	
	/**
	 * 更新实时信息
	 * @param infos
	 * @param wenhuaDuration 判断文化客户端运行多少时间后在线
	 */
	public void update(List<BarPcInstantInfo> infos, int wenhuaDuration) {
		int newOnline = 0;
		int newOffline = 0;
		int newValid = 0;
		int newLogin = 0;
		
		if(null != infos) {
			for(BarPcInstantInfo info : infos) {
				if(info.isPowerOn()) {
					newOnline++;
				} else {
					newOffline++;
				}
				
				if(info.isRunWenhua() && info.getWenhuaDuration() >= wenhuaDuration) {
					newValid++;
				}
				
				if(info.isUserLogin()) {
					newLogin++;
				}
			}
		}
		
		// 更新最大值
		this.setMaxLogin(newOnline > this.getMaxLogin() ? newOnline : this.getMaxLogin());
		this.setMaxOffline(newOffline > this.getMaxOffline() ? newOffline : this.getMaxOffline());
		this.setMaxOnline(newOnline > this.getMaxOnline() ? newOnline : this.getMaxOnline());
		this.setMaxValid(newValid > this.getMaxValid() ? newValid : this.getMaxValid());
		
		// 更新实时信息
		this.setOnline(newOnline);
		this.setOffline(newOffline);
		this.setValid(newValid);
		this.setLogin(newLogin);
	}

	public int getOnline() {
		return online;
	}

	public int getOffline() {
		return offline;
	}

	public int getValid() {
		return valid;
	}

	public int getLogin() {
		return login;
	}

	public void setOnline(int online) {
		this.online = online;
	}

	public void setOffline(int offline) {
		this.offline = offline;
	}

	public void setValid(int valid) {
		this.valid = valid;
	}

	public void setLogin(int login) {
		this.login = login;
	}

	public String getBarId() {
		return barId;
	}

	public void setBarId(String barId) {
		this.barId = barId;
	}

	public String getBarName() {
		return barName;
	}

	public void setBarName(String barName) {
		this.barName = barName;
	}

	public String getServerVersion() {
		return serverVersion;
	}

	public void setServerVersion(String serverVersion) {
		this.serverVersion = serverVersion;
	}

	public String getClientVersion() {
		return clientVersion;
	}

	public void setClientVersion(String clientVersion) {
		this.clientVersion = clientVersion;
	}

	public int getMaxOnline() {
		return maxOnline;
	}

	public void setMaxOnline(int maxOnline) {
		this.maxOnline = maxOnline;
	}

	public int getMaxOffline() {
		return maxOffline;
	}

	public void setMaxOffline(int maxOffline) {
		this.maxOffline = maxOffline;
	}

	public int getMaxValid() {
		return maxValid;
	}

	public void setMaxValid(int maxValid) {
		this.maxValid = maxValid;
	}

	public int getMaxLogin() {
		return maxLogin;
	}

	public void setMaxLogin(int maxLogin) {
		this.maxLogin = maxLogin;
	}

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
