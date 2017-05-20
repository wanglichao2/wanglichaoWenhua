package com.wenhua.svr.dao.mybatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.wenhua.svr.dao.NetBarDao;
import com.wenhua.svr.domain.NetBar;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:app-context.xml")
@Rollback(false)
@Transactional
public class TestNetBarDao {

	@Resource
	private NetBarDao netBarDao;
	
	@Test
	public void test0() {
		NetBar bar = NetBar.newOne("4101020017", "1234567123", "me");
		bar.setComputerNum(10);
		netBarDao.insert(bar);
		
	}
	
	@Test
	public void test1() {
		System.out.println(netBarDao);
		NetBar target = netBarDao.selectByPrimaryKey("4101020001");
		System.out.println(target.getDistrictCode());
		target.setServerVersion("V1.0");
		target.setClientVersion("V2.0");
		
		netBarDao.updateByPrimaryKey(target);
	}
	
	@Test
	public void test2() {
		NetBar target = netBarDao.selectByPrimaryKey("4101020001");
		System.out.println(target.getContactName());
	}
	
	@Test
	public void test3() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("areaCode", "411001");
		int count = netBarDao.countAreaBar(params);
		System.out.println(count);
	}

	@Test
	public void test4() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("areaCode", "411000");
		int count = netBarDao.countCityBar(params);
		System.out.println(count);
	}
	
	@Test
	public void test5() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("areaCode", "411001");
		int count = netBarDao.countAreaPc(params);
		System.out.println(count);
	}
	
	@Test
	public void test6() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("areaCode", "411000");
		int count = netBarDao.countCityPc(params);
		System.out.println(count);
	}
	
	@Test
	public void test7() {
		List<NetBar> list = netBarDao.selectAll();
		System.out.println(list.size());
	}
	
	@Test
	public void test8() {
		int num = netBarDao.countProvinceBar();
		System.out.println(num);
	}
	
	@Test
	public void test9() {
		int num = netBarDao.countProvincePc();
		System.out.println(num);
	}
}
