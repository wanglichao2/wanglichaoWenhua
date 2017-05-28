/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2016-06-29
 * @version: 1.0
 */
package com.iss.service;

import java.util.List;

import com.iss.entity.UserEntity;

/**
 * 用户信息服务接口
 */
public interface IUserService {
	
	/**
	 * 加载全部用户
	 * @author yjdai 
	 * @return
	 */
	List<UserEntity> load();
	/**
	 * 加载状态正常的用户
	 * @author yjdai 
	 * @return
	 */
	List<UserEntity> loadUser();
	
	/**
	 * 根据登录名查询用户
	 * @author yjdai 
	 * @param login
	 * @return
	 */
	UserEntity findByLogin(String login);
	
	/**
	 * 添加用户信息
	 * @author yjdai 
	 * @param entity
	 * @return
	 */
	UserEntity add(UserEntity entity);
	
	/**
	 * 更新用户信息
	 * @author yjdai 
	 * @param id
	 * @param field
	 * @param fieldValue
	 * @return
	 */
	boolean update(Long id, String field, String fieldValue);
	
	boolean delete(Long id)throws Exception;
	
	/**
	 * 获取当前用户所属部门下的用户
	 * @author yjdai 
	 * @param groupId 所属部门
	 * @return
	 */
	List<UserEntity> getUserForGroup(Long groupId);
	
	/**
	 * 作为下拉框的列表
	 * @author yjdai 
	 * @return
	 */
	List<Object> getUserSource();
}
