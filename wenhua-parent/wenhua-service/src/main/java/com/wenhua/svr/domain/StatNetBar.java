package com.wenhua.svr.domain;

import java.util.Date;

import com.wenhua.svr.domain.base.BaseStatNetBar;
import com.wenhua.svr.domain.base.BaseStatNetBarKey;

public class StatNetBar extends BaseStatNetBar {
	
	private StatNetBar() {
	}
	
	/**
	 * 产生ID
	 * @param barId
	 * @param statDate
	 * @return
	 */
	public static BaseStatNetBarKey generateId(String barId, Date statDate) {
		BaseStatNetBarKey id = new BaseStatNetBarKey();
		id.setBarId(barId);
		id.setStatDate(statDate);
		return id;
	}
	
	/**
	 * 创建统计信息
	 * @param barId
	 * @param statDate
	 * @param online
	 * @param offline
	 * @param valid
	 * @return
	 */
	public static StatNetBar newOne(String barId, Date statDate, int online, int offline, int valid, int login) {
		StatNetBar s = new StatNetBar();
		s.setBarId(barId);
		s.setStatDate(statDate);
		s.setOnline(online);
		s.setOffline(offline);
		s.setValid(valid);
		s.setAreaCode(getAreaCode(barId));
		s.setCityCode(getCityCode(barId));
		s.setLogin(login);
		return s;
	}
	
	private static String getCityCode(String barId) {
		
		String provinceCode = barId.substring(0, 2);
		String cityCode = barId.substring(2, 4);
//		String areaCode = barId.substring(4, 6);
		
		StringBuffer sb = new StringBuffer();
		sb.append(provinceCode);
		sb.append(cityCode);
		sb.append("00");
		return sb.toString();
	}
	
	private static String getAreaCode(String barId) {
		
		String provinceCode = barId.substring(0, 2);
		String cityCode = barId.substring(2, 4);
		String areaCode = barId.substring(4, 6);
		
		StringBuffer sb = new StringBuffer();
		sb.append(provinceCode);
		sb.append(cityCode);
		sb.append(areaCode);
		return sb.toString();
	}
	
	/**
	 * 比较两个状态, 获取更新后的状态
	 * @param old 老状态
	 * @return 返回null 则状态不需要更新
	 */
	public StatNetBar compare(StatNetBar old) {
		if(null == old) return null;
		
		int online = 0;
		int offline = 0;
		int valid = 0;
		int login = 0;
		boolean needUpdate = false;
		
		if(this.getOnline() > old.getOnline()) {
			online = this.getOnline();
			needUpdate = needUpdate | true;
		} else {
			online = old.getOnline();
			needUpdate = needUpdate | false;
		}
		
		if(this.getOffline() < old.getOffline()) {
			offline = this.getOffline();
			needUpdate = needUpdate | true;
		} else {
			offline = old.getOffline();
			needUpdate = needUpdate | false;
		}
		
		if(this.getValid() > old.getValid()) {
			valid = this.getValid();
			needUpdate = needUpdate | true;
		} else {
			valid = old.getValid();
			needUpdate = needUpdate | false;
		}
		
		if(this.getLogin() > old.getLogin()) {
			login = this.getLogin();
			needUpdate = needUpdate | true;
		} else {
			login = old.getLogin();
			needUpdate = needUpdate | false;
		}
		
		if(!needUpdate) return null;
		
		return StatNetBar.newOne(this.getBarId(), this.getStatDate(), online, offline, valid, login);
	}
	
}
