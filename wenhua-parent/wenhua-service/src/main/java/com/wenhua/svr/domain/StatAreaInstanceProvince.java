package com.wenhua.svr.domain;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class StatAreaInstanceProvince extends StatAreaInstance {

	private Map<StatAreaInstanceCity, Object> areas = new ConcurrentHashMap<>();
	
//	@Override
//	public int updateLogin(String barId, int login) {
//		//do nothing
//		return login;
//	}
	
	public void put(StatAreaInstanceCity area) {
		this.areas.put(area, area);
	}

	@Override
	public int getLoginTotal() {
		if(0 == areas.size()) return 0;
		Set<StatAreaInstanceCity> set = areas.keySet();
		int total = 0;
		for(StatAreaInstanceCity area : set) {
			total = total + area.getLoginTotal();
		}
		return total;
	}

	public Map<StatAreaInstanceCity, Object> getAreas() {
		return areas;
	}

	public void setAreas(Map<StatAreaInstanceCity, Object> areas) {
		this.areas = areas;
	}

}
