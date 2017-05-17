/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2016-12-16
 * @version: 1.0
 */
package com.iss.dao;

import com.iss.entity.CaseEntity;
import com.iss.vo.DataParam;
import com.iss.vo.DataTables;

/**
 * 用例管理持久化数据接口
 */
public interface ICaseJPADao{
	/**
	 * 查询Datatables表格数据
	 * @author yjdai 
	 * @param param
	 * @return
	 */
	DataTables<CaseEntity> query(DataParam param);
}
