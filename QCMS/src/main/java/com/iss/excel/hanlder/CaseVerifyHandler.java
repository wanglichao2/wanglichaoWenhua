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

import com.iss.entity.CaseEntity;

/** 
 * 导入用例数据校验
 */
public class CaseVerifyHandler implements IExcelVerifyHandler<CaseEntity> {

	@Override
	public ExcelVerifyHanlderResult verifyHandler(CaseEntity entity) {
		StringBuilder builder = new StringBuilder();
		if(StringUtils.isBlank(entity.getYlms())){
			builder.append("用例描述不能为空！\t");
		}
		if(StringUtils.isBlank(entity.getSjz())){
			builder.append("设计者不能为空！\t");
		}
		if(StringUtils.isBlank(entity.getZt())){
			builder.append("主题不能为空！\t");
		}
		return new ExcelVerifyHanlderResult(StringUtils.isBlank(builder), builder.toString());
	}
}
