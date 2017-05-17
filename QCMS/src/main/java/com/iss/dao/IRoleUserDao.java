/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2016年12月30日
 * @version: 1.0
 */
package com.iss.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iss.entity.RoleUserEntity;

/** 
 * 角色关联用户数据接口
 */
@Repository
public interface IRoleUserDao extends IBaseDao<RoleUserEntity, Long> {
	/**
	 * 根据用户查询关联的角色
	 * @author yjdai 
	 * @param userId 用户编号
	 * @return
	 */
	List<RoleUserEntity> findByUserId(Long userId);
}
