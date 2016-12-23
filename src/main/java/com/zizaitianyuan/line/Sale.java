package com.zizaitianyuan.line;

import java.util.ArrayList;
import java.util.List;

public class Sale extends Thread {
	public static List<Person> line1 = new ArrayList<>();
	public static List<Person> line2 = new ArrayList<>();
	public static List<Person> line3 = new ArrayList<>();
	public static List<Person> line4 = new ArrayList<>();
	public static int saledTikets = 0;

	private int id;

	public Sale(int id) {
		this.id = id;
	}

	public void run() {
		
			try {
				Thread.sleep(2000);
				if ((this.id == 1) && (line1.size() != 0)) {
					System.out.println("第" + id + "号窗口正在进行售票。。。。");
					System.out.println("1号窗口" + line1.get(0) + "已购得的动车票一张\n");
					line1.remove(0);
					incement();
				}
				Thread.sleep(1000);
				
				if ((this.id == 2) && (line2.size() != 0)) {
					System.out.println("第" + id + "号窗口正在进行售票。。。。");
					System.out.println("2号窗口" + line2.get(0) + "已购得的动车票一张\n");
					line2.remove(0);
					incement();
				}
				Thread.sleep(1000);

				if ((this.id == 3) && (line3.size() != 0)) {
					System.out.println("第" + id + "号窗口正在进行售票。。。。");
					System.out.println("3号窗口" + line3.get(0) + "已购得的火车票一张\n");
					line3.remove(0);
					incement();
				}
				Thread.sleep(1000);

				if ((this.id == 4) && (line4.size() != 0)) {
					System.out.println("第" + id + "号窗口正在进行售票。。。。");
					System.out.println("4号窗口" + line4.get(0) + "已购得的汽车票一张\n");
					line4.remove(0);
					incement();
				}
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		

	}

	public synchronized void incement() {
		saledTikets++;
	}

}
