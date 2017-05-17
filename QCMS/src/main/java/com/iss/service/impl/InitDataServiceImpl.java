/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2016-12-24
 * @version: 1.0
 */
package com.iss.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iss.dao.ICodeDao;
import com.iss.entity.CodeEntity;
import com.iss.service.InitDataService;

/** 
 * 初始化数据服务
 */
@Service
public class InitDataServiceImpl implements InitDataService{
	@Autowired
	private ICodeDao iCodeDao;
	
	@Override
	public Map<String, Object> loadData(){
		Map<String, Object> map = new HashMap<String, Object>();
		List<CodeEntity> codeSet = iCodeDao.findByStatusTrue();
		map.put("code", codeSet);
		return map;
	}
}
