/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2016-06-29
 * @version: 1.0
 */
package com.iss.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.iss.constants.SystemConstants;
import com.iss.dao.ICommonDao;
import com.iss.dao.IUserDao;
import com.iss.entity.UserEntity;
import com.iss.service.IUserService;
import com.iss.vo.DataValue;

/**
 * 用户信息服务层
 */
@Service
public class UserServiceImpl implements IUserService{
	@Autowired
	private IUserDao iUserDao;
	@Autowired
	private ICommonDao iCommonDao;
	
	@Override
	public List<UserEntity> load(){
		return iUserDao.findAll();
	}
	
	@Override
	public List<UserEntity> loadUser(){
		return iUserDao.findByStatusTrue();
	}
	
	@Override
	public UserEntity findByLogin(String login){
		return iUserDao.findByLogin(login);
	}
	
	@Override
	@Transactional
	public UserEntity add(UserEntity entity){
		UserEntity user = iUserDao.saveAndFlush(entity);
		return user;
	}
	
	@Override
	@Transactional
	public boolean update(Long id, String field, String fieldValue){
		return iCommonDao.updateField(id, field, fieldValue, "t_sys_user");
	}
	
	
	
	@Override
	@Transactional(rollbackFor=Exception.class)
	public boolean delete(Long id)throws Exception {
		// TODO Auto-generated method stub
		if(id==null)return true;
		UserEntity user=this.iUserDao.findOne(id);
		if(user==null)throw new Exception("上传用户ID【"+id+"】不存在");
		if(SystemConstants.ADMINISTRATOR_NAME.equals(user.getLogin())){
			throw new Exception("当前用户为超级管理员不能删除");
		}
		this.iCommonDao.delUserRoles(id, null);
		this.iCommonDao.delUserAreas(id, null);
		this.iUserDao.delete(id);
		return true;
	}

	@Override
	public List<UserEntity> getUserForGroup(Long groupId){
		return iUserDao.findByStatusTrueAndGroupId(groupId);
	}
	
	@Override
	public List<Object> getUserSource(){
		String json="", _json="";
		Map<Long, String> map = null;
		List<Object> result = new ArrayList<Object>();
		map = new HashMap<Long, String>();
		List<DataValue> dvSet = new ArrayList<DataValue>();
		List<UserEntity> list = iUserDao.findByStatusTrueOrderByName();
		Map<Long, List<DataValue>> tempSet = new HashMap<Long, List<DataValue>>();
		for (UserEntity entity : list) {
			Long id = entity.getId();
			Long groupId = entity.getGroupId();
			String name = entity.getName();
			DataValue dv = new DataValue(Objects.toString(id, "0"), name, groupId);
			dvSet.add(dv);
			map.put(id, name);
			List<DataValue> data = tempSet.get(groupId);
			if(data == null){
				data = new ArrayList<DataValue>();
				tempSet.put(groupId, data);//根据部门分组用户
			}
			data.add(dv);
		}
		Gson gson = new Gson();
		json = gson.toJson(dvSet);
		_json = gson.toJson(map);
		result.add(json);//全部用户
		result.add(_json);//键值对用户
		result.add(map);//键值对用户对象
		Map<Long, String> groupUser = new HashMap<Long, String>();
		for (Map.Entry<Long, List<DataValue>> entry : tempSet.entrySet()) {
			List<DataValue> value = entry.getValue();
			String substr = StringUtils.substringsBetween(gson.toJson(value), "[", "]")[0];
			groupUser.put(entry.getKey(), substr);
		}
		result.add(groupUser);//部门分组用户
		return result;
	}
}
