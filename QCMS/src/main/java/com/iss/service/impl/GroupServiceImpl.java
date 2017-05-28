/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2016年9月19日
 * @version: 1.0
 */
package com.iss.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.iss.dao.ICommonDao;
import com.iss.dao.IGroupDao;
import com.iss.dao.ISystemDao;
import com.iss.entity.GroupEntity;
import com.iss.service.IGroupService;
import com.iss.vo.DataValue;
import com.iss.vo.TreeNode;

/**
 * 系统部门管理服务层
 */
@Service
public class GroupServiceImpl implements IGroupService{
	@Autowired
	private IGroupDao iGroupDao;
	@Autowired
	private ICommonDao iCommonDao;
	@Autowired
	private ISystemDao iSystemDao;
	
	@Override
	public List<GroupEntity> load(){
		List<Order> order = new ArrayList<Order>();
		order.add(new Order("level"));
		order.add(new Order(Direction.ASC, "sort"));
		return iGroupDao.findAll(new Sort(order));
	}
	
	@Override
	@Transactional
	public GroupEntity add(GroupEntity entity){
		return iGroupDao.saveAndFlush(entity);
	}
	 
	@Override
	@Transactional
	public boolean update(Long id, String field, String fieldValue){
		return iCommonDao.updateField(id, field, fieldValue, "t_sys_group");
	}
	
	
	
	@Override
	@Transactional
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		if(id==null)return true;
		this.iGroupDao.delete(id);
		return true;
	}

	@Override
	public String getTreeGroup(){
		List<GroupEntity> list = iGroupDao.findByStatusTrueOrderBySort();
		return getTreeGroup(list);
	}
	
	@Override
	public String getTreeGroup(List<GroupEntity> list){
		List<TreeNode> treeNode = new ArrayList<TreeNode>();
		TreeNode node = new TreeNode(0L, -1L, "部门", "部门", true);
		treeNode.add(node);
		for (GroupEntity e : list) {
			treeNode.add(new TreeNode(e.getId(), e.getParentId(), e.getName(),
					e.getName(), e.getLevel() == 1));
		}
		Gson gson = new Gson();
		String json = gson.toJson(treeNode);
		treeNode = null;
		return json;
	}
	
	@Override
	@Transactional
	public boolean relation(Long[] users, Long groupId){
		return iSystemDao.updateUserGroup(users, groupId);
	}
	
	@Override
	public List<Object> getGroupSource(){
		String json="", _json="";
		Map<Long, String> map = null;
		List<Object> result = new ArrayList<Object>();
		map = new HashMap<Long, String>();
		List<DataValue> dvSet = new  ArrayList<DataValue>();
		List<GroupEntity> list = iGroupDao.findByStatusTrueOrderBySort();
		for (GroupEntity entity : list) {
			Long id = entity.getId();
			String name = entity.getName();
			dvSet.add(new DataValue(Objects.toString(id, "0"), name));
			map.put(id, name);
		}
		Gson gson = new Gson();
		json = gson.toJson(dvSet);
		_json = gson.toJson(map);
		result.add(json);
		result.add(_json);
		result.add(map);
		return result;
	}
}
