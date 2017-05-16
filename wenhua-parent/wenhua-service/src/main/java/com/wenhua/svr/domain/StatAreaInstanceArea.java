package com.wenhua.svr.domain;

import com.wenhua.svr.component.StatBarInstancerCacher;

public class StatAreaInstanceArea extends StatAreaInstance {

//	/** 区域内每个网吧的实时登录数 */
//	private Map<String, Integer> barLoginCacher = new ConcurrentHashMap<>();
	
	/**
	 * 获取该区域内所有网吧用户登录数的实时合计数
	 * @return
	 */
	public int getLoginTotal() {
//		if(barLoginCacher.size() == 0) return 0;
//		
//		Collection<Integer> logins = barLoginCacher.values();
//		int total = 0;
//		for(Integer login : logins) {
//			if(null == login) continue;
//			
//			total = total + login;
//		}
//		return total;
		
		return StatBarInstancerCacher.getLoginTotalByAreaCode(this.getCode());
		
	}
	
//	/**
//	 * 更新网吧对应的用户登录数
//	 * @param barId
//	 * @param loginNow
//	 */
//	public int updateLogin(String barId, int loginNow) {
//		// 更新本区域的实时登录数
//		Integer loginBefore = barLoginCacher.put(barId, loginNow);
//		if(null == loginBefore) return loginNow;
//		return loginNow - loginBefore;
//	}
}
