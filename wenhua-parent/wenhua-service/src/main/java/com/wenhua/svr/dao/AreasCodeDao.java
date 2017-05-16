package com.wenhua.svr.dao;

import java.util.List;

import com.wenhua.svr.domain.AreasCode;

public interface AreasCodeDao {
    int insert(AreasCode record);

    int insertSelective(AreasCode record);
    
    List<AreasCode> selectAll();
}