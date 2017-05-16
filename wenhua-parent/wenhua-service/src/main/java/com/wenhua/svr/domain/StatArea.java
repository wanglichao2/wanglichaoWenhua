package com.wenhua.svr.domain;

import java.util.Date;

import com.wenhua.svr.domain.base.BaseStatArea;

/**
 * 地区统计信息
 * @author zhuzhaohua
 *
 */
public class StatArea extends BaseStatArea {

	private StatArea() {
	}
	
	/**
	 * 创建1个新的统计信息
	 * @param areaCode
	 * @param statDate
	 * @param online
	 * @param offline
	 * @param login
	 * @return
	 */
	public static StatArea newOne(String areaCode, Date statDate, int online, int offline, int login, String rankno) {
		StatArea sa = new StatArea();
		sa.setAreaCode(areaCode);
		sa.setStatDate(statDate);
		sa.setOnline(online);
		sa.setOffline(offline);
		sa.setLogin(login);
		sa.setRankno(rankno);
		return sa;
	}

}
