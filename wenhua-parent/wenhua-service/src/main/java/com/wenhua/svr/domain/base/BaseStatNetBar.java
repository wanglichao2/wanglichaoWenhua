package com.wenhua.svr.domain.base;

public class BaseStatNetBar extends BaseStatNetBarKey {
    private Integer online;

	private Integer offline;

	private Integer valid;

	private Integer login;

	private String areaCode;

	private String cityCode;

	public Integer getOnline() {
		return online;
	}

	public void setOnline(Integer online) {
		this.online = online;
	}

	public Integer getOffline() {
		return offline;
	}

	public void setOffline(Integer offline) {
		this.offline = offline;
	}

	public Integer getValid() {
		return valid;
	}

	public void setValid(Integer valid) {
		this.valid = valid;
	}

	public Integer getLogin() {
		return login;
	}

	public void setLogin(Integer login) {
		this.login = login;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getCityCode() {
		return cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

}