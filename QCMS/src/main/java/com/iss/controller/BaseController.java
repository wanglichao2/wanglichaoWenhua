/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2016年12月30日
 * @version: 1.0
 */
package com.iss.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iss.entity.UserEntity;
import com.iss.util.ConstantValue;

/**
 * 基础控制器
 */
@Controller
@RequestMapping("/base")
public class BaseController {
    //全局系统对象
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;
    protected UserEntity userEntity;
    
    /**
     * 设置全局模型属性
     * @author: yjdai
     * @param request
     * @param response
     */
	@ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
        this.session = request.getSession();
        userEntity = (UserEntity)session.getAttribute(ConstantValue.SESSION_USER);
        request.setAttribute("basePath", request.getContextPath());
    }
}
