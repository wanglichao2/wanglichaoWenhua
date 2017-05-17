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
import org.springframework.web.bind.annotation.ResponseBody;

import com.iss.entity.NodeEntity;
import com.iss.service.INodeService;
import com.iss.service.IUserService;
import com.iss.vo.AjaxJson;

/**
 * 系统节点管理
 */
@Controller
@RequestMapping("/node")
public class NodeController extends BaseController {
	@Autowired
	private INodeService iNodeService;
	@Autowired
	private IUserService iUserService;
	
	/**
	 * 加载节点列表
	 * @return
	 */
	@RequestMapping("/list")
	public String list(Model model){
		List<NodeEntity> list = iNodeService.load();
		model.addAttribute("nodeSet", list);
		String json = iNodeService.getTreeNode(list);
		model.addAttribute("nodeTree", json);
		return "system/node";
	}
	
	/**
	 * 添加节点信息
	 * @author yjdai 
	 * @param entity
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/add")
	public AjaxJson add(NodeEntity entity){
		AjaxJson json = new AjaxJson();
		NodeEntity node = iNodeService.add(entity);
		if(node != null){
			json.setFlag(true);
			json.setObj(node);
		}
		return json;
	}

	/**
	 * 更新节点信息
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
		boolean bool = iNodeService.update(pk, name, value);
		json.setFlag(bool);
		return json;
	}
}
