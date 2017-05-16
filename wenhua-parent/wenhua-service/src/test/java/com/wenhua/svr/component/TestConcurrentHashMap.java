package com.wenhua.svr.component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

public class TestConcurrentHashMap {

	@Test
	public void test1() {
		Map<String, Object> map = new ConcurrentHashMap<>();
		
		map.put("hello", "hello");
		
		map = new HashMap<String, Object>();
		map.put("hello", null);
	}
}
