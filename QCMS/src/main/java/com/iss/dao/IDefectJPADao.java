/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2016-12-16
 * @version: 1.0
 */
package com.iss.dao;

import com.iss.entity.DefectEntity;
import com.iss.vo.DataParam;
import com.iss.vo.DataTables;

/**
 * 缺陷管理持久化数据接口
 */
public interface IDefectJPADao{
	/**
	 * 查询缺陷Datatables表格数据
	 * @author yjdai 
	 * @param param
	 * @return
	 */
	DataTables<DefectEntity> query(DataParam param);
}
