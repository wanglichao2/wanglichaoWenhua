package com.iss.entity;

import java.util.Date;

/**
 * 省市级统计表
 * 
 * @author gxie
 *
 */
public class StatNetBarEntity {
	private String bar_id;// 网吧注册号
	private Date stat_date;// 统计日期
	private Long online;// 最大在线终端数
	private Long offline;// 最小离线终端数
	private Long valid;// 最大有效终端数
	private Long login;// 最大有效终端数
	private String area_code;// 县代码
	private String city_code;// 市代码

	public String getBar_id() {
		return bar_id;
	}

	public void setBar_id(String bar_id) {
		this.bar_id = bar_id;
	}

	public Date getStat_date() {
		return stat_date;
	}

	public void setStat_date(Date stat_date) {
		this.stat_date = stat_date;
	}

	public Long getOnline() {
		return online;
	}

	public void setOnline(Long online) {
		this.online = online;
	}

	public Long getOffline() {
		return offline;
	}

	public void setOffline(Long offline) {
		this.offline = offline;
	}

	public Long getValid() {
		return valid;
	}

	public void setValid(Long valid) {
		this.valid = valid;
	}

	public Long getLogin() {
		return login;
	}

	public void setLogin(Long login) {
		this.login = login;
	}

	public String getArea_code() {
		return area_code;
	}

	public void setArea_code(String area_code) {
		this.area_code = area_code;
	}

	public String getCity_code() {
		return city_code;
	}

	public void setCity_code(String city_code) {
		this.city_code = city_code;
	}

}