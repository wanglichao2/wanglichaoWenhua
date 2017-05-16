package com.wenhua.svr.dao.mybatis;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.wenhua.svr.dao.AccountDao;
import com.wenhua.svr.domain.Account;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:app-context.xml")
@Rollback(false)
@Transactional
public class TestAccountDao {

	@Autowired
	private AccountDao accountDao;
	
	@Test
	public void test1() {
		
		Account one = Account.newOne(String.valueOf(System.currentTimeMillis()), "hello");
		accountDao.insert(one);
		
		Long targetId = one.getId();
		
		Account target = accountDao.selectByPrimaryKey(targetId);
		assertEquals(one.getAccountName(), target.getAccountName());
		
	}
}
