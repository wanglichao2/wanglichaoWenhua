/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2016年9月19日
 * @version: 1.0
 */
package com.iss.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

/** 
 * 系统节点实体
 */
@Entity
@Table(name="t_sys_node")
public class NodeEntity extends BaseEntity {
	private Integer level; 	//节点级别
	private Long parentId;	//父级节点编号
	private Integer type;	//节点类型 1：菜单；2：选项卡；3：按钮
	private String permission;//权限标识符
	private String alias;	//节点别名
	private Integer sort;	//显示顺序
	private String url;		//节点链接路径
	private String icon;	//一级节点图标样式
	private Boolean wxNode; //微信菜单标识 1：是；0：否
	private String wxUrl;	//微信菜单链接
	private List<NodeEntity> childNode;
	public Integer getLevel() {
		return level;
	}
	public void setLevel(Integer level) {
		this.level = level;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Boolean getWxNode() {
		return wxNode;
	}
	public void setWxNode(Boolean wxNode) {
		this.wxNode = wxNode;
	}
	public String getWxUrl() {
		return wxUrl;
	}
	public void setWxUrl(String wxUrl) {
		this.wxUrl = wxUrl;
	}
	@Transient
	public List<NodeEntity> getChildNode() {
		return childNode;
	}
	public void setChildNode(List<NodeEntity> childNode) {
		this.childNode = childNode;
	}
}
