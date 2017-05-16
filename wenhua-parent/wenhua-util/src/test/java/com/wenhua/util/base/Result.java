package com.wenhua.util.base;

import java.util.Map;
import java.util.TreeMap;

public class Result {

	private int age;
	private String name;

	private Map<String, String> values = new TreeMap<>();

	public void add(String key, String value) {
		this.values.put(key, value);
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Map<String, String> getValues() {
		return values;
	}

	public void setValues(Map<String, String> values) {
		this.values = values;
	}

}
