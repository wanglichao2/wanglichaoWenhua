/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2016年9月19日
 * @version: 1.0
 */
package com.iss.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.iss.dao.ICommonDao;
import com.iss.dao.INodeDao;
import com.iss.dao.ISystemDao;
import com.iss.entity.NodeEntity;
import com.iss.entity.RoleEntity;
import com.iss.entity.UserEntity;
import com.iss.service.INodeService;
import com.iss.vo.TreeNode;

/**
 * 系统节点管理服务层
 */
@Service
public class NodeServiceImpl implements INodeService{
	@Autowired
	private INodeDao iNodeDao;
	@Autowired
	private ICommonDao iCommonDao;
	@Autowired
	private ISystemDao iSystemDao;
	
	@Override
	public List<NodeEntity> load(){
		List<Order> order = new ArrayList<Order>();
		order.add(new Order("level"));
		order.add(new Order(Direction.ASC, "sort"));
		return iNodeDao.findAll(new Sort(order));
	}
	
	@Override
	@Transactional
	public NodeEntity add(NodeEntity entity){
		return iNodeDao.saveAndFlush(entity);
	}
	 
	@Override
	@Transactional
	public boolean update(Long id, String field, String fieldValue){
		return iCommonDao.updateField(id, field, fieldValue, "t_sys_node");
	}
	
	@Override
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		if(id==null)return true;
		this.iNodeDao.delete(id);
		return true;
	}

	@Override
	public List<NodeEntity> loadMenu(UserEntity user, boolean isWechat){
		List<Long> roles = new ArrayList<Long>();//迭代获取角色编号集合
		List<RoleEntity> roleSet = user.getRoles();
		for (RoleEntity entity : roleSet) {
			roles.add(entity.getId());
		}
		List<NodeEntity> node = new ArrayList<NodeEntity>();
		List<NodeEntity> list = null;
		if(user.getIsAdmin()){
			list = iNodeDao.findByTypeAndStatusTrueOrderBySortAsc(1);
		}else{
			list = iSystemDao.queryNodesForRoles(roles, true, isWechat);
		}
		for (NodeEntity nodeEntity : list) {//一级节点集合
			if(nodeEntity.getParentId()==0){
				node.add(nodeEntity);
			}
		}
		list.removeAll(node);
		for (NodeEntity nodeEntity : node) {//处理二级节点
			List<NodeEntity> childNode = new ArrayList<NodeEntity>();
			for (NodeEntity children : list) {
				if(nodeEntity.getId()==children.getParentId()){
					childNode.add(children);
				}
			}
			nodeEntity.setChildNode(childNode);
		}
		return node;
	}
	
	@Override
	public String getTreeNode(){
		List<NodeEntity> list = iNodeDao.findByStatusTrueOrderBySort();
		return getTreeNode(list);
	}
	
	@Override
	public String getTreeNodeForUser(List<RoleEntity> roleSet){
		List<Long> roles = new ArrayList<Long>();//迭代获取角色编号集合
		for (RoleEntity entity : roleSet) {
			roles.add(entity.getId());
		}
		List<NodeEntity> list = iSystemDao.queryNodesForRoles(roles, false, false);
		return getTreeNode(list);
	}
	
	@Override
	public String getTreeNode(List<NodeEntity> list){
		List<TreeNode> treeNode = new ArrayList<TreeNode>();
		TreeNode node = new TreeNode(0L, -1L, "文化监管平台", "文化监管平台", true);
		treeNode.add(node);
		for (NodeEntity e : list) {
			treeNode.add(new TreeNode(e.getId(), e.getParentId(), e.getName(),
					e.getName(), e.getLevel() == 1));
		}
		Gson gson = new Gson();
		String json = gson.toJson(treeNode);
		treeNode = null;
		return json;
	}
}
