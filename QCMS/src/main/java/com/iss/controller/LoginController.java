/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2016-06-29
 * @version: 1.0
 */
package com.iss.controller;

import java.util.List;
import java.util.Objects;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.iss.entity.NodeEntity;
import com.iss.entity.RoleEntity;
import com.iss.entity.UserEntity;
import com.iss.service.IGroupService;
import com.iss.service.INodeService;
import com.iss.service.IRoleService;
import com.iss.service.IUserService;
import com.iss.util.ConstantValue;
import com.iss.vo.AjaxJson;

/**
 * 用户登录
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {
	
	private Logger log=LoggerFactory.getLogger(LoginController.class);
	@Autowired
	private IUserService iUserService;
	@Autowired
	private IRoleService iRoleService;
	@Autowired
	private INodeService iNodeService;
	@Autowired
	private IGroupService iGroupService;
	/**
	 * 登录系统
	 * @return
	 */
	@RequestMapping("/entry")
	public String entry(){
		return "login/login";
	}
	
	/**
	 * 退出系统
	 * @return
	 */
	@RequestMapping("/logout")
	public String logout(){
		Subject subject = SecurityUtils.getSubject();  
		subject.logout();
		return "login/login";
	}
	
	/**
	 * 登录校验
	 * @return
	 */
	@RequiresGuest 
	@ResponseBody
	@RequestMapping("/check")
	public AjaxJson check(String username, String password, Model model){
		String msg = "";
		AjaxJson json = new AjaxJson();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);  
	    token.setRememberMe(true);  
	    Subject subject = SecurityUtils.getSubject();  
	    try {  
	        subject.login(token);  
	        if (subject.isAuthenticated()) {
	        	UserEntity entity = iUserService.findByLogin(Objects.toString(token.getPrincipal()));
	        	List<RoleEntity> roles = iRoleService.getLoginUserForRole(entity.getId());
	        	entity.setRoles(roles);//设置用户角色
	        	session.removeAttribute(ConstantValue.SESSION_USER);
	    		session.removeAttribute(ConstantValue.SESSION_LOGIN_USERNAME);
	    		session.setAttribute(ConstantValue.SESSION_USER, entity);
	    		session.setAttribute(ConstantValue.SESSION_LOGIN_USERNAME, entity.getName());
	    		session.removeAttribute(ConstantValue.SESSION_USER_DATA);
	    		session.removeAttribute(ConstantValue.SESSION_GROUP_DATA);
	    		session.setAttribute(ConstantValue.SESSION_USER_DATA, iUserService.getUserSource());
	    		session.setAttribute(ConstantValue.SESSION_GROUP_DATA, iGroupService.getGroupSource());
	    		session.removeAttribute(ConstantValue.SESSION_USER_NODE);
	    		if(!roles.isEmpty() || entity.getIsAdmin()){
	    			List<NodeEntity> list = iNodeService.loadMenu(entity, false);
	    			log.info("------------->"+new Gson().toJson(list));
	    			session.setAttribute(ConstantValue.SESSION_USER_NODE, list);
	    		}
	        }else{
	        	json.setMsg("登录失败，请刷新重试！");  
	        }
	    } catch (IncorrectCredentialsException e) {  
	        msg = "登录账号或密码错误！";
	    } catch (ExcessiveAttemptsException e) {  
	        msg = "登录失败次数过多！";  
	    } catch (LockedAccountException e) {  
	        msg = "帐号已被锁定！";  
	    } catch (DisabledAccountException e) {  
	        msg = "帐号已被禁用！";  
	    } catch (ExpiredCredentialsException e) {  
	        msg = "帐号已过期！";  
	    } catch (UnknownAccountException e) {  
	        msg = "帐号不存在！"; 
	    } catch (UnauthorizedException e) {  
	        msg = "帐号没有登录授权！";  
	    }
	    json.setMsg(msg);
		return json;
	}
}
