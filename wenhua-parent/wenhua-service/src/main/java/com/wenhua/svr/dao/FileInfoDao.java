package com.wenhua.svr.dao;

import java.util.List;

import com.wenhua.svr.domain.FileInfo;

public interface FileInfoDao {

	int deleteByPrimaryKey(Long id);

    int insert(FileInfo record);

    int insertSelective(FileInfo record);

    FileInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FileInfo record);

    int updateByPrimaryKeyWithBLOBs(FileInfo record);

    int updateByPrimaryKey(FileInfo record);
    
    /**
     * 查询所有基础信息 （除去 BLOB 字段）
     * @return
     */
    List<FileInfo> selectBaseAll();
}