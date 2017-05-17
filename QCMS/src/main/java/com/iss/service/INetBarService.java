package com.iss.service;

import java.util.List;

import com.iss.entity.NetBarEntity;
import com.iss.vo.DataParam;
import com.iss.vo.DataTables;

public interface INetBarService {
	
	/**
	 * 加载全部数据
	 * @return
	 */
	List<NetBarEntity> load();
	
	/**
	 * 加载分页数据
	 * @param param Datatables搜索、分页参数 
	 * @return
	 */
	DataTables<NetBarEntity> load(DataParam param);
	
	/**
	 * 校验工商登记号是否存在
	 * @param business_reg_no
	 * @return
	 */
	boolean existBusinessRegNo(String business_reg_no);
	
	/**
	 * 保存数据
	 * @param entity
	 * @return
	 */
	NetBarEntity save(NetBarEntity entity);
	
	/**
	 * 编辑数据
	 * @param id
	 * @param field
	 * @param fieldValue
	 * @return
	 */
	boolean update(Long id, String field, String fieldValue);
	
	/**
	 * 批量删除数据
	 * @param ids
	 * @return
	 */
	boolean delBatch(Long[] ids);
	
	/**
	 * 批量导入数据
	 * @param list
	 * @return
	 */
	List<NetBarEntity> save(List<NetBarEntity> list);
}
