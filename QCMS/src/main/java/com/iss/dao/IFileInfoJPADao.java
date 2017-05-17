package com.iss.dao;

import com.iss.entity.FileInfoEntity;
import com.iss.vo.DataParam;
import com.iss.vo.DataTables;

public interface IFileInfoJPADao {

	/**
	 * 查询缺陷Datatables表格数据
	 * @param param
	 * @return
	 */
	DataTables<FileInfoEntity> query(DataParam param);
	
	FileInfoEntity update(FileInfoEntity entity);
}
