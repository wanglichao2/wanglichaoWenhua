package com.wenhua.svr.dao.mybatis;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.wenhua.svr.dao.FileInfoDao;
import com.wenhua.svr.domain.FileInfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:app-context.xml")
@Rollback(false)
@Transactional
public class TestFileInfoDao {

	@Resource
	private FileInfoDao fileInfoDao;
	
	@Test
	public void test1() {
		System.out.println(fileInfoDao);
		
		FileInfo file = FileInfo.newOne("hello.txt", 1L);
		fileInfoDao.insert(file);
	}
	
	@Test
	public void test2() throws IOException {
		File file = new File("D:/UTF8.txt");
		FileInputStream fis = new FileInputStream(file);
		byte[] b = new byte[16];
		int read = fis.read(b);
		System.out.println(read);
		
		FileInfo fileInfo = FileInfo.newOne("hello2.txt", 1L);
		fileInfo.setData(b);
		
		fileInfoDao.insert(fileInfo);
		
		fis.close();
	}
	
	@Test
	public void test3() {
		List<FileInfo> list = fileInfoDao.selectBaseAll();
		System.out.println(list.size());
	}
}
