/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2016年7月13日
 * @version: 1.0
 */
package com.iss.vo;

import java.io.Serializable;

/** 
 * zTree键值实体
 */
public class TreeNode implements Serializable {
	/**
	 * @Fields serialVersionUID : long  
	 */
	private static final long serialVersionUID = 1L;
	private Long id;//节点编号
	private Long pId;//父节点编号
	private String name;//名称
	private String title;//标题
	private Boolean open=false;//是否展开 
	private Boolean checked=false;//是否选中 
	/**
	 * @author: yjdai 
	 * @param id
	 * @param pId
	 * @param name
	 * @param title
	 * @param open
	 */
	public TreeNode(Long id, Long pId, String name, String title, Boolean open) {
		super();
		this.id = id;
		this.pId = pId;
		this.name = name;
		this.open = open;
		this.title = title;
	}
	/**
	 * @author: yjdai 
	 * @param id
	 * @param pId
	 * @param name
	 * @param title
	 * @param open
	 * @param checked
	 */
	public TreeNode(Long id, Long pId, String name, String title, Boolean open,
			Boolean checked) {
		super();
		this.id = id;
		this.pId = pId;
		this.name = name;
		this.title = title;
		this.open = open;
		this.checked = checked;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getpId() {
		return pId;
	}
	public void setpId(Long pId) {
		this.pId = pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Boolean getOpen() {
		return open;
	}
	public void setOpen(Boolean open) {
		this.open = open;
	}
	public Boolean getChecked() {
		return checked;
	}
	public void setChecked(Boolean checked) {
		this.checked = checked;
	}
}
