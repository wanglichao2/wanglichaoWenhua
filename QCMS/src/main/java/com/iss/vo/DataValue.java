/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2016年7月13日
 * @version: 1.0
 */
package com.iss.vo;

import java.io.Serializable;

/** 
 * UI下拉选择组件键值实体
 */
public class DataValue implements Serializable {
	/**
	 * @Fields serialVersionUID : long  
	 */
	private static final long serialVersionUID = 1L;
	private String id;//编号
	private String value;//值
	private String text;//文本
	private Long groupId;
	
	/**
	 * @author: yjdai 
	 * @param id
	 * @param text
	 */
	public DataValue(String id, String text) {
		super();
		this.id = id;
		this.text = text;
	}
	/**
	 * @author: yjdai 
	 * @param id
	 * @param text
	 * @param group
	 */
	public DataValue(String id, String text, Long groupId) {
		super();
		this.id = id;
		this.text = text;
		this.groupId = groupId;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
}
