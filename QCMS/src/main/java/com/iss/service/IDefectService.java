/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2017年2月13日
 * @version: 1.0
 */
package com.iss.service;

import java.util.List;

import com.iss.entity.DefectEntity;
import com.iss.vo.DataParam;
import com.iss.vo.DataTables;

/** 
 * 缺陷管理服务接口
 */
public interface IDefectService {
	
	/**
	 * 加载全部数据
	 * @author yjdai
	 * @return
	 */
	List<DefectEntity> load();
	
	/**
	 * 加载分页数据
	 * @author yjdai
	 * @param param Datatables搜索、分页参数 
	 * @return
	 */
	DataTables<DefectEntity> load(DataParam param);
	
	/**
	 * 保存数据
	 * @author yjdai 
	 * @param entity
	 * @return
	 */
	DefectEntity save(DefectEntity entity);
	
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
	List<DefectEntity> save(List<DefectEntity> list);
}
