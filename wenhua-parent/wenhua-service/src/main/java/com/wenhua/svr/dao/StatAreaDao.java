package com.wenhua.svr.dao;

import com.wenhua.svr.domain.StatArea;
import com.wenhua.svr.domain.base.BaseStatAreaKey;

public interface StatAreaDao {
    int deleteByPrimaryKey(BaseStatAreaKey key);

    int insert(StatArea record);

    int insertSelective(StatArea record);

    StatArea selectByPrimaryKey(BaseStatAreaKey key);

    int updateByPrimaryKeySelective(StatArea record);

    int updateByPrimaryKey(StatArea record);
}