/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2016年12月30日
 * @version: 1.0
 */
package com.iss.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iss.entity.RoleNodeEntity;

/** 
 * 角色关联节点数据接口
 */
@Repository
public interface IRoleNodeDao extends IBaseDao<RoleNodeEntity, Long> {
	/**
	 * 根据用户查询关联的节点
	 * @author yjdai 
	 * @param roleId 角色编号
	 * @return
	 */
	List<RoleNodeEntity> findByRoleId(Long roleId);
}
