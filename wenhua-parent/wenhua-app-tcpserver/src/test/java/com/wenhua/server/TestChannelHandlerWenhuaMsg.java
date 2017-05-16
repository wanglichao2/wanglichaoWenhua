package com.wenhua.server;

import org.junit.Test;

import com.wenhua.svr.domain.BarAuthInfo;
import com.wenhua.util.ByteUtil;

public class TestChannelHandlerWenhuaMsg {

	/**
	 * 测试计算认证MD5方式
	 */
	@Test
	public void test1() {
		
		byte[] byteArray = BarAuthInfo.getByteArray("1200", "2017-01-02 23:19:20", "hn123wh");
		
		System.out.println(ByteUtil.bytes2hex(byteArray));
	}
}
