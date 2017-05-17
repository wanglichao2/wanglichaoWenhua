/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2016年12月30日
 * @version: 1.0
 */
package com.iss.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iss.entity.RoleEntity;

/** 
 * 系统角色数据接口
 */
@Repository
public interface IRoleDao extends IBaseDao<RoleEntity, Long> {
	/**
	 * 查询状态正常的角色
	 * @author yjdai 
	 * @return
	 */
	List<RoleEntity> findByStatusTrue();
	/**
	 * 查询所属部门下状态正常的角色
	 * @author yjdai 
	 * @param groupId 所属部门
	 * @return
	 */
	List<RoleEntity> findByStatusTrueAndGroupId(Long groupId);
}
