package com.zizaitianyuan.threads;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Stations {


	static LinkedList<String> line1 = new LinkedList<>();
	static LinkedList<String> line2 = new LinkedList<>();

	public static void main(String[] args) {

		// 第一步，想想我们要干什么

		/*
		 * 我们说进站，买票有几个东西是并发发生的：
		 *
		 * 各个窗口买票的动作
		 *
		 * 乘客进站的动作
		 *
		 * 我这里就只定义两个窗口了。
		 *
		 */

		ExecutorService es = Executors.newCachedThreadPool();

		// 进站的线程
		es.execute(new Runnable() {

			@Override
			public void run() {

				// 为了让他一直执行下去，我们定义一个死循环
				while(true) {

					// 这里定义每隔多久进入一个人
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						// 可以了解一下这个异常，我们下次课再说明一下
						return;
					}

					// 需要一个锁来在保证队伍的线程安全，我这里用了 一个比较大粒度的锁。

					// 这里也可以用一个比较小粒度的锁，在不是对加入的队列有特别严格的要求的时候可以每个队列一个锁
					// 只在修改和获取的时候锁相应的队伍
					// 大家可以自行考虑怎么做

					// 然后为了防止队伍爆掉，可以加入限制，人数到一定数量就不让排入队伍了。
					synchronized (Stations.class) {
						if (line1.size() <= line2.size()) {
							line1.add("Leon");
							System.out.println("Leon join line1");
						} else {
							line2.add("Ada");
							System.out.println("Ada join line2");
						}
					}
				}
			}
		});

		// 然后是两个售票员
		es.execute(new Runnable() {

			@Override
			public void run() {
				while(true) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						return;
					}

					synchronized (Stations.class) {
						if (line1.size() > 0) {
							String name = line1.removeFirst();
							System.out.println(name  + " got ticket.");
						}
					}
				}
			}
		});

		// 这里你们可以看到，两个售票员动作相同，只是处理的队伍不同，可以定义一个类，队伍作为参数传入
		es.execute(new Runnable() {

			@Override
			public void run() {
				while(true) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						return;
					}

					synchronized (Stations.class) {
						if (line2.size() > 0) {
							String name = line2.removeFirst();
							System.out.println(name  + " got ticket.");
						}
					}
				}
			}
		});
	}
}
