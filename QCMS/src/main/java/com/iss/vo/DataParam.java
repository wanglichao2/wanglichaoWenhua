/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2016年8月14日
 * @version: 1.0
 */
package com.iss.vo;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/** 
 * 接受Datatables的Ajax请求参数
 */
public class DataParam implements Serializable{
	/**
	 * @Fields serialVersionUID : long  
	 */
	private static final long serialVersionUID = -6734095827844740214L;
	private Integer draw;//绘制计数器
	private Integer start;//第一条数据的起始位置
	private Integer length;//服务器每页显示的条数
	private Map<String, String> search;//全局的搜索条件
	private List<Map<String, String>> order;//排序的列和排序方式
	public Integer getDraw() {
		return draw;
	}
	public void setDraw(Integer draw) {
		this.draw = draw;
	}
	public Integer getStart() {
		return start;
	}
	public void setStart(Integer start) {
		this.start = start;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	public Map<String, String> getSearch() {
		return search;
	}
	public void setSearch(Map<String, String> search) {
		this.search = search;
	}
	public List<Map<String, String>> getOrder() {
		return order;
	}
	public void setOrder(List<Map<String, String>> order) {
		this.order = order;
	}
}
