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

import com.iss.entity.GroupEntity;
import com.iss.service.IGroupService;
import com.iss.vo.AjaxJson;

/**
 * 系统部门管理
 */
@Controller
@RequestMapping("/group")
public class GroupController extends BaseController {
	@Autowired
	private IGroupService iGroupService; 
	
	/**
	 * 加载部门列表
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Model model){
		List<GroupEntity> list = iGroupService.load();
		model.addAttribute("groupSet", list);
		String json = iGroupService.getTreeGroup(list);
		model.addAttribute("groupTree", json);
		return "system/group";
	}
	
	/**
	 * 添加部门信息
	 * @author yjdai 
	 * @param entity
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/add")
	public AjaxJson add(GroupEntity entity){
		AjaxJson json = new AjaxJson();
		GroupEntity node = iGroupService.add(entity);
		if(node != null){
			json.setFlag(true);
			json.setObj(node);
		}
		return json;
	}

	/**
	 * 更新部门信息
	 * @author yjdai 
	 * @param pk
	 * @param name
	 * @param value
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/edit")
	public AjaxJson edit(Long pk, String name, String value){
		AjaxJson json = new AjaxJson();
		boolean bool = iGroupService.update(pk, name, value);
		json.setFlag(bool);
		return json;
	}
	
	/**
	 * 用户关联分组信息
	 * @author yjdai 
	 * @param users
	 * @param groupId
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/relation")
	public AjaxJson relation(@RequestParam("users[]")Long[] users, Long groupId){
		AjaxJson json = new AjaxJson();
		boolean bool = iGroupService.relation(users, groupId);
		json.setFlag(bool);
		return json;
	}
}
