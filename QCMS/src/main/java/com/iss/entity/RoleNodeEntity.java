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
 * 角色节点关系实体
 */
@Entity
@Table(name="t_role_node")
public class RoleNodeEntity extends IdEntity{
	private Long roleId;//角色编号
	private Long nodeId;//节点编号
	public Long getRoleId() {
		return roleId;
	}
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	public Long getNodeId() {
		return nodeId;
	}
	public void setNodeId(Long nodeId) {
		this.nodeId = nodeId;
	}
}
