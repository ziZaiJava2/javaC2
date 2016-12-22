package com.djbc.mall;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Task implements Runnable {
	private static final Logger logger = LoggerFactory.getLogger(Task.class);

	private static int count = 0;
	
	@Override
	public void run() {
		
		synchronized(this) {
				for (int i = 0; i < 10; i++) {
					logger.info("index:{}", i);
					System.out.println(count++);
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
		}
	}
		
}
