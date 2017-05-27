package com.wenhua.svr.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class StatAreaInstanceCity extends StatAreaInstance {

	private Map<StatAreaInstanceArea, Object> areas = new ConcurrentHashMap<>();
	
	@Override
	public int getLoginTotal() {
		if(0 == areas.size()) return 0;
		Set<StatAreaInstanceArea> set = areas.keySet();
		int total = 0;
		for(StatAreaInstanceArea area : set) {
			total = total + area.getLoginTotal();
		}
		return total;
	}

//	@Override
//	public int updateLogin(String barId, int login) {
//		//do nothing
//		return login;
//	}
	
	public void put(StatAreaInstanceArea area) {
		this.areas.put(area, area);
	}
	
	public List<StatAreaInstance> getAreas() {
		Set<StatAreaInstanceArea> set = areas.keySet();
		List<StatAreaInstance> list = new ArrayList<StatAreaInstance>(set.size());
		for(StatAreaInstance i : set) {
			list.add(i);
		}
		
		return list;
	}
	 
}
