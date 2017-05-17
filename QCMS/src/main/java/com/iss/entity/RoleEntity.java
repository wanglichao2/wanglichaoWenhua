/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2016年9月25日
 * @version: 1.0
 */
package com.iss.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

/** 
 * 系统角色实体
 */
@Entity
@Table(name="t_sys_role")
public class RoleEntity extends BaseEntity{
	private String role;	//角色标识符
	private String description; //角色描述
	private Long groupId;	//角色所属部门
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getGroupId() {
		return groupId;
	}
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
}
