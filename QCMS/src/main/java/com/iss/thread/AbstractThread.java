package com.iss.thread;

import java.util.concurrent.CountDownLatch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractThread implements Runnable {
	private CountDownLatch latch;
	private Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public void run() {
		long startTime = System.currentTimeMillis();
		try {
			execute();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (null != latch)
				latch.countDown();
			log.debug("{},threadName:{} spend time:{}", getClass().getName(), Thread.currentThread().getName(), System.currentTimeMillis() - startTime);
		}
	}

	/**
	 * 线程执行方法
	 */
	protected abstract void execute();

	protected void setLatch(final CountDownLatch latch) {
		this.latch = latch;
	}
}
