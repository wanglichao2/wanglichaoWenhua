package com.wenhua.svr.dao.mybatis;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.wenhua.svr.dao.StatAreaDao;
import com.wenhua.svr.domain.StatArea;
import com.wenhua.util.tools.DateUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:app-context.xml")
@Rollback(false)
@Transactional
public class TestStatAreaDao {

	@Resource
	private StatAreaDao statAreaDao;
	
	@Test
	public void test1() {
		System.out.println(statAreaDao);
		
		StatArea sa = StatArea.newOne("123456", DateUtils.getChinaDay(), 1000, 20, 40000, "1");
		statAreaDao.insert(sa);
		
	}
	
}
