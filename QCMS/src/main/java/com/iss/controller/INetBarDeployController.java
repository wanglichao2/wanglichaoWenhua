package com.iss.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iss.service.INetBarDeployService;
import com.iss.vo.AjaxJson;

@Controller
@RequestMapping("/netbar2/deploy")
public class INetBarDeployController extends BaseController {
	
	private Logger log=LoggerFactory.getLogger(INetBarDeployController.class);
	
	@Autowired
	private INetBarDeployService iNetBarDeployService;

	
	@ResponseBody
	@RequestMapping("/print")
	public AjaxJson printDeploy(
			@RequestParam("barId")String barId
			){
		AjaxJson json = new AjaxJson();
		try {
			this.iNetBarDeployService.printNetBar(barId);
			json.setFlag(true);
			json.setMsg("操作成功");
		} catch (Exception e) {
			// TODO: handle exception
			log.error("",e);
			json.setFlag(false);
			json.setMsg(e.getMessage());
		}
		return json;
	}
	
	@ResponseBody
	@RequestMapping("/upload")
	public AjaxJson uploadDeployInfos(){
		AjaxJson json = new AjaxJson();
		try {
			this.iNetBarDeployService.uploadNetBarDeployInfos();
			json.setFlag(true);
			json.setMsg("操作成功");
		} catch (Exception e) {
			// TODO: handle exception
			log.error("",e);
			json.setFlag(false);
			json.setMsg(e.getMessage());;
		}
		return json;
	}

}
