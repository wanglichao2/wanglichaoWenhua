/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2016年8月13日
 * @version: 1.0
 */
package com.iss.vo;

import java.io.Serializable;
import java.util.List;

/** 
 * DataTables JSON数据实体
 * @param <T>
 * @param <T>
 */
public class DataTables<T> implements Serializable{

	/**
	 * @Fields serialVersionUID : long  
	 */
	private static final long serialVersionUID = 6561873563190288999L;
	private Integer draw;//绘制计数器
	private Integer recordsTotal;//记录总数
	private Integer recordsFiltered;
	private List<T> data;
	
	public DataTables() {
		super();
	}
	/**
	 * @author: yjdai 
	 * @param draw
	 * @param recordsTotal
	 * @param recordsFiltered
	 * @param data
	 */
	public DataTables(Integer draw, Integer recordsTotal,
			Integer recordsFiltered, List<T> data) {
		super();
		this.draw = draw;
		this.recordsTotal = recordsTotal;
		this.recordsFiltered = recordsFiltered;
		this.data = data;
	}

	public Integer getDraw() {
		return draw;
	}
	public void setDraw(Integer draw) {
		this.draw = draw;
	}
	public Integer getRecordsTotal() {
		return recordsTotal;
	}
	public void setRecordsTotal(Integer recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
	public Integer getRecordsFiltered() {
		return recordsFiltered;
	}
	public void setRecordsFiltered(Integer recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
	public List<T> getData() {
		return data;
	}
	public void setData(List<T> data) {
		this.data = data;
	}
}
