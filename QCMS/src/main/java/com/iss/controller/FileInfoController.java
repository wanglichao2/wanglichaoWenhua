/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2017年2月13日
 * @version: 1.0
 */
package com.iss.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.iss.entity.FileInfoEntity;
import com.iss.entity.NetBar2Entity;
//import com.iss.entity.NetBarEntity;
import com.iss.service.IAreasCodeService;
import com.iss.service.IFileInfoService;
import com.iss.service.INetBar2Service;
//import com.iss.service.INetBarService;
import com.iss.util.JsonUtil;
import com.iss.vo.AjaxJson;
import com.iss.vo.DataParam;
import com.iss.vo.DataTables;

/**
 * 缺陷管理
 */
@Controller
@RequestMapping("/fileinfo")
public class FileInfoController extends BaseController {
	@Autowired
	private IFileInfoService iFileInfoService;
	@Autowired
	private INetBar2Service iNetBarService;
	@Autowired
	private IAreasCodeService iAreasCodeService;

	@RequestMapping("/list")
	public String list(Model model) {
		String json = iAreasCodeService.getTreeAreas(null);
		model.addAttribute("areasTree", json);
		List<NetBar2Entity> netbarList = iNetBarService.load();
		model.addAttribute("netbarList", netbarList);
		return "wh/fileinfo_list";
	}

	@RequestMapping("/delList")
	public String delList(Model model) {
		return "wh/fileinfo_dellist";
	}

	@ResponseBody
	@RequestMapping(value = "/load", produces = "application/json;charset=UTF-8")
	public String load(DataParam param) {
		param.getSearch().put("status", "1");
		DataTables<FileInfoEntity> dt = iFileInfoService.load(param);
		return JsonUtil.toJson(dt);
	}

	@ResponseBody
	@RequestMapping(value = "/loadDel", produces = "application/json;charset=UTF-8")
	public String loadDel(DataParam param) {
		param.getSearch().put("status", "0");
		DataTables<FileInfoEntity> dt = iFileInfoService.load(param);
		return JsonUtil.toJson(dt);
	}

	@ResponseBody
	@RequestMapping(value = "/loadNetBar", produces = "application/json;charset=UTF-8")
	public String loadNetBar(DataParam param) {
		param.setLength(-1);
		param.setDraw(1);
		param.setStart(0);
		DataTables<NetBar2Entity> dt = iNetBarService.load(param);
		return JsonUtil.toJson(dt);
	}

	@ResponseBody
	@RequestMapping("/edit")
	public ModelAndView edit(FileInfoEntity entity) {
		entity.setCreator(userEntity.getId());
		iFileInfoService.saveOrUpdate(entity);
		return new ModelAndView("redirect:/fileinfo/list");
	}

	@ResponseBody
	@RequestMapping("/del")
	public AjaxJson del(Long pk, String name, String value) {
		AjaxJson json = new AjaxJson();
		boolean bool = iFileInfoService.update(pk, name, value);
		json.setFlag(bool);
		return json;
	}

	@ResponseBody
	@RequestMapping("/importDataNew")
	public ModelAndView importDataNew(@RequestParam("file") MultipartFile file, FileInfoEntity entity) {
		if (!file.isEmpty()) {
			try {
				// 获取文件名
				String filename = file.getOriginalFilename();
				entity.setFilename(filename);
				// 获取数据二进制数组
				entity.setData(file.getBytes());
				entity.setCreator(userEntity.getId());
				iFileInfoService.saveOrUpdate(entity);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return new ModelAndView("redirect:/fileinfo/list");
	}
}