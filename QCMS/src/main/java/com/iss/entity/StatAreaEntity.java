package com.iss.entity;

import java.util.Date;

/**
 * 县网吧表
 * 
 * @author gxie
 *
 */
public class StatAreaEntity {
	//private String city_code;
	private String area_code;
	private Date stat_date;//统计日期
	private Long online;//最大网吧在线数量
	private Long offline;//最大网吧离线数量
	private Long login;//最大网吧用户数
	private char rankno;//地区类别 1省2市3区

	public String getArea_code() {
		return area_code;
	}

	public void setArea_code(String area_code) {
		this.area_code = area_code;
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

	public Long getLogin() {
		return login;
	}

	public void setLogin(Long login) {
		this.login = login;
	}

	public char getRankno() {
		return rankno;
	}

	public void setRankno(char rankno) {
		this.rankno = rankno;
	}

//	public String getCity_code() {
//		return city_code;
//	}
//
//	public void setCity_code(String city_code) {
//		this.city_code = city_code;
//	}

}
