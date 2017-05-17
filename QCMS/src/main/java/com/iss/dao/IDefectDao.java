/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2016年12月30日
 * @version: 1.0
 */
package com.iss.dao;

import org.springframework.stereotype.Repository;

import com.iss.entity.DefectEntity;

/** 
 * 缺陷管理数据接口
 */
@Repository
public interface IDefectDao extends IBaseDao<DefectEntity, Long> {

}
