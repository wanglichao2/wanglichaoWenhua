package com.wenhua.svr.domain;

/**
 * 客户机实时信息
 * @author zhuzhaohua
 *
 */
public class BarPcInstantInfo {

	/** 客户机Mac地址；	例：50-E5-49-3D-5D-78	以此为字段关联是这家网吧的哪台机器 */
	private String mac;
	/** 是否开机 */
	private boolean isPowerOn;
	/** 是否运行文化客户端 */
	private boolean isRunWenhua;
	/** 是否实名登录 */
	private boolean isUserLogin;
	/** 文化客户端运行时长，单位：分钟 */
	private int wenhuaDuration;
	/** 客户机开机时长，单位：分钟 */
	private int powerDuration;
	
	public static BarPcInstantInfo newOne(String mac, boolean isPowerOn, boolean isRunWenhua, boolean isUserLogin, int wenhuaDuration, int powerDuration) {
		BarPcInstantInfo b = new BarPcInstantInfo();
		b.setMac(mac);
		b.setPowerOn(isPowerOn);
		b.setRunWenhua(isRunWenhua);
		b.setUserLogin(isUserLogin);
		b.setWenhuaDuration(wenhuaDuration);
		b.setPowerDuration(powerDuration);
		
		return b;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public boolean isPowerOn() {
		return isPowerOn;
	}

	public void setPowerOn(boolean isPowerOn) {
		this.isPowerOn = isPowerOn;
	}

	public boolean isRunWenhua() {
		return isRunWenhua;
	}

	public void setRunWenhua(boolean isRunWenhua) {
		this.isRunWenhua = isRunWenhua;
	}

	public boolean isUserLogin() {
		return isUserLogin;
	}

	public void setUserLogin(boolean isUserLogin) {
		this.isUserLogin = isUserLogin;
	}

	public int getWenhuaDuration() {
		return wenhuaDuration;
	}

	public void setWenhuaDuration(int wenhuaDuration) {
		this.wenhuaDuration = wenhuaDuration;
	}

	public int getPowerDuration() {
		return powerDuration;
	}

	public void setPowerDuration(int powerDuration) {
		this.powerDuration = powerDuration;
	}

}
