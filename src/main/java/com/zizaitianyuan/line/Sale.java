package com.zizaitianyuan.line;

import java.util.ArrayList;
import java.util.List;

public class Sale extends Thread {
	private static List<Person> line1 = new ArrayList<>();
	private static List<Person> line2 = new ArrayList<>();
	private static List<Person> line3 = new ArrayList<>();
	private static List<Person> line4 = new ArrayList<>();
	private static int saledTikets = 0;

	private int id;

	public Sale(int id) {
		this.id = id;
	}

	public void run() {
		//同步代码块
		synchronized (this) {
			if (getLine(id).size() != 0) {
				System.out.println(Thread.currentThread().getName()+"\t"+id + "号窗口" + getLine(id).get(0) + "已购得的动车票一张\n");
				getLine(id).remove(0);
				incement();
			}
		}
	}
	
	//将卖票数锁住
	public synchronized void incement() {
		saledTikets++;
	}
	
	public static synchronized int getSaledTikets(){
		return saledTikets;
	}
	
	//将获得Line的方法锁住
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
