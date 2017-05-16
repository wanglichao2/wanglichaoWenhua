package com.wenhua.server;

import org.junit.Test;
import static org.junit.Assert.*;


public class TestTcpMethod {

	@Test
	public void test1() {
		assertEquals("Authentication", TcpMethod.Authentication.toString());
	}
	
	@Test
	public void test2() {
		int num = Runtime.getRuntime().availableProcessors() * 2;
		System.out.println(num);
	}
	
}
