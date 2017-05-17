/**
 * Copyright (R) 2016 Isoftstone.com
 * @author: yjdai
 * @date: 2016年11月17日
 * @version: 1.0
 */
package com.iss.service.impl;

import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import com.iss.service.IQuartzManager;

/** 
 * 定时任务管理器
 */
//@Service
public class QuartzManagerImpl implements IQuartzManager{
	public String JOB_GROUP_NAME = "WARNING_JOBGROUP_NAME";  
    public String TRIGGER_GROUP_NAME = "WARNING_TRIGGERGROUP_NAME";
    //private StdSchedulerFactory stdSchedulerFactory = new StdSchedulerFactory();
    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;
    
    @Override
    public void addJob(String jobName, Class<?> jobClass, String cron) {
    	addJob(jobName, JOB_GROUP_NAME, jobName, TRIGGER_GROUP_NAME, jobClass, cron);
    }
    
    @Override
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void addJob(String jobName, String jobGroupName, String triggerName,
			String triggerGroupName, Class jobClass, String cron) {
		try {
			Scheduler scheduler = schedulerFactoryBean.getScheduler();
			// 任务名，任务组，任务执行类
			JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobName, jobGroupName).build();
			// 触发器
			TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder .newTrigger();
			// 触发器名,触发器组
			triggerBuilder.withIdentity(triggerName, triggerGroupName);
			triggerBuilder.startNow();
			// 触发器时间设定
			triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cron));
			// 创建Trigger对象
			CronTrigger trigger = (CronTrigger) triggerBuilder.build();
			// 调度容器设置JobDetail和Trigger
			scheduler.scheduleJob(jobDetail, trigger);
			// 启动
			if (!scheduler.isShutdown()) {
				scheduler.start();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
    
    @Override
	public boolean modifyJobTime(String jobName, String cron) {
		return modifyJobTime(jobName, JOB_GROUP_NAME, jobName, TRIGGER_GROUP_NAME, cron);
	}

    @Override
	public boolean modifyJobTime(String jobName, String jobGroupName,
			String triggerName, String triggerGroupName, String cron) {
		try {
			Scheduler scheduler = schedulerFactoryBean.getScheduler();
			TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroupName);
			CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
			if (trigger == null) {
				return false;
			}
			String oldTime = trigger.getCronExpression();
			if (!oldTime.equalsIgnoreCase(cron)) {
				/** 方式一 ：调用 rescheduleJob 开始 */
				// 触发器
				TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder .newTrigger();
				// 触发器名,触发器组
				triggerBuilder.withIdentity(triggerName, triggerGroupName);
				triggerBuilder.startNow();
				// 触发器时间设定
				triggerBuilder.withSchedule(CronScheduleBuilder .cronSchedule(cron));
				// 创建Trigger对象
				trigger = (CronTrigger) triggerBuilder.build();
				// 方式一 ：修改一个任务的触发时间
				scheduler.rescheduleJob(triggerKey, trigger);
				/** 方式一 ：调用 rescheduleJob 结束 */

				/** 方式二：先删除，然后在创建一个新的Job */
				// JobDetail jobDetail =
				// scheduler.getJobDetail(JobKey.jobKey(jobName, jobGroupName));
				// Class<? extends Job> jobClass = jobDetail.getJobClass();
				// removeJob(jobName, jobGroupName, triggerName,
				// triggerGroupName);
				// addJob(jobName, jobGroupName, triggerName, triggerGroupName,
				// jobClass, cron);
				/** 方式二 ：先删除，然后在创建一个新的Job */
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return true;
	}
	
    @Override
	public void removeJob(String jobName) {
		removeJob(jobName, JOB_GROUP_NAME, jobName, TRIGGER_GROUP_NAME);
	}

    @Override
	public void removeJob(String jobName, String jobGroupName,
			String triggerName, String triggerGroupName) {
		try {
			Scheduler scheduler = schedulerFactoryBean.getScheduler();
			TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroupName);
			scheduler.pauseTrigger(triggerKey);// 停止触发器
			scheduler.unscheduleJob(triggerKey);// 移除触发器
			scheduler.deleteJob(JobKey.jobKey(jobName, jobGroupName));// 删除任务
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

    @Override
	public void startJobs() {
		try {
			Scheduler scheduler = schedulerFactoryBean.getScheduler();
			scheduler.start();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

    @Override
	public void shutdownJobs() {
		try {
			Scheduler scheduler = schedulerFactoryBean.getScheduler();
			if (!scheduler.isShutdown()) {
				scheduler.shutdown();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
    
    public static void main(String[] args) throws InterruptedException {
    	QuartzManagerImpl quartz = new QuartzManagerImpl();
		String jobName = "testJob";
		System.out.println("【系统启动】开始(每1秒输出一次)...");  
		quartz.addJob(jobName, quartz.getClass(), "*/1 * * * * ?");
		Thread.sleep(5000);  
		System.out.println("【修改时间】开始(每2秒输出一次)...");  
		quartz.modifyJobTime(jobName, "10/2 * * * * ?");  
		Thread.sleep(6000);  
		System.out.println("【移除定时】开始...");  
		quartz.removeJob(jobName);  
		System.out.println("【移除定时】成功");  
	}
}
