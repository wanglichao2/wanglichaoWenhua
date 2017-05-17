/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2016年12月30日
 * @version: 1.0
 */
package com.iss.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iss.entity.CodeEntity;
import com.iss.entity.CodePK;

/** 
 * 通用代码数据接口
 */
@Repository
public interface ICodeDao extends IBaseDao<CodeEntity, CodePK> {
	
	/**
	 * 获取通用代码，即系统参数
	 * @author yjdai 
	 * @return
	 */
	public List<CodeEntity> findByStatusTrue();
}
