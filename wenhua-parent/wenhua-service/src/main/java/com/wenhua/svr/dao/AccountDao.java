package com.wenhua.svr.dao;

import com.wenhua.svr.domain.Account;
import com.wenhua.svr.domain.base.BaseAccount;

public interface AccountDao {
	
    int deleteByPrimaryKey(Long id);

    int insert(BaseAccount record);

    int insertSelective(BaseAccount record);

    Account selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(BaseAccount record);

    int updateByPrimaryKey(BaseAccount record);
}