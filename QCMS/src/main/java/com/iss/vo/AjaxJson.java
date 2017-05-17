/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2016-12-16
 * @version: 1.0
 */
package com.iss.vo;

import java.util.Map;

/**
 * $.ajax前端接受的JSON
 */
public class AjaxJson {
	/**信息提示开关*/
	private Boolean flag = false;
	/**提示信息*/
	private String msg = "";
	/**其他信息*/
	private Object obj = null;
	/**其他参数*/
	private Map<String, Object> attr;
	
	public AjaxJson(){}
	/**
	 * @param msg
	 */
	public AjaxJson(Boolean flag, String msg) {
		super();
		this.flag = flag;
		this.msg = msg;
	}
	/**
	 * @param msg
	 * @param obj
	 */
	public AjaxJson(Boolean flag, String msg, Object obj) {
		super();
		this.flag = flag;
		this.msg = msg;
		this.obj = obj;
	}
	/**
	 * @param msg
	 * @param obj
	 * @param attr
	 */
	public AjaxJson(Boolean flag, String msg, Object obj, Map<String, Object> attr) {
		super();
		this.flag = flag;
		this.msg = msg;
		this.obj = obj;
		this.attr = attr;
	}
	
	public Boolean getFlag() {
		return flag;
	}
	public void setFlag(Boolean flag) {
		this.flag = flag;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getObj() {
		return obj;
	}
	public void setObj(Object obj) {
		this.obj = obj;
	}
	public Map<String, Object> getAttr() {
		return attr;
	}
	public void setAttr(Map<String, Object> attr) {
		this.attr = attr;
	}
}
