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
 * 角色用户关系实体
 */
@Entity
@Table(name="t_role_user")
public class RoleUserEntity extends IdEntity{
	private Long roleId;//角色编号
	private Long userId;//用户编号
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
