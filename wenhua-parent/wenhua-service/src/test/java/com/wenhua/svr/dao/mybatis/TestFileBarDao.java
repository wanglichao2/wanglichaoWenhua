package com.wenhua.svr.dao.mybatis;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.wenhua.svr.dao.FileBarDao;
import com.wenhua.svr.domain.FileBar;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:app-context.xml")
@Rollback(false)
@Transactional
public class TestFileBarDao {

	@Resource
	private FileBarDao fileBarDao;
	
	@Test
	public void test1() {
		System.out.println(fileBarDao);
		List<FileBar> list = fileBarDao.selectAllByBarId("2");
		System.out.println(list.size());
	}
}
