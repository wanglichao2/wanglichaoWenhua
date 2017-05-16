package com.wenhua.svr.dao;

import java.util.Map;

import com.wenhua.svr.domain.StatNetBar;
import com.wenhua.svr.domain.base.BaseStatNetBarKey;

public interface StatNetBarDao {

	int deleteByPrimaryKey(BaseStatNetBarKey key);

    int insert(StatNetBar record);

    int insertSelective(StatNetBar record);

    StatNetBar selectByPrimaryKey(BaseStatNetBarKey key);

    int updateByPrimaryKeySelective(StatNetBar record);

    int updateByPrimaryKey(StatNetBar record);
    
    /**
     * 
     * @param params "areaCode" : java.lang.String ; "statDate" : java.util.Date 区域代码 与 统计日期
     * @return
     */
    int countAreaDaily(Map<String, Object> params);
    
    /**
     * 
     * @param params "areaCode" : java.lang.String ; "statDate" : java.util.Date 区域代码 与 统计日期
     * @return
     */
    int countCityDaily(Map<String, Object> params);
    
    /**
     * 
     * @param params "areaCode" : java.lang.String ; "statDate" : java.util.Date 区域代码 与 统计日期
     * @return
     */
    int countLoginAreaDaily(Map<String, Object> params);
    
    /**
     * 
     * @param params "areaCode" : java.lang.String ; "statDate" : java.util.Date 区域代码 与 统计日期
     * @return
     */
    int countLoginCityDaily(Map<String, Object> params);
    
}