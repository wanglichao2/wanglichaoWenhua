package com.wenhua.svr.dao;

import com.wenhua.svr.domain.PcInfo;

public interface PcInfoDao {
    int deleteByPrimaryKey(String id);

    int insert(PcInfo record);

    int insertSelective(PcInfo record);

    PcInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PcInfo record);

    int updateByPrimaryKey(PcInfo record);
}