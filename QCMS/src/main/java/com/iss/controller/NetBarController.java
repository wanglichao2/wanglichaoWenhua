/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2017年2月13日
 * @version: 1.0
 */
package com.iss.controller;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iss.entity.AreasEntity;
import com.iss.entity.NetBarEntity;
import com.iss.service.IAreasCodeService;
import com.iss.service.INetBarService;
import com.iss.util.HttpClientUtil;
import com.iss.util.JsonUtil;
import com.iss.util.PropertiesUtil;
import com.iss.util.StringUtil;
import com.iss.vo.AjaxJson;
import com.iss.vo.DataParam;
import com.iss.vo.DataTables;

/**
 * 缺陷管理
 */
@Controller
@RequestMapping("/netbar")
public class NetBarController extends BaseController {
	@Autowired
	private INetBarService iNetBarService;
	@Autowired
	private IAreasCodeService iAreasCodeService;
	
	@RequestMapping("/regList")
	public String regList(Model model){
		List<AreasEntity> areasList = iAreasCodeService.getTwolevelAreas("410000");
		model.addAttribute("areasList", areasList);
		return "wh/netbar_reg";
	}
	
	/**
	 * 加载列表数据
	 * @author yjdai 
	 * @param param
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/load", produces="application/json;charset=UTF-8")
	public String load(DataParam param){
		DataTables<NetBarEntity> dt = iNetBarService.load(param);
		return JsonUtil.toJson(dt);
	}
	
	/**
	 * 添加数据
	 * @author yjdai 
	 * @param entity
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/add")
	public AjaxJson add(NetBarEntity entity){
		AjaxJson json = new AjaxJson();
		String url = PropertiesUtil.getPropery("addBarUrl");
		if(StringUtil.isEmpty(entity.getId())){
			//判断网吧注册好事是否存在
			boolean flag = iNetBarService.existBusinessRegNo(entity.getBusiness_reg_no());
			if(flag){
				json.setFlag(false);
				json.setMsg("该工商注册号已被注册！");
				return json;
			}
		}else{
			url = PropertiesUtil.getPropery("updateBarUrl");
		}
		
		//保存网吧信息
		entity.setStatus(1);
		entity.setCreator(userEntity.getId());
		entity.setCreate_time(new Timestamp(System.currentTimeMillis()));
		NetBarEntity fixed = iNetBarService.save(entity);
		
		//调用接口
		HttpClientUtil.netBarHttpPost(url+fixed.getId());
		
		if(fixed != null){
			json.setFlag(true);
			json.setObj(fixed);
		}
		return json;
	}
	
	@ResponseBody
	@RequestMapping("/getAreas")
	public AjaxJson getCounty(String areasid){
		AjaxJson json = new AjaxJson();
		if(StringUtil.isNotEmpty(areasid)){
			List<AreasEntity> areasList = iAreasCodeService.getThreelevelAreas(areasid);
			if(areasList != null){
				json.setFlag(true);
				json.setObj(areasList);
			}
		}
		return json;
	}
	
	/**
	 * 更新数据
	 * @author yjdai 
	 * @param pk
	 * @param name
	 * @param value
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/del")
	public AjaxJson del(Long pk, String name, String value){
		AjaxJson json = new AjaxJson();
		boolean bool = iNetBarService.update(pk, name, value);
		//调用接口
		HttpClientUtil.netBarHttpPost(PropertiesUtil.getPropery("updateBarUrl")+pk);
		json.setFlag(bool);
		return json;
	}
}
