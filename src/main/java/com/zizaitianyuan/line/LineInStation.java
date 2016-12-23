package com.zizaitianyuan.line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LineInStation implements Runnable {

	public static void main(String[] args) {

		try {
			ExecutorService executorService1 = Executors.newCachedThreadPool(); // 生成乘客的线程
			executorService1.execute(new LineInStation());
			
			ExecutorService executorService = Executors.newFixedThreadPool(4);
			for (int i = 1; i < 5; i++) {
				executorService.execute(new Sale(i));  // 卖票的线程

			}
			executorService.shutdown();
			executorService1.shutdown();
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println(linesDesc()); // 调用队列输出方法
		passagersInLines(); // 调用计算剩余乘客的方法
		System.out.printf("总共有%d个乘客进入车站，卖出%d张车票，还有%d个乘客没有买到车票。\n", totalPassagers, Sale.getSaledTikets(), passagers);
	}

	private static int totalPassagers = 0;

	public static synchronized void increment() {
		totalPassagers++;
	}

	private static List<String> names = Arrays.asList("Jim", "Ken", "Leon", "Ada", "Lily", "Lucy", "Will", "Eagle",
			"David", "Zoe", "Wendy", "Acea", "Kin", "Fish", "Paul", "Dean");

	public void run() {
		synchronized (this) {
			for (int n = 0; n < 20; n++) {
				ArrayList<Person> passages = new ArrayList<Person>();

				Random random = new Random();
				int a = random.nextInt(3);
				for (int i = 1; i <= a + 1; i++) {
					int m = random.nextInt(names.size());
					Person person = new Person(names.get(m));
					passages.add(person);
					increment(); // 增加总乘客
				}

				int[] arr = { Sale.getLine(1).size(), Sale.getLine(2).size(), Sale.getLine(3).size(),
						Sale.getLine(4).size() };
				Arrays.sort(arr);

				if (arr[0] == Sale.getLine(1).size()) {
					Sale.getLine(1).addAll(passages);
				} else if (arr[0] == Sale.getLine(2).size()) {
					Sale.getLine(2).addAll(passages);
				} else if (arr[0] == Sale.getLine(3).size()) {
					Sale.getLine(3).addAll(passages);
				} else {
					Sale.getLine(4).addAll(passages);
				}
			}
		}
	}

	public static int passagers;// 剩余乘客

	// 计算剩余乘客的方法
	public static void passagersInLines() {
		passagers = totalPassagers - Sale.getSaledTikets();

	}

	public static String linesDesc() {
		return "\n正在等待人员：\n1号窗口:" + Sale.getLine(1).toString() + "\n" + "2号窗口:" + Sale.getLine(2).toString() + "\n"
				+ "3号窗口:" + Sale.getLine(3).toString() + "\n" + "4号窗口:" + Sale.getLine(4).toString() + "\n";
	}
}
