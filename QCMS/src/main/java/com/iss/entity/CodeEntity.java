/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2016年12月30日
 * @version: 1.0
 */
package com.iss.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/** 
 * 通用代码表
 */
@Entity
@Table(name="t_sys_code")
public class CodeEntity {
	@EmbeddedId
	private CodePK pk; //分类编码和代码编码联合主键
	private String classify_name; //分类名称
	private String code_name; //代码名称
	private Boolean status; //代码状态
	public CodePK getPk() {
		return pk;
	}
	public void setPk(CodePK pk) {
		this.pk = pk;
	}
	public String getClassify_name() {
		return classify_name;
	}
	public void setClassify_name(String classify_name) {
		this.classify_name = classify_name;
	}
	public String getCode_name() {
		return code_name;
	}
	public void setCode_name(String code_name) {
		this.code_name = code_name;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
}
