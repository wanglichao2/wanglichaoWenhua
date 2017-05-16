package com.wenhua.svr.dao.mybatis;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.wenhua.svr.dao.AreasCodeDao;
import com.wenhua.svr.domain.AreasCode;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:app-context.xml")
@Rollback(false)
@Transactional
public class TestAreasCodeDao {

	@Resource
	private AreasCodeDao areasCodeDao;
	
	@Test
	public void test1() {
		System.out.println(areasCodeDao);
		
		List<AreasCode> list = areasCodeDao.selectAll();
		System.out.println(list.size());
	}
	
}
