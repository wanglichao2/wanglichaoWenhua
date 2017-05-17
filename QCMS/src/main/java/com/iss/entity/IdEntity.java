/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2016-12-15
 * @version: 1.0
 */
package com.iss.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Id实体
 */
@MappedSuperclass
public class IdEntity {
	/**流水编号*/
	protected Long id;
	
	@Id
	@Column(name="id", nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
}
