package com.iss.util;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JacksonMapper单例对象
 */
public class JacksonMapper {
	private static ObjectMapper objectMapper = new ObjectMapper();
	
	/**
	 * 构造函数
	 */
	public JacksonMapper() {
		super();
	}
	
	public static ObjectMapper getInstance(){
		return objectMapper;
	}
}
