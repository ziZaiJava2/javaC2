package com.manylines;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//其实是排队买票的过程，类名字先不改

public class LinePerson implements Runnable {
	public static final Logger logger = LoggerFactory.getLogger(LinePerson.class);
	private static int count = 15;
	private List<Person> personList = new ArrayList<Person>();

	// 保证在票数减少时，大家是同步的
	private static synchronized void increase() {
		count--;
	}

	/*
	 * 每个线程，生成一个Person，停顿一会儿，售票员卖票。 其中，票的总数ticket是共享的，要保持同步的资源。
	 * 等这个程序对了之后再试试能不能手动输入总票数
	 */
	@Override
	public void run() {
//第一次执行，当4个窗口都没 任务时候，即list为0，会同时进行count-1，打印出来是同一个数字，
//没想到办法解决。
			try {
				while (true) {
					if (personList.size() == 0) {
						personList.add(new Person("ren"));// 由于本窗口，通过本列表有没有人，判断工作与否，所以PersonList操作要自锁
						// }
						increase();
						// synchronized (this) {
						personList.remove(0);
						logger.info("count of ticket  {}", count);
						Thread.sleep(1000);
					}
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}


	public static void main(String[] args) {

		// ExecutorService es = Executors.newCachedThreadPool();
		ExecutorService es = Executors.newFixedThreadPool(4);

		// es.execute(new LinePerson());

		for (int i = 0; i < 4; i++) {
			es.execute(new LinePerson());
		}

		es.shutdown();

	}

}
