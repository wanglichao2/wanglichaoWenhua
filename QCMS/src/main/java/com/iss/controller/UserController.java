/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2016-06-29
 * @version: 1.0
 */
package com.iss.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iss.entity.UserEntity;
import com.iss.service.IGroupService;
import com.iss.service.IUserAreaService;
import com.iss.service.IUserService;
import com.iss.vo.AjaxJson;

/**
 * 系统用户管理
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {
	@Autowired
	private IUserService iUserService;
	@Autowired
	private IGroupService iGroupService; 
	@Autowired
	private IUserAreaService userAreaService;
	
	/**
	 * 加载用户列表
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Model model){
		List<UserEntity> list = iUserService.load();
		model.addAttribute("userSet", list);
		String json = iGroupService.getTreeGroup();
		model.addAttribute("groupTree", json);
		return "system/user";
	}
	
	/**
	 * 添加用户信息
	 * @author yjdai 
	 * @param entity
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/add")
	public AjaxJson add(UserEntity entity){
		AjaxJson json = new AjaxJson();//密码MD5加密
		String password = DigestUtils.md5DigestAsHex(entity.getPassword().getBytes());
		entity.setPassword(password);
		UserEntity user = iUserService.add(entity);
		if(user != null){
			json.setFlag(true);
			json.setObj(user);
		}
		return json;
	}

	/**
	 * 更新用户信息
	 * @author yjdai 
	 * @param pk
	 * @param name
	 * @param value
	 * @return
	 * @throws Exception
	 */
	@ResponseBody
	@RequestMapping("/edit")
	public AjaxJson edit(Long pk, String name, String value) throws Exception {
		AjaxJson json = new AjaxJson();
		if(StringUtils.equals("password", name)){//密码MD5加密
			value = DigestUtils.md5DigestAsHex(value.getBytes());
		}
		boolean bool = iUserService.update(pk, name, value);
		json.setFlag(bool);
		return json;
	}
	
	
	@ResponseBody
	@RequestMapping("/loadUserAreas")
	public String[] relationNode(Integer userId){
		return userAreaService.queryUserAreaIds(userId);
	}
}
