package com.wenhua.util.base;

import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

public class TestAjaxResult {

	@Test
	public void test1() {
		AjaxResult result = AjaxResult.getSuccess("request success");
		System.out.println(JSON.toJSON(result));
		
		result.addValue("hello", "world");
		
		System.out.println(JSON.toJSONString(result));
		System.out.println(result.toJSONString());
		Map<String, String> map = new TreeMap<>();
		map.put("hello", "world");
		System.out.println(JSON.toJSONString(map));

	}
	
	@Test
	public void test2() {
		Result result = new Result();
		result.add("hello", "world");
		System.out.println(JSON.toJSONString(result));
	}
}
