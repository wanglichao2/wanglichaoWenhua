/**
 * Copyright (R) 2016 isoftstone
 * @author: yjdai
 * @date: 2017年2月13日
 * @version: 1.0
 */
package com.iss.excel.hanlder;

import org.apache.commons.lang3.StringUtils;
import org.jeecgframework.poi.excel.entity.result.ExcelVerifyHanlderResult;
import org.jeecgframework.poi.handler.inter.IExcelVerifyHandler;

import com.iss.entity.DefectEntity;

/** 
 * 导入缺陷数据校验
 */
public class DefectVerifyHandler implements IExcelVerifyHandler<DefectEntity> {

	@Override
	public ExcelVerifyHanlderResult verifyHandler(DefectEntity entity) {
		StringBuilder builder = new StringBuilder();
		if(StringUtils.isBlank(entity.getZt())){
			builder.append("主题不能为空！\t");
		}
		if(StringUtils.isBlank(entity.getBt())){
			builder.append("标题不能为空！\t");
		}
		if(StringUtils.isBlank(entity.getFxr())){
			builder.append("发现人不能为空！\t");
		}
		return new ExcelVerifyHanlderResult(StringUtils.isBlank(builder), builder.toString());
	}
}
