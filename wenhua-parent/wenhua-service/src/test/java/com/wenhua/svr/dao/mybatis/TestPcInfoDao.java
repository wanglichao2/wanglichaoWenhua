package com.wenhua.svr.dao.mybatis;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.wenhua.svr.dao.PcInfoDao;
import com.wenhua.svr.domain.PcInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:app-context.xml")
@Rollback(false)
@Transactional
public class TestPcInfoDao {

	@Resource
	private PcInfoDao pcInfoDao;
	
	@Test
	public void test1() {
		System.out.println(pcInfoDao);
		
		PcInfo one = PcInfo.newOne("id1", "ip", "pcName", 1, "osVersion", "wenhuaVer", "barId", "TCP_SERVER");
		pcInfoDao.insert(one);
	}
}
