/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2016-12-16
 * @version: 1.0
 */
package com.iss.dao;

import java.util.List;

/**
 * 公共持久化数据接口
 */
public interface ICommonDao{
	/**
	 * 更新单个字段数据方法
	 * @author yjdai 
	 * @param id
	 * @param field
	 * @param fieldValue
	 * @param tableName
	 * @return
	 */
	boolean updateField(Long id, String field, String fieldValue, String tableName);
	
	/**
	 * 更新单个字段数据方法
	 * @author yjdai 
	 * @param id
	 * @param field
	 * @param fieldValue
	 * @param appendField 追加更新字段的静态值
	 * @param tableName
	 * @return
	 */
	boolean updateField(Long id, String field, String fieldValue,
			String appendField, String tableName);
	
	/**
	 * 通过分类查询系统通用代码表
	 * @author yjdai 
	 * @param classifyCode
	 * @return
	 */
	List<Object> querySysCode(String classifyCode);
	
	/**
	 * 批量逻辑删除
	 * @author yjdai
	 * @param tableName 
	 * @param ids
	 * @return
	 */
	boolean delBatch(String tableName, Long[] ids);
}
