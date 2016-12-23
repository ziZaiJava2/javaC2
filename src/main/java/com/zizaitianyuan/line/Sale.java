package com.zizaitianyuan.line;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Sale extends Thread {
	public static List<Person> line1 = new ArrayList<>();
	public static List<Person> line2 = new ArrayList<>();
	public static List<Person> line3 = new ArrayList<>();
	public static List<Person> line4 = new ArrayList<>();
	public static int saledTikets = 0;

	private Lock lock = new ReentrantLock();
	private int id;

	public Sale(int id) {
		this.id = id;
	}

	public void run() {
		synchronized (this) {
			lock.lock();
			if (getLine(id).size() != 0) {
				System.out.println(id + "号窗口" + getLine(id).get(0) + "已购得的动车票一张\n");
				getLine(id).remove(0);
				incement();
			}
		}
	}

	public synchronized void incement() {
		saledTikets++;
	}

	public static synchronized List<Person> getLine(int id) {
		if (id == 1) {
			return line1;
		} else if (id == 2) {
			return line2;
		} else if (id == 3) {
			return line3;
		} else {
			return line4;
		}
	}
}
