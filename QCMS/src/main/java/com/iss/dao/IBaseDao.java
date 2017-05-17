/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2016-12-16
 * @version: 1.0
 */
package com.iss.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * 基础数据接口
 */
@NoRepositoryBean
public interface IBaseDao<T, PK extends Serializable> extends
		JpaRepository<T, PK>, JpaSpecificationExecutor<T> {

}
