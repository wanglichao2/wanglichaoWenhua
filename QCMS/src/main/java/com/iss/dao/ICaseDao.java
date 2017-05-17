/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2016年12月30日
 * @version: 1.0
 */
package com.iss.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iss.entity.CaseEntity;

/** 
 * 用例管理数据接口
 */
@Repository
public interface ICaseDao extends IBaseDao<CaseEntity, Long> {
	/**
	 * 查询状态正常的用例
	 * @author yjdai 
	 * @return
	 */
	List<CaseEntity> findByStatusTrueOrderByCjrqDesc();
}
