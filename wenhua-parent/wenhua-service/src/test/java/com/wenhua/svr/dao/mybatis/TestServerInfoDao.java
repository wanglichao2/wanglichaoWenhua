package com.wenhua.svr.dao.mybatis;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.wenhua.svr.dao.ServerInfoDao;
import com.wenhua.svr.domain.ServerInfo;
import com.wenhua.util.RandomNumberGenerator;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:app-context.xml")
@Rollback(false)
@Transactional
public class TestServerInfoDao {

	@Resource
	private ServerInfoDao serverInfoDao;
	
	@Test
	public void test1() {
		System.out.println(serverInfoDao);
		
		ServerInfo serverInfo = getServerInfo();
		serverInfoDao.insert(serverInfo);
		
	}

	private ServerInfo getServerInfo() {
		return ServerInfo.newOne(RandomNumberGenerator.generateNumber(), RandomNumberGenerator.generateNumber(), "192.168.1.1", "PC-SERVER", 1, "WIN7", "WENHUA_VER", "TCP_SERVER");
	}
	
	@Test
	public void test3() {
		
		ServerInfo serverInfo = getServerInfo();
		serverInfo.setId("27956843");
		serverInfo.setOsVersion("WIN8");
		serverInfo.setWenhuaVer("WENHUA_VER_2");
		serverInfoDao.updateByPrimaryKey(serverInfo);
	}
	
	@Test
	public void test2() {
		ServerInfo serverInfo = getServerInfo();
		serverInfo.setId("AA-BB-CC-DD-EE-FF");
		serverInfo.setIp("hello world11111");
		
		serverInfoDao.updateByPrimaryKey(serverInfo);
	}
}
