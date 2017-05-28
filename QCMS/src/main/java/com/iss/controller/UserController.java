/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2016-06-29
 * @version: 1.0
 */
package com.iss.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iss.entity.UserEntity;
import com.iss.service.IGroupService;
import com.iss.service.IUserAreaService;
import com.iss.service.IUserService;
import com.iss.util.JsonUtil;
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
	
	private Logger log=LoggerFactory.getLogger(UserController.class);
	
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
		UserEntity ue=this.iUserService.findByLogin(entity.getLogin());
		if(ue!=null){
			json.setFlag(false);
			json.setMsg("登录名【"+entity.getLogin()+"】已存在");
			return json;
		}
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
		if("login".equalsIgnoreCase(name)){
			UserEntity ue= this.iUserService.findByLogin(value);
			if(ue!=null && ue.getId().longValue()!=pk.longValue()){
				json.setFlag(false);
				json.setMsg("登录名【"+value+"】已存在");
				return json;
			}
		}
		boolean bool = iUserService.update(pk, name, value);
		json.setFlag(bool);
		return json;
	}
	
	@ResponseBody
	@RequestMapping("/del")
	public AjaxJson delete(Long pk) throws Exception {
		AjaxJson json = new AjaxJson();
		json.setFlag(false);
		try {
			boolean bool = iUserService.delete(pk);
			json.setFlag(bool);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			json.setMsg(e.getMessage());
		} 
		return json;
	}
	
	
	@ResponseBody
	@RequestMapping("/loadUserAreas")
	public String[] relationNode(
			@RequestParam("userId[]")Long[] userId
//			Integer[] userId
			){
		String[] codes= userAreaService.queryUserAreaCodes(userId);
		log.info("===========>"+JsonUtil.toJson(codes));
		return codes;
	}
	
	
	@ResponseBody
	@RequestMapping("/save/userAreas")
	public AjaxJson relation(
			@RequestParam("areaCodes[]")String[] areaCodes,
			@RequestParam("userIds[]")Long[] userIds){
		AjaxJson json = new AjaxJson();
		try {
			String msg = this.userAreaService.saveUserAreaIds(areaCodes, userIds);
			json.setFlag(true);
			json.setMsg("操作成功");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			json.setFlag(false);
			json.setMsg(e.getMessage());
		}
		return json;
	}
}
