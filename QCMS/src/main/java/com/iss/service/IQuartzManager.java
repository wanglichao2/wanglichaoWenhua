/**
 * Copyright (R) 2017 isoftstone
 * @author: yjdai
 * @date: 2016-06-29
 * @version: 1.0
 */
package com.iss.service;


/**
 * 定时任务管理器服务接口
 */
public interface IQuartzManager {
	/**
     * 添加一个定时任务
     * @author yjdai
     * @param jobName 任务名
     * @param jobClass 任务
     * @param cron 时间设置
     */
    void addJob(String jobName, Class<?> jobClass, String cron);
    
	/**
	 * 添加一个定时任务
	 * @author yjdai
	 * @param jobName 任务名
	 * @param jobGroupName 任务组名
	 * @param triggerName 触发器名
	 * @param triggerGroupName 触发器组名
	 * @param jobClass 任务
	 * @param cron 时间设置
	 */
	void addJob(String jobName, String jobGroupName, String triggerName,
			String triggerGroupName, Class<?> jobClass, String cron);
	/**
	 * 修改任务的触发时间
	 * @author yjdai
	 * @param jobName
	 * @param cron 时间设置
	 * @return 
	 */
	boolean modifyJobTime(String jobName, String cron);

	/**
	 * 修改任务的触发时间
	 * @author yjdai
	 * @param jobName 任务名
	 * @param jobGroupName 任务组名
	 * @param triggerName 触发器名
	 * @param triggerGroupName 触发器组名
	 * @param cron 时间设置
	 */
	boolean modifyJobTime(String jobName, String jobGroupName,
			String triggerName, String triggerGroupName, String cron);
	
	/**
	 * 移除任务
	 * @author yjdai
	 * @param jobName
	 */
	void removeJob(String jobName);

	/**
	 * 移除任务
	 * @author yjdai
	 * @param jobName 任务名
	 * @param jobGroupName 任务组名
	 * @param triggerName 触发器名
	 * @param triggerGroupName 触发器组名
	 */
	void removeJob(String jobName, String jobGroupName,
			String triggerName, String triggerGroupName);

	/**
	 * 启动所有定时任务
	 * @author yjdai
	 */
	void startJobs();

	/**
	 * 关闭所有定时任务
	 * @author yjdai
	 */
	void shutdownJobs();
	
}
