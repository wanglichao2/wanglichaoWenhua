/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2016-12-16
 * @version: 1.0
 */
package com.iss.dao;

import java.util.List;

import com.iss.entity.AreasEntity;
import com.iss.entity.NodeEntity;
import com.iss.entity.RoleEntity;
import com.iss.entity.UserAreaEntity;

/**
 * 系统管理持久化数据接口
 */
public interface ISystemDao{
	/**
	 * 角色节点赋权
	 * @author yjdai 
	 * @param nodes
	 * @param roles
	 * @return
	 */
	boolean updateRoleNode(Long[] nodes, Long[] roles);
	
	/**
	 * 删除角色节点关联
	 * @author yjdai 
	 * @param nodes
	 * @param roles
	 * @return
	 */
	boolean deleteRoleNode(Long[] nodes, Long[] roles);
	
	/**
	 * 角色用户关联
	 * @author yjdai 
	 * @param roles
	 * @param users
	 * @return
	 */
	boolean updateRoleUser(Long[] roles, Long[] users);
	
	/**
	 * 删除角色用户关联
	 * @author yjdai 
	 * @param roles
	 * @param users
	 * @return
	 */
	boolean deleteRoleUser(Long[] roles, Long[] users);
	
	/**
	 * 根据用户查询关联的角色
	 * @author yjdai 
	 * @param userId
	 * @return
	 */
	List<RoleEntity> queryRolesForUser(Long userId);
	
	/**
	 * 根据角色查询关联的节点
	 * @author yjdai 
	 * @param roles
	 * @param isMenu 菜单标识
	 * @param isWechat 微信标识
	 * @return
	 */
	List<NodeEntity> queryNodesForRoles(List<Long> roles, boolean isMenu, boolean isWechat);
	
	/**
	 * 用户部门关联
	 * @author yjdai 
	 * @param users
	 * @param groupId
	 * @return
	 */
	boolean updateUserGroup(Long[] users, Long groupId);
	
	List<UserAreaEntity> queryAreasForUsers(Long[]userIds);
	void deleteUserAreas(Long userId);
	
	List<AreasEntity> queryUserAreaEntity(Long userId);
}
