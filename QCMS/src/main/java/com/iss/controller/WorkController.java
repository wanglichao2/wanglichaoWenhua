/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2016-06-29
 * @version: 1.0
 */
package com.iss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.iss.util.DateUtil;

/**
 * 系统主页
 */
@Controller
@RequestMapping("/work")
public class WorkController extends BaseController {
	
	/**
	 * 框架页面
	 * @return
	 */
	@RequestMapping("/frame")
	public String frame(Model model){
		return "work/frame";
	}
	
	/**
	 * 首页
	 * @return
	 */
	@RequestMapping("/home")
	public String home(Model model){
		model.addAttribute("currentDate", DateUtil.getCurrentDateWeek());
		return "work/home";
	}
	
	/**
	 * 信息显示页面
	 * @return
	 */
	@RequestMapping("/info/{no}")
	public String info(Model model){
		return "work/info";
	}
}
