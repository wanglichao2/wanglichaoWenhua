/**
 * Copyright (R) 2016 chuanqi
 * @author: yjdai
 * @date: 2016年7月5日
 * @version: 1.0
 */
package com.iss.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

/** 
 * Timestamp日期转换器
 */
public class TimestampConverter implements Converter<String, Timestamp>{

	@Override
	public Timestamp convert(String source) {
		 Timestamp t=null;
        if(StringUtils.isNotBlank(source)){
        	try {
        		Pattern pattern = Pattern.compile("\\d{4}/\\d{2}/\\d{2} \\d{2}:\\d{2}");
        		Matcher matcher = pattern.matcher(source);
        		String format = matcher.find() ? "yyyy/MM/dd HH:mm" : "yyyy/MM/dd";
				long time=DateUtil.parseDate(source, format).getTime();
				t=new Timestamp(time);
			} catch (ParseException e) {
				e.printStackTrace();
			}
        }
		return t;
	}
}
