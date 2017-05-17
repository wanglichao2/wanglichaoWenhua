package com.iss.service;

import java.util.List;

import com.iss.entity.FileBarEntity;
import com.iss.entity.FileInfoEntity;
import com.iss.vo.DataParam;
import com.iss.vo.DataTables;

public interface IFileInfoService {
	/**
	 * 加载全部数据
	 * @return
	 */
	List<FileInfoEntity> load();
	
	/**
	 * 加载分页数据
	 * @param param Datatables搜索、分页参数 
	 * @return
	 */
	DataTables<FileInfoEntity> load(DataParam param);
	
	/**
	 * 保存数据
	 * @param entity
	 * @return
	 */
	FileInfoEntity saveOrUpdate(FileInfoEntity entity);
	
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
	List<FileInfoEntity> save(List<FileInfoEntity> list);
	
	/**
	 * 批量导入数据
	 * @param list
	 * @return
	 */
	List<FileBarEntity> saveFileBars(List<FileBarEntity> list);
}
