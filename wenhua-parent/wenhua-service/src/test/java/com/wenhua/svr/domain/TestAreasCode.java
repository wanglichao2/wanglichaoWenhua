package com.wenhua.svr.domain;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestAreasCode {

	@Test
	public void test1() {
		AreasCode me = new AreasCode();
		me.setAreasid("411000");
		me.setAreasname("某市");
		me.setRankno("2");
		
		assertTrue(me.isMine("411001"));
		assertFalse(me.isMine("410000"));
		assertFalse(me.isMine("510000"));
		assertFalse(me.isMine("412000"));
	}
	
	@Test
	public void test2() {
		AreasCode me = new AreasCode();
		me.setAreasid("410000");
		me.setAreasname("某市");
		me.setRankno("1");
		
		assertTrue(me.isMine("411001"));
		assertTrue(me.isMine("410000"));
		assertFalse(me.isMine("510000"));
		assertTrue(me.isMine("412000"));
	}
	
	@Test
	public void test3() {
		assertTrue(AreasCode.isBelong("411100", "411101"));
		assertTrue(AreasCode.isBelong("411101", "411101"));
		assertTrue(AreasCode.isBelong("411100", "411100"));
		assertFalse(AreasCode.isBelong("411100", "411200"));
		assertFalse(AreasCode.isBelong("411100", "421100"));
	}
	
	@Test
	public void test4() {
		assertFalse(Boolean.valueOf("a"));
		assertFalse(Boolean.valueOf(null));
		assertTrue(Boolean.valueOf("true"));
		assertTrue(Boolean.valueOf("True"));
	}
}
