/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2016年6月29日
 * @version: 1.0
 */
package com.iss.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.iss.entity.UserEntity;

/**
 * 用户数据接口
 */
@Repository
public interface IUserDao extends IBaseDao<UserEntity, Long> {
	/**
	 * 查询状态正常的用户信息
	 * @author yjdai 
	 * @return
	 */
	List<UserEntity> findByStatusTrue();
	
	/**
	 * 查询状态正常的用户信息
	 * @author yjdai 
	 * @return
	 */
	List<UserEntity> findByStatusTrueOrderByName();
	
	/**
	 * 根据登录名查询用户信息
	 * @author yjdai 
	 * @param login
	 * @return
	 */
	UserEntity findByLogin(String login);
	
	/**
	 * 查询所属部门下状态正常的用户信息
	 * @author yjdai 
	 * @param groupId 所属部门
	 * @return
	 */
	List<UserEntity> findByStatusTrueAndGroupId(Long groupId);
	/**
	 * 查询多个部门下状态正常的用户信息
	 * @author yjdai 
	 * @param groupId 所属部门
	 * @return
	 */
	List<UserEntity> findByStatusTrueAndGroupIdIn(List<Long> groupId);
}
