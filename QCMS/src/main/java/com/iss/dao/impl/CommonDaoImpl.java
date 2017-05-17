/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2016-12-16
 * @version: 1.0
 */
package com.iss.dao.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.iss.dao.ICommonDao;

/**
 * 公共持久化数据实现
 */
@Repository
public class CommonDaoImpl extends BaseJPADaoImpl<Object, Long> implements ICommonDao{
	@Override
	public boolean updateField(Long id, String field, String fieldValue, String tableName){
		String sql ="update "+tableName+" set "+field+"=:fieldValue where id=:id";
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fieldValue", fieldValue);
		parameters.put("id", id);
		return executeNative(sql, parameters);
	}
	
	@Override
	public boolean updateField(Long id, String field, String fieldValue, String appendField, String tableName){
		String sql ="update "+tableName+" set "+field+"=:fieldValue, "+ appendField +" where id=:id";
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("fieldValue", fieldValue);
		parameters.put("id", id);
		return executeNative(sql, parameters);
	}
	
	@Override
	public List<Object> querySysCode(String classifyCode){
		String sql = "select code, code_name from t_sys_code where status=1 and classify_code=:classifyCode";
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("classifyCode", classifyCode);
		return findNativeQuery(sql, parameters);
	}
	
	@Override
	public boolean delBatch(String tableName, Long[] ids){
		Map<String, Object> parameters = new HashMap<String, Object>();
		String sql = "update "+ tableName +" set status=0 where id in :ids";
		parameters.put("ids", Arrays.asList(ids));
		return executeNative(sql, parameters);
	}
}
