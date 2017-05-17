package com.iss.test;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.iss.dao.ICodeDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ActiveProfiles("test")
@ContextConfiguration(locations = "classpath:spring-context.xml")
public class UnitTest {
	@Autowired
	private ICodeDao iCodeDao;
	
	@Test
	@Transactional
	@Rollback(true)
	public void test(){
		System.out.println(iCodeDao.findAll());
	}
}
