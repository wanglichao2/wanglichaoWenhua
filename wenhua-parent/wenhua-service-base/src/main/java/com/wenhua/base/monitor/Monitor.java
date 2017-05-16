package com.wenhua.base.monitor;

/**
 * 监视器
 * @author zhuzhaohua
 *
 */
public interface Monitor {

	/**
	 * 进行监视
	 */
	public void monitoring();
	
	/**
	 * 获得名字
	 * @return
	 */
	public String getName();
}
