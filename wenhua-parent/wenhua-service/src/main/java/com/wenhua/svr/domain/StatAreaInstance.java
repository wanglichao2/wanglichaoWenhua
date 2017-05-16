package com.wenhua.svr.domain;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 实时区域信息
 * 
 * @author zhuzhaohua
 *
 */
public abstract class StatAreaInstance {

	private AreasCode area;
	/** 区域内网吧实时在线数 */
	private AtomicInteger online = new AtomicInteger(0);
	/** 区域内固定网吧数 */
	private int areaMaxBar = 0;
	/** 区域内固定PC数 */
	private int areaMaxPc = 0;
	
	
	/** 每日最大网吧数 */
	private AtomicInteger areaMaxBarDaily = new AtomicInteger(0);
	/** 每日最大登录数 */
	private AtomicInteger areaMaxLoginDaily = new AtomicInteger(0);
	
	
	public StatAreaInstance() {
	}
	
	/**
	 * 每天清零
	 */
	public void  clearMaxDaily() {
		areaMaxBarDaily.set(0);
		areaMaxLoginDaily.set(0);
	}
	
//	/**
//	 * 更新网吧对应的用户登录数
//	 * @param barId
//	 * @param login 当前的实时数量
//	 * @return 当前实时数量与之前数量的差值
//	 */
//	public abstract int updateLogin(String barId, int login);
	
	/**
	 * 获取该区域内所有网吧用户登录数的实时合计数
	 * @return
	 */
	public abstract int getLoginTotal();
	
	/**
	 * 创建1个区域实时信息
	 * @param area
	 * @param areaMaxBar
	 * @param areaMaxPc
	 * @return
	 */
	public static StatAreaInstance newOne(AreasCode area, int areaMaxBar, int areaMaxPc) {
		if(null == area) return null;
		
		StatAreaInstance sai = null;
		
		if(area.isArea()) {
			sai = new StatAreaInstanceArea();
		} else if(area.isCity()) {
			sai = new StatAreaInstanceCity();
		} else if(area.isProvince()) {
			sai = new StatAreaInstanceProvince();
		} else {
			return null;
		}
		
		sai.setArea(area);
		sai.setAreaMaxBar(areaMaxBar);
		sai.setAreaMaxPc(areaMaxPc);
		return sai;
	}
	
	public void setArea(AreasCode area) {
		this.area = area;
	}
	
	public boolean isProvince() {
		return this.area.isProvince();
	}
	
	public boolean isCity() {
		return this.area.isCity();
	}
	
	public boolean isArea() {
		return this.area.isArea();
	}

	/**
	 * 上线1个网吧
	 * @param barId
	 * @return
	 */
	public int online(String barId) {
		int currentOnline = this.online.incrementAndGet();
		
		if(currentOnline > this.getAreaMaxBarDaily().get()) {
			this.getAreaMaxBarDaily().set(currentOnline);
		}
		
		return currentOnline;
	}
	
	/**
	 * 下线1个网吧
	 * @param barId
	 * @return
	 */
	public int offline(String barId) {
		
		synchronized (online) {
			if(online.get() > 0) {
				return this.online.decrementAndGet();
			}
			return 0;
		}
	}

	public String getCode() {
		return this.area.getAreasid();
	}

	public AtomicInteger getOnline() {
		return online;
	}

	public void setOnline(AtomicInteger online) {
		this.online = online;
	}

	public int getAreaMaxBar() {
		return areaMaxBar;
	}

	public void setAreaMaxBar(int areaMaxBar) {
		this.areaMaxBar = areaMaxBar;
	}

	public int getAreaMaxPc() {
		return areaMaxPc;
	}

	public void setAreaMaxPc(int areaMaxPc) {
		this.areaMaxPc = areaMaxPc;
	}

	public String getName() {
		return this.area.getAreasname();
	}

	public String getRankno() {
		return this.area.getRankno();
	}

	/**
	 * 指定区域是否属于本区域
	 * @param area
	 * @return
	 */
	public boolean isMine(StatAreaInstance area) {
		return this.area.isMine(area.getCode());
	}

	public AtomicInteger getAreaMaxBarDaily() {
		return areaMaxBarDaily;
	}

	public void setAreaMaxBarDaily(AtomicInteger areaMaxBarDaily) {
		this.areaMaxBarDaily = areaMaxBarDaily;
	}

	public AtomicInteger getAreaMaxLoginDaily() {
		return areaMaxLoginDaily;
	}

	public void setAreaMaxLoginDaily(AtomicInteger areaMaxLoginDaily) {
		this.areaMaxLoginDaily = areaMaxLoginDaily;
	}
	
	/**
	 * 获取离线网吧数
	 * @return
	 */
	public int getOffline() {
		int offline = this.getAreaMaxBar() - this.getOnline().get(); 
		return offline < 0 ? 0 : offline;
	}
	
}
