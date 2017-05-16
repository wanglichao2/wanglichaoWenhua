package com.wenhua.svr.dao.mybatis;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.wenhua.svr.dao.StatNetBarDao;
import com.wenhua.svr.domain.StatNetBar;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:app-context.xml")
@Rollback(false)
@Transactional
public class TestStatNetBarDao {

	@Resource
	private StatNetBarDao statNetBarDao;
	
	@Test
	public void test1() {
		System.out.println(statNetBarDao);
		
		StatNetBar newOne = StatNetBar.newOne("1234567890", new Date(), 10, 2, 1, 2);
		
		statNetBarDao.insert(newOne);
	}
	
	@Test
	public void test2() {
		StatNetBar newOne = StatNetBar.newOne("1234567890", new Date(), 101, 12, 11, 12);
		statNetBarDao.updateByPrimaryKey(newOne);
	}
	
	@Test
	public void test3() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("statDate", new Date());
		params.put("areaCode", "123456");
		int count = statNetBarDao.countAreaDaily(params);
		System.out.println(count);
	}
	
	@Test
	public void test4() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("statDate", new Date());
		params.put("areaCode", "123456");
		int count = statNetBarDao.countLoginAreaDaily(params);
		System.out.println(count);
	}
	
	@Test
	public void test5() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("statDate", new Date());
		params.put("areaCode", "123401");
		int count = statNetBarDao.countLoginCityDaily(params);
		System.out.println(count);
	}
}
