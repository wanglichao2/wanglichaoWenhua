package com.wenhua.util.tools;

import java.util.Date;

import org.junit.Test;

public class TestDateUtils {

	@Test
	public void test1() {
		Date today = DateUtils.getChinaDay();
		System.out.println(DateUtils.getString(today, "yyyy-MM-dd HH:mm:ss"));
	}
}
