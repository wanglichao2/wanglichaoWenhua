/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2016年9月19日
 * @version: 1.0
 */
package com.iss.service;

import java.util.List;

import com.iss.entity.RoleEntity;

/** 
 * 系统角色服务接口
 */
public interface IRoleService {
	/**
	 * 加载数据
	 * @author yjdai 
	 * @return
	 */
	List<RoleEntity> load();
	
	/**
	 * 根据部门加载数据
	 * @author yjdai 
	 * @return
	 */
	List<RoleEntity> load(Long groupId);
	
	/**
	 * 添加数据
	 * @author yjdai 
	 * @param entity
	 * @return
	 */
	RoleEntity add(RoleEntity entity);
	
	/**
	 * 编辑数据
	 * @author yjdai 
	 * @param id
	 * @param field
	 * @param fieldValue
	 * @return
	 */
	boolean update(Long id, String field, String fieldValue);
	
	/**
	 * 角色节点赋权
	 * @author yjdai 
	 * @param nodes
	 * @param roles
	 * @return
	 */
	boolean authority(Long[] nodes, Long[] roles);
	/**
	 * 回收角色节点赋权
	 * @author yjdai 
	 * @param nodes
	 * @param roles
	 * @return
	 */
	boolean revoke(Long[] nodes, Long[] roles);
	
	/**
	 * 角色关联用户
	 * @author yjdai 
	 * @param roles
	 * @param users
	 * @return
	 */
	boolean relation(Long[] roles, Long[] users);
	
	/**
	 * 回收角色关联用户
	 * @author yjdai 
	 * @param roles
	 * @param users
	 * @return
	 */
	boolean recovery(Long[] roles, Long[] users);
	
	/**
	 * 根据用户查询关联的角色
	 * @author yjdai 
	 * @param userId 用户编号
	 * @return
	 */
	Long[] getRolesForUser(Long userId);
	
	/**
	 * 根据角色查询关联的节点
	 * @author yjdai 
	 * @param roleId 角色编号
	 * @return
	 */
	Long[] getNodesForRole(Long roleId);
	
	/**
	 * 获取登录用户的角色集合
	 * @author yjdai 
	 * @param userId
	 * @return
	 */
	List<RoleEntity> getLoginUserForRole(Long userId);
}
