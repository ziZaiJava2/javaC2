package com.threading;

import java.util.ArrayList;
import java.util.List;
//一个linePerson对应一个line
public class LinePerson implements Runnable {
	private String name;
	private List<Person> line = new ArrayList<Person>();
	private static int totalPerson = 14;

	// 输入名字看看是第几列队伍
	public LinePerson(String name,List<Person>line) {
		this.name = name;
		this.line = line;
	}

	// 减少总人数（同步）
	private static synchronized void increase() {
		totalPerson--;
	}

	// 这个题目，应该只需要设置队伍是否为空就好了，只要窗口那里有人，不管后面有多少人都是要排着队等的，就不用考虑上限
	@Override
	public void run() {
		try {
			while (true) {
				if (line.size() == 0) {
					int now = totalPerson;
					line.add(new Person("好几个人"));
					increase();
					System.out.println(name + "中插入了一个人，总排队人数还剩：" + (now - 1));
					Thread.sleep(1000);
				} else if (totalPerson < 0) {
					break;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
//这个程序只能配合saleTicket一起使用，不然只循环一次。下面的都是无用功，警示自己
//	public static void main(String[] args) {
//		LinePerson s1 = new LinePerson("one");
//		LinePerson s2 = new LinePerson("two");
//		LinePerson s3 = new LinePerson("three");
//
//		Thread t1 = new Thread(s1);
//		Thread t2 = new Thread(s2);
//		Thread t3 = new Thread(s3);
//
//		t1.start();
//		t2.start();
//		t3.start();
//	}
}
