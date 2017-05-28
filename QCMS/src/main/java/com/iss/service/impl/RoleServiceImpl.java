/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2016年9月19日
 * @version: 1.0
 */
package com.iss.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iss.dao.ICommonDao;
import com.iss.dao.IRoleDao;
import com.iss.dao.IRoleNodeDao;
import com.iss.dao.IRoleUserDao;
import com.iss.dao.ISystemDao;
import com.iss.entity.RoleEntity;
import com.iss.entity.RoleNodeEntity;
import com.iss.entity.RoleUserEntity;
import com.iss.service.IRoleService;
import com.iss.util.CommonUtil;

/**
 * 系统角色管理服务层
 */
@Service
public class RoleServiceImpl implements IRoleService{
	@Autowired
	private IRoleDao iRoleDao;
	@Autowired
	private ICommonDao iCommonDao;
	@Autowired
	private IRoleUserDao iRoleUserDao;
	@Autowired
	private IRoleNodeDao iRoleNodeDao;
	@Autowired
	private ISystemDao iSystemDao;
	
	@Override
	public List<RoleEntity> load(){
		return iRoleDao.findAll();
	}
	
	@Override
	public List<RoleEntity> load(Long groupId){
		return iRoleDao.findByStatusTrueAndGroupId(groupId);
	}
	
	@Override
	@Transactional
	public RoleEntity add(RoleEntity entity){
		return iRoleDao.saveAndFlush(entity);
	}
	 
	@Override
	@Transactional
	public boolean update(Long id, String field, String fieldValue){
		return iCommonDao.updateField(id, field, fieldValue, "t_sys_role");
	}
	
	
	
	@Override
	@Transactional
	public boolean delete(Long id) {
		// TODO Auto-generated method stub
		if(id==null)return true;
		this.iCommonDao.delRoleNodes(id);
		this.iCommonDao.delRoleUsers(id);
		this.iRoleDao.delete(id);
		return true;
	}

	@Override
	@Transactional
	public boolean authority(Long[] nodes, Long[] roles){
//		return iSystemDao.updateRoleNode(nodes, roles);
		if(CommonUtil.isEmpty(roles)){
			return true;
		}
		this.iSystemDao.deleteRoleNode(nodes, roles);
		this.iSystemDao.updateRoleNode(nodes, roles);
		return true;
		/*for(Long role:roles){
			if(CommonUtil.isEmpty(nodes)){
				
			}
			this.iSystemDao.queryNodesInRole(role);
		}*/
		
	}
	
	@Override
	@Transactional
	public boolean revoke(Long[] nodes, Long[] roles){
		return iSystemDao.deleteRoleNode(nodes, roles);
	}
	
	@Override
	@Transactional
	public boolean relation(Long[] roles, Long[] users){
		this.iSystemDao.deleteRoleUser(roles, users);
		return iSystemDao.updateRoleUser(roles, users);
		
		
		
	}
	
	@Override
	@Transactional
	public boolean recovery(Long[] roles, Long[] users){
		return iSystemDao.deleteRoleUser(roles, users);
	}
	
	@Override
	public Long[] getRolesForUser(Long userId){
		int i=0;
		List<RoleUserEntity> list = iRoleUserDao.findByUserId(userId);
		Long[] roles = new Long[list.size()];
		for (RoleUserEntity entity : list) {
			roles[i] = entity.getRoleId();
			i++;
		}
		return roles;
	}
	
	@Override
	public Long[] getNodesForRole(Long roleId){
		int i=0;
		List<RoleNodeEntity> list = iRoleNodeDao.findByRoleId(roleId);
		Long[] nodes = new Long[list.size()];
		for (RoleNodeEntity entity : list) {
			nodes[i] = entity.getNodeId();
			i++;
		}
		return nodes;
	}
	
	@Override
	public List<RoleEntity> getLoginUserForRole(Long userId){
		return iSystemDao.queryRolesForUser(userId);
	}
}
