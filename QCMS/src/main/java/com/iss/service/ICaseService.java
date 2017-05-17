/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2017年2月13日
 * @version: 1.0
 */
package com.iss.service;

import java.util.List;

import com.iss.entity.CaseEntity;
import com.iss.vo.DataParam;
import com.iss.vo.DataTables;

/** 
 * 用例管理服务接口
 */
public interface ICaseService {
	
	/**
	 * 加载全部数据
	 * @author yjdai
	 * @return
	 */
	List<CaseEntity> load();
	
	/**
	 * 加载分页数据
	 * @author yjdai
	 * @param param Datatables搜索、分页参数 
	 * @return
	 */
	DataTables<CaseEntity> load(DataParam param);
	
	/**
	 * 查询状态正常的数据
	 * @author yjdai 
	 * @return
	 */
	List<CaseEntity> query();
	
	/**
	 * 保存数据
	 * @author yjdai 
	 * @param entity
	 * @return
	 */
	CaseEntity save(CaseEntity entity);
	
	/**
	 * 编辑数据
	 * @author yjdai 
	 * @param id
	 * @param field
	 * @param fieldValue
	 * @param suffix 表名后缀
	 * @return
	 */
	boolean update(Long id, String field, String fieldValue, String suffix);
	
	/**
	 * 批量删除数据
	 * @author yjdai 
	 * @param ids
	 * @return
	 */
	boolean delBatch(Long[] ids);
	
	/**
	 * 批量导入数据
	 * @author yjdai 
	 * @param list
	 * @return
	 */
	List<CaseEntity> save(List<CaseEntity> list);
}
