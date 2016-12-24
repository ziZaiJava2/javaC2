package com.thread;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// 创建四个line，用一个list存放它们
		List<List<Person>> list = new ArrayList<List<Person>>();
		List<Person> lin1 = new ArrayList<Person>();
		List<Person> lin2 = new ArrayList<Person>();
		List<Person> lin3 = new ArrayList<Person>();
//		lin1.add(new Person("yi"));
//		lin2.add(new Person("yi"));
//		lin3.add(new Person("yi"));

		list.add(lin1);
		list.add(lin2);
		list.add(lin3);

		Runnable lineIn = new BirthPerson(list);
		Runnable run1 = new SaleTickets(lin1, "one");
		Runnable run2 = new SaleTickets(lin2, "two");
		Runnable run3 = new SaleTickets(lin3, "three");

		Thread tt = new Thread(lineIn);
		Thread t1 = new Thread(run1);
		Thread t2 = new Thread(run2);
		Thread t3 = new Thread(run3);

		tt.start();
		t1.start();
		t2.start();
		t3.start();

	}

}
