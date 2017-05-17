/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2016-12-24
 * @version: 1.0
 */
package com.iss.component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import com.iss.entity.CodeEntity;
import com.iss.entity.CodePK;
import com.iss.service.InitDataService;

/** 
 * 初始化参数数据
 */
@Component
public class InitBootComponent implements InitializingBean, ServletContextAware{
	private ServletContext servletContext;
	@Autowired
	private InitDataService initDataService;
	/**
	 * 设置上下文
	 * @param servletContext
	 */
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}
	
	/**
	 * 设置上下文参数
	 * @throws Exception
	 */
	@Override
	@SuppressWarnings("unchecked")
	public void afterPropertiesSet() throws Exception {
		Map<String, Object> map = initDataService.loadData();
		Map<String, Map<Integer, String>> sysParam = new HashMap<String, Map<Integer, String>>();
		List<CodeEntity> list =  (List<CodeEntity>) map.get("code");
		for (CodeEntity codeEntity : list) {
			CodePK pk = codeEntity.getPk();
			String classify = pk.getClassify_code();
			Map<Integer, String> param = sysParam.get(classify);
			if(param==null){
				param = new HashMap<Integer, String>();
				sysParam.put(classify, param);
			}
			param.put(pk.getCode(), codeEntity.getCode_name());
		}
		servletContext.setAttribute("sysParam", sysParam);
	}
}
