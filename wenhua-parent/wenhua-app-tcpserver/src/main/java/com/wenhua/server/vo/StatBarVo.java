package com.wenhua.server.vo;

public class StatBarVo {

	private String barId;

	private String barName;

	private int online;

	private int offline;

	private int valid;

	private String serverVersion;

	public static StatBarVo newOne(String barId, String barName, int online, int offline, int valid, String serverVersion) {
		StatBarVo vo = new StatBarVo();
		vo.setBarId(barId);
		vo.setBarName(barName);
		vo.setOnline(online);
		vo.setOffline(offline);
		vo.setValid(valid);
		vo.setServerVersion(serverVersion);
		return vo;
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

	public int getValid() {
		return valid;
	}

	public void setValid(int valid) {
		this.valid = valid;
	}

	public String getServerVersion() {
		return serverVersion;
	}

	public void setServerVersion(String serverVersion) {
		this.serverVersion = serverVersion;
	}

}
