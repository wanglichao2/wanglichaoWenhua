/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2016-12-24
 * @version: 1.0
 */
package com.iss.service;

import java.util.Map;

/** 
 * 初始化数据接口
 */
public interface InitDataService {
	
	/**
	 * 数据统一加载
	 * @author yjdai
	 * @param <T>
	 * @return 
	 */
	Map<String, Object> loadData();
}
