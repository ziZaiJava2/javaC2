package com.threading;

import java.util.ArrayList;
import java.util.List;

//售票窗口只需要管自己这个队列有没有人就行
//一个SaleTicket对应所有的line，所以需要List存放line<Person>
public class SaleTicket implements Runnable {
	private static int ticket = 100; // 先自己定义票的库存（以后再加构造函数）
	private String name; // 定义窗口的名字

	private static List<List<Person>> list = new ArrayList<List<Person>>();
	
	// 获得窗口名字
	public SaleTicket(String name) {
		this.name = name;
	}

	// 减少票数，是需要资源共享，并且同步的
	private static synchronized void increase() {
		ticket--;
	}

	private static synchronized void deletePerson() {
		getMinLine(list).remove(0);
	}
	
//	得到List中非空的队伍
	public static synchronized List<Person> getMinLine(List<List<Person>> list){
		List<Person> line = new ArrayList<Person>();
		for(int i = 0;i < list.size();i++){
			if(!list.get(i).isEmpty()){
				line = list.get(i);
			}else {line = null;}
		}
		return line;
	}
	
	
	@Override
	public void run() {

		try {
			while (true) {
				if (ticket > 0 && getMinLine(list) != null) {
					int now = ticket;
					increase();
					deletePerson();
					System.out.println(name + "窗口执行了，车票还有" + (now - 1));// 现在不知道怎么让两个步骤同时进行（像MySQL的原子操作）
																		// 所以只能用一个参数接收，不能直接用ticket。
					Thread.sleep(1000);
				} else {
					break;
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	

//	用三个窗口试运行
	public static void main(String[] args) {
		List<Person> line1 = new ArrayList<Person>();
		List<Person> line2 = new ArrayList<Person>();
		List<Person> line3 = new ArrayList<Person>();

		
		
		SaleTicket s1 = new SaleTicket("A");
		SaleTicket s2 = new SaleTicket("B");
		SaleTicket s3 = new SaleTicket("C");
		LinePerson li1 = new LinePerson("one",line1);
		LinePerson li2 = new LinePerson("two",line2);
		LinePerson li3 = new LinePerson("three",line3);

		Thread t1 = new Thread(s1);
		Thread t2 = new Thread(s2);
		Thread t3 = new Thread(s3);
		Thread tt1 = new Thread(li1);
		Thread tt2 = new Thread(li2);
		Thread tt3 = new Thread(li3);

		t1.start();
		t2.start();
		t3.start();
		tt1.start();
		tt1.start();
		tt1.start();

	}

}