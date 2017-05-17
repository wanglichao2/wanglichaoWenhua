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
 * 系统部门实体
 */
@Entity
@Table(name="t_sys_group")
public class GroupEntity extends BaseEntity {
	private Integer level; 	//部门级别
	private Long parentId;	//父级部门编号
	private String alias;	//部门别名
	private Integer sort;	//显示顺序
	private List<GroupEntity> childNode;
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
	@Transient
	public List<GroupEntity> getChildNode() {
		return childNode;
	}
	public void setChildNode(List<GroupEntity> childNode) {
		this.childNode = childNode;
	}
}
