/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2016年9月19日
 * @version: 1.0
 */
package com.iss.service;

import java.util.List;

import com.iss.entity.NodeEntity;
import com.iss.entity.RoleEntity;
import com.iss.entity.UserEntity;

/** 
 * 系统节点服务接口
 */
public interface INodeService {
	/**
	 * 加载数据
	 * @author yjdai 
	 * @return
	 */
	List<NodeEntity> load();
	
	/**
	 * 添加数据
	 * @author yjdai 
	 * @param entity
	 * @return
	 */
	NodeEntity add(NodeEntity entity);
	
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
	 * 加载首页菜单（根据角色获取菜单）
	 * @author yjdai
	 * @param user 用户实体
	 * @param isWechat 微信端获取节点
	 * @return
	 */
	List<NodeEntity> loadMenu(UserEntity user, boolean isWechat);
	
	/**
	 * 获取状态正常的节点
	 * @author yjdai 
	 * @param list
	 * @return
	 */
	String getTreeNode();
	
	/**
	 * 根据角色获取状态正常的节点
	 * @author yjdai 
	 * @param roleSet 角色集合
	 * @return
	 */
	String getTreeNodeForUser(List<RoleEntity> roleSet);
	
	/**
	 * 处理Ztree数据结构	
	 * @author yjdai 
	 * @param list
	 * @return
	 */
	String getTreeNode(List<NodeEntity> list);
}
