/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2016年9月19日
 * @version: 1.0
 */
package com.iss.service;

import java.util.List;

import com.iss.entity.GroupEntity;

/** 
 * 系统节点服务接口
 */
public interface IGroupService {
	/**
	 * 加载数据
	 * @author yjdai 
	 * @return
	 */
	List<GroupEntity> load();
	
	/**
	 * 添加数据
	 * @author yjdai 
	 * @param entity
	 * @return
	 */
	GroupEntity add(GroupEntity entity);
	
	/**
	 * 编辑数据
	 * @author yjdai 
	 * @param id
	 * @param field
	 * @param fieldValue
	 * @return
	 */
	boolean update(Long id, String field, String fieldValue);
	boolean delete(Long id);
	
	/**
	 * 获取状态正常的部门
	 * @author yjdai 
	 * @return
	 */
	String getTreeGroup();
	
	/**
	 * 处理Ztree数据结构	
	 * @author yjdai 
	 * @param list
	 * @return
	 */
	String getTreeGroup(List<GroupEntity> list);
	
	/**
	 * 用户部门关联
	 * @author yjdai 
	 * @param users
	 * @param groupId
	 * @return
	 */
	boolean relation(Long[] users, Long groupId);
	
	/**
	 * 作为下拉框的列表
	 * @author yjdai 
	 * @return
	 */
	List<Object> getGroupSource();
}
