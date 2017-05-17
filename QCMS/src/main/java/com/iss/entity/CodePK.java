/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2016年12月27日
 * @version: 1.0
 */
package com.iss.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;

/** 
 * 通用代码表联合主键
 */
@Embeddable
public class CodePK implements Serializable {
	/**
	 * @Fields serialVersionUID : long  
	 */
	private static final long serialVersionUID = 1L;
	private String classify_code; //分类编码
	private Integer code; //代码编码
	public String getClassify_code() {
		return classify_code;
	}
	public void setClassify_code(String classify_code) {
		this.classify_code = classify_code;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		return prime * result + (classify_code + code).hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof CodePK))
			return false;
		CodePK pk = (CodePK) obj;
		return pk.getClassify_code().equals(classify_code) && pk.getCode().equals(code);
	}
}
