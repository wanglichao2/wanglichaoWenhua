package com.wenhua.svr.dao;

import com.wenhua.svr.domain.ServerInfo;

public interface ServerInfoDao {
    int deleteByPrimaryKey(String id);

    int insert(ServerInfo record);

    int insertSelective(ServerInfo record);

    ServerInfo selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ServerInfo record);

    int updateByPrimaryKey(ServerInfo record);
}