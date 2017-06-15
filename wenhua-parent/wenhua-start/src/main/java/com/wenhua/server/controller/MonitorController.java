package com.wenhua.server.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wenhua.server.bean.ApiResult;



@Controller
public class MonitorController {
	
	
	@RequestMapping(value = { "/monitor/channels" },method=RequestMethod.GET)
	public @ResponseBody ApiResult<String> monitorChannels(
			) throws Exception {
		System.out.println("---------------------");
		
		return new ApiResult<>("");
	}
	

}
