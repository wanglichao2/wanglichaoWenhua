package com.wenhua.svr.dao;

import java.util.List;
import java.util.Map;

import com.wenhua.svr.domain.UserArea;

public interface UserAreaDao {
	int deleteByPrimaryKey(String id);

    int insert(UserArea record);

    int insertSelective(UserArea record);

    UserArea selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(UserArea record);

    int updateByPrimaryKey(UserArea record);
    
    List<String> getCityCodesByUserId(Long userId); 
    List<String> getDistrictCodesByUserId(Map<String, Object> query);

}
