package com.wenhua.util.tools;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Json处理工具类
 */
public class JsonUtil {
	
	/**
	 * Object集合转Json字符串
	 * @author yjdai 
	 * @param obj Object集合
	 * @return
	 */
	public static String toJson(Object obj) throws RuntimeException{
		if (obj == null) {
			return "";
		}
		StringWriter sw = new StringWriter();
		ObjectMapper objectMapper = JacksonMapper.getInstance();
		try {//json转换
			objectMapper.writeValue(sw, obj);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		return Objects.toString(sw);
	}
	
	/**
	 * json转List集合
	 * @author yjdai
	 * @param json json数据字符串
	 * @param cls 转换实体对象
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> toList(String json) throws Exception{
		if(json==null || "".equals(json)){
			return new ArrayList<T>();
		}
		ObjectMapper objectMapper = JacksonMapper.getInstance();
		return objectMapper.readValue(json, List.class);
	}
	
	/**
	 * json转List集合
	 * @author yjdai
	 * @param json json数据字符串
	 * @param cls 转换实体对象
	 * @return
	 * @throws Exception
	 */
	public static <T> List<T> toList(String json, Class<T> cls) throws Exception{
		if(json==null || "".equals(json)){
			return new ArrayList<T>();
		}
		ObjectMapper objectMapper = JacksonMapper.getInstance();
		return objectMapper.readValue(json, new TypeReference<List<T>>(){});
	}
	
	/**
	 * json转Map集合
	 * @author yjdai
	 * @param json json数据字符串
	 * @param cls 转换实体对象
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public static <T> Map<String, T> toMap(String json) throws Exception{
		if(json==null || "".equals(json)){
			return new HashMap<String, T>();
		}
		ObjectMapper objectMapper = JacksonMapper.getInstance();
		return objectMapper.readValue(json, Map.class);
	}
	
	/**
	 * json转Map集合
	 * @author yjdai
	 * @param json json数据字符串
	 * @param cls 转换实体对象
	 * @return
	 * @throws Exception
	 */
	public static <T> Map<String, T> toMap(String json, Class<T> cls) throws Exception{
		if(json==null || "".equals(json)){
			return new HashMap<String, T>();
		}
		ObjectMapper objectMapper = JacksonMapper.getInstance();
		return objectMapper.readValue(json, new TypeReference<Map<String, T>>(){});
	}
	 
	public static void main(String[] args) {
		String list = "[{\"yhxm\":\"hoojo\",\"yhid\":1},{\"yhxm\":\"wuyao\",\"yhid\":2}]";
		String map = "{\"yhxm\":\"hoojo\",\"yhid\":1}";
		try {
//			System.out.println(toList(list, UserEntity.class));
//			System.out.println(toMap(map, UserEntity.class));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
