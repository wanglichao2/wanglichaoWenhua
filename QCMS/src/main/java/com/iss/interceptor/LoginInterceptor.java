/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2016-12-15
 * @version: 1.0
 */
package com.iss.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.iss.util.ConstantValue;

/** 
 * 验证登录用户信息是否有效
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
	 /**
     * 预处理回调方法，实现处理器的预处理（如登录检查），第三个参数为响应的处理器
     * @param request
     * @param response
     * @param o
     * @return 返回值：true表示继续流程（如调用下一个拦截器或处理器）；
     *        false表示流程中断（如登录检查失败），不会继续调用其他的拦截器或处理器，此时我们需要通过response来产生响应；
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
    	//从Session获取用户登陆信息
    	Object user = request.getSession().getAttribute(ConstantValue.SESSION_USER);
	    if(user == null) {
	    	response.sendRedirect(request.getContextPath()+"/login/entry");//基于登录功能
	    	return false;
	    }
		return true;
    }
}	
