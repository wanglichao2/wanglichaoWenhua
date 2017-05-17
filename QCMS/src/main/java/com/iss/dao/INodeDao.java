/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2016年12月30日
 * @version: 1.0
 */
package com.iss.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iss.entity.NodeEntity;

/** 
 * 系统节点数据接口
 */
@Repository
public interface INodeDao extends IBaseDao<NodeEntity, Long> {
	/**
	 * 查询状态正常的节点
	 * @author yjdai 
	 * @return
	 */
	List<NodeEntity> findByStatusTrueOrderBySort();
	
	/**
	 * 查询状态正常的菜单类型的节点
	 * @author yjdai
	 * @param type 
	 * @return
	 */
	List<NodeEntity> findByTypeAndStatusTrueOrderBySortAsc(Integer type);
}
