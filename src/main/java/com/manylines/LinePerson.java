package com.manylines;

import java.util.ArrayList;
import java.util.List;
//其实是排队买票的过程，类名字先不改
public class LinePerson implements Runnable {
	private String name;
	private static int count = 6;
	private List<Person> personList = new ArrayList<Person>();

	public LinePerson(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	// 保证在票数减少时，大家是同步的
	private synchronized void increase() {
		count--;
	}

	/*
	 * 每个线程，生成一个Person，停顿一会儿，售票员卖票。 其中，票的总数ticket是共享的，要保持同步的资源。
	 * 等这个程序对了之后再试试能不能手动输入总票数
	 */
	@Override
	public void run() {
//		perList是自锁的
		synchronized (personList) {
		}
		for (int i = 0; i < count; i++) {
			try {
				if (personList.size() == 0) {
					personList.add(new Person("ren"));
					Thread.sleep(1000);
					increase();
					personList.remove(0);
					System.out.println(name + "窗口执行了,还剩" + count + "张票");
				}

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		LinePerson m1 = new LinePerson("A");
		LinePerson m2 = new LinePerson("B");
		LinePerson m3 = new LinePerson("C");

		Thread t1 = new Thread(m1);
		Thread t2 = new Thread(m2);
		Thread t3 = new Thread(m3);
		t1.start();
		t2.start();
		t3.start();
	}

}
