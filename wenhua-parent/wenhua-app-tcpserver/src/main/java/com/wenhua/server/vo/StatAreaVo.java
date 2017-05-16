package com.wenhua.server.vo;

public class StatAreaVo {

	private String areaCode;
	private String areaName;

	private int online;
	private int offline;

	private int pcTotal;
	private int login;
	
	public static StatAreaVo newOne(String areaCode, String areaName, int online, int offline, int pcTotal, int login) {
		StatAreaVo vo = new StatAreaVo();
		vo.setAreaCode(areaCode);
		vo.setAreaName(areaName);
		vo.setOnline(online);
		vo.setOffline(offline);
		vo.setPcTotal(pcTotal);
		vo.setLogin(login);
		return vo;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public int getOnline() {
		return online;
	}

	public void setOnline(int online) {
		this.online = online;
	}

	public int getOffline() {
		return offline;
	}

	public void setOffline(int offline) {
		this.offline = offline;
	}

	public int getPcTotal() {
		return pcTotal;
	}

	public void setPcTotal(int pcTotal) {
		this.pcTotal = pcTotal;
	}

	public int getLogin() {
		return login;
	}

	public void setLogin(int login) {
		this.login = login;
	}

}
