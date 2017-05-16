package com.wenhua.svr.dao;

import java.util.List;

import com.wenhua.svr.domain.FileBar;

public interface FileBarDao {

	int deleteByPrimaryKey(Long id);

    int insert(FileBar record);

    int insertSelective(FileBar record);

    FileBar selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FileBar record);

    int updateByPrimaryKey(FileBar record);
    
    List<FileBar> selectAllByBarId(String barId);
    
    List<FileBar> selectAll();
}