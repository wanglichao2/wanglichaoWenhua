package com.wenhua.base.monitor;

import javax.sql.DataSource;

/**
 * 数据源监视器
 * @author zhuzhaohua
 *
 */
public class MonitorDataSource extends AbstractMonitor {

	private DataSource dataSource;
	
	@Override
	public void monitoring() {
		logger.info("监视" + getName());
		logger.info(dataSource.toString());
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
