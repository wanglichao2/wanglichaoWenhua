/**
 * Copyright (R) 2016 Isoftstone.com
 * @author: yjdai
 * @date: 2016年11月17日
 * @version: 1.0
 */
package com.iss.component;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;

/**
 * 自定义SpringBeanJobFactory，用于对Job注入ApplicationContext等。
 */
public class SpringBeanJobFactory extends org.springframework.scheduling.quartz.SpringBeanJobFactory {//implements ApplicationContextAware {
    //方法一通过实现接口ApplicationContextAware
	/*private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }*/
    
    //方法二直接注入 AutowireCapableBeanFactory
    @Autowired
	private AutowireCapableBeanFactory beanFactory;

    /**
     * 这里我们覆盖了super的createJobInstance方法，对其创建出来的类再进行autowire。
     */
    @Override
    protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
        Object jobInstance = super.createJobInstance(bundle);
        //applicationContext.getAutowireCapableBeanFactory().autowireBean(jobInstance);
        beanFactory.autowireBean(jobInstance);
        return jobInstance;
    }
}
