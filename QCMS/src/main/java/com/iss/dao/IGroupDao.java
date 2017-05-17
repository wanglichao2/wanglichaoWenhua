/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2016年12月30日
 * @version: 1.0
 */
package com.iss.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iss.entity.GroupEntity;

/** 
 * 系统部门数据接口
 */
@Repository
public interface IGroupDao extends IBaseDao<GroupEntity, Long> {
	/**
	 * 查询状态正常的部门
	 * @author yjdai 
	 * @return
	 */
	List<GroupEntity> findByStatusTrueOrderBySort();
}
