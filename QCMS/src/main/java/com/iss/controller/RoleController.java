/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2016-06-29
 * @version: 1.0
 */
package com.iss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iss.entity.RoleEntity;
import com.iss.entity.UserEntity;
import com.iss.service.INodeService;
import com.iss.service.IRoleService;
import com.iss.service.IUserService;
import com.iss.vo.AjaxJson;

/**
 * 系统角色管理
 */
@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {
	@Autowired
	private INodeService iNodeService;
	@Autowired
	private IRoleService iRoleService;
	@Autowired
	private IUserService iUserService;
	
	/**
	 * 角色赋权页面
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Model model){
		String json = null;
		List<RoleEntity> roleSet = null;
		List<UserEntity> userSet = null;
		roleSet = iRoleService.load();
		json = iNodeService.getTreeNode();
		userSet = iUserService.loadUser();
		/*if(userEntity.getIsAdmin()){
			roleSet = iRoleService.load();
			json = iNodeService.getTreeNode();
			userSet = iUserService.loadUser();
		}else{
			Long groupId = userEntity.getGroupId();
			roleSet = iRoleService.load(groupId);
			json = iNodeService.getTreeNodeForUser(userEntity.getRoles());
			userSet = iUserService.getUserForGroup(groupId);
		}*/
		model.addAttribute("roleSet", roleSet);
		model.addAttribute("nodeSet", json);
		model.addAttribute("userSet", userSet);
		return "system/role";
	}
	
	/**
	 * 添加角色信息
	 * @author yjdai 
	 * @param entity
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/add")
	public AjaxJson add(RoleEntity entity){
		AjaxJson json = new AjaxJson();//角色所属部门与当前登录用一致
		if(!userEntity.getIsAdmin()){
			entity.setGroupId(userEntity.getGroupId());
		}
		RoleEntity node = iRoleService.add(entity);
		if(node != null){
			json.setFlag(true);
			json.setObj(node);
		}
		return json;
	}

	/**
	 * 更新角色信息
	 * @author yjdai 
	 * @param pk
	 * @param name
	 * @param value
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/edit")
	public AjaxJson edit(Long pk, String name, String value){
		AjaxJson json = new AjaxJson();
		boolean bool = iRoleService.update(pk, name, value);
		json.setFlag(bool);
		return json;
	}
	
	/**
	 * 添加角色节点关联
	 * @author yjdai 
	 * @param nodes
	 * @param roles
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/authority")
	public AjaxJson authority(@RequestParam("nodes[]")Long[] nodes, 
				@RequestParam("roles[]")Long[] roles){
		AjaxJson json = new AjaxJson();
		boolean bool = iRoleService.authority(nodes, roles);
		json.setFlag(bool);
		return json;
	}
	
	/**
	 * 回收角色节点关联
	 * @author yjdai 
	 * @param nodes
	 * @param roles
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/revoke")
	public AjaxJson revoke(@RequestParam("nodes[]")Long[] nodes, 
			@RequestParam("roles[]")Long[] roles){
		AjaxJson json = new AjaxJson();
		boolean bool = iRoleService.revoke(nodes, roles);
		json.setFlag(bool);
		return json;
	}
	
	/**
	 * 角色关联用户信息
	 * @author yjdai 
	 * @param nodes
	 * @param roles
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/relation")
	public AjaxJson relation(@RequestParam("roles[]")Long[] roles,
				@RequestParam("users[]")Long[] users){
		AjaxJson json = new AjaxJson();
		boolean bool = iRoleService.relation(roles, users);
		json.setFlag(bool);
		return json;
	}
	
	/**
	 * 回收角色关联用户信息
	 * @author yjdai 
	 * @param nodes
	 * @param roles
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/recovery")
	public AjaxJson recovery(@RequestParam("roles[]")Long[] roles,
			@RequestParam("users[]")Long[] users){
		AjaxJson json = new AjaxJson();
		boolean bool = iRoleService.recovery(roles, users);
		json.setFlag(bool);
		return json;
	}
	
	/**
	 * 根据用户查询关联的角色
	 * @author yjdai 
	 * @param userId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/relationRole")
	public Long[] relationRole(Long userId){
		return iRoleService.getRolesForUser(userId);
	}
	
	/**
	 * 根据角色查询关联的节点
	 * @author yjdai 
	 * @param roleId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/relationNode")
	public Long[] relationNode(Long roleId){
		return iRoleService.getNodesForRole(roleId);
	}
}
