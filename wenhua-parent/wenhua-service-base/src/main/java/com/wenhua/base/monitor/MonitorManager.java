package com.wenhua.base.monitor;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * 监视器管理器
 * @author zhuzhaohua
 *
 */
public class MonitorManager extends AbstractMonitor implements Monitor {

	private List<Monitor> monitors;
	
	@Override
	public void monitoring() {
		logger.info("监视器管理器------监控开始!");
		try {
			if(null == monitors) {
				logger.info("监视器管理器------没有监视器存在!");
				return;
			}
			for(Monitor monitor : monitors) {
				try {
					monitor.monitoring();
				} catch (Exception e) {
					logger.info("监视器管理器------监视器[" + monitor.getName() + "]发生异常!", e);
				}
			}
		}
		finally {
			logger.info("监视器管理器------监控结束!");
		}
	}
	
	/**
	 * 增加监视器
	 * @param monitor
	 */
	public void addMonitor(Monitor monitor) {
		if(null == monitor) return;
		if(null == monitors) {
			monitors = Lists.newArrayList();
		}
		monitors.add(monitor);
	}

	public void setMonitors(List<Monitor> monitors) {
		this.monitors = monitors;
	}
	
}