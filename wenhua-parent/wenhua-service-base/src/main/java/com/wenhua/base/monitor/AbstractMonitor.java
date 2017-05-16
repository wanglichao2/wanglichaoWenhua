package com.wenhua.base.monitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 抽象的监视器
 * @author zhuzhaohua
 *
 */
public abstract class AbstractMonitor implements Monitor {

	protected Logger logger = LoggerFactory.getLogger(Monitor.class);
	
	/**
	 * 监视器名称
	 */
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
