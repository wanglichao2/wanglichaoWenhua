package com.wenhua.svr.dao;

import java.util.List;
import java.util.Map;

import com.wenhua.svr.domain.NetBar;

public interface NetBarDao {

	int deleteByPrimaryKey(String id);

    int insert(NetBar record);

    int insertSelective(NetBar record);

    NetBar selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(NetBar record);

    int updateByPrimaryKey(NetBar record);
    
    /**
     * 统计区内PC总数
     * @param params "areaCode" : java.lang.String 指定 区 代码
     * @return
     */
    int countAreaPc(Map<String, Object> params);
    
    /**
     * 统计市内PC总数
     * @param params "areaCode" : java.lang.String 指定 市 代码
     * @return
     */
    int countCityPc(Map<String, Object> params);
    
    /**
     * 统计区内网吧总数
     * @param params "areaCode" : java.lang.String 指定 区 代码
     * @return
     */
    int countAreaBar(Map<String, Object> params);
    
    /**
     * 统计市内网吧总数
     * @param params "areaCode" : java.lang.String 指定 市 代码
     * @return
     */
    int countCityBar(Map<String, Object> params);
    
    /**
     * 查询出所有网吧信息
     * @return
     */
    List<NetBar> selectAll();
    
    /**
     * 查出省内所有网吧数量
     * @return
     */
    int countProvinceBar();
    
    /**
     * 查出省内所有网吧PC数量
     * @return
     */
    int countProvincePc();
}