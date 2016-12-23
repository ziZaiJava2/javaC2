package com.zizaitianyuan.line;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class LineInStation {

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			try {
				List<Person> passages = comingPassagers();
				lineUp(passages);

				passages = comingPassagers();
				lineUp(passages);
				System.out.println(linesDesc());

				Thread.sleep(1000);
				Sale thread1 = new Sale(1);
				Sale thread2 = new Sale(2);
				Sale thread3 = new Sale(3);
				Sale thread4 = new Sale(4);
				thread1.start();
				thread2.start();
				thread3.start();
				thread4.start();

				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		passagersInLines();
		System.out.printf("总共有%d个乘客进入车站，卖出%d张车票，还有%d个乘客没有买到车票。\n", totalPassagers, Sale.saledTikets, passagers);
	}

	/*
	 * 此方法应该随机生成一个长度为1~3的list，表示1~3个乘客来到车站，
	 * 
	 * 并统计总的进站人数到(totalPassagers)
	 * 
	 * 名字随机从names中获取,也可以自己想办法生成
	 * 
	 */
	public static List<Person> comingPassagers() {
		ArrayList<Person> passagesList = new ArrayList<Person>();

		Random random = new Random();
		int a = random.nextInt(3);
		for (int i = 1; i <= a + 1; i++) {
			int m = random.nextInt(names.size());
			Person person = new Person(names.get(m));
			passagesList.add(person);
			totalPassagers++;
		}

		return passagesList;

	}

	private static int totalPassagers = 0;

	private static List<String> names = Arrays.asList("Jim", "Ken", "Leon", "Ada", "Lily", "Lucy", "Will", "Eagle",
			"David", "Zoe", "Wendy", "Acea", "Kin", "Fish", "Paul", "Dean");

	/*
	 * 此方法将乘客排进队伍中，一同到来的乘客为了买票买到一起，他们会排到 同一个队伍。
	 * 
	 * 乘客会挑选最短的队伍进行排队
	 */
	public static void lineUp(List<Person> passages) {
		int[] arr = { Sale.line1.size(), Sale.line2.size(), Sale.line3.size(), Sale.line4.size() };
		Arrays.sort(arr);

		if (arr[0] == Sale.line1.size()) {
			Sale.line1.addAll(passages);
		} else if (arr[0] == Sale.line2.size()) {
			Sale.line2.addAll(passages);
		} else if (arr[0] == Sale.line3.size()) {
			Sale.line3.addAll(passages);
		} else {
			Sale.line4.addAll(passages);
		}
	}

	/*
	 * 这个方法给每个队伍卖出一张车票，并统计总共卖出的票数到（saledTikets）。
	 * 
	 * 拿到票的乘客会离开车站
	 * 
	 * 就是排队伍第一个位置的乘客从队列中删除
	 */

	/*
	 * 统计还有多少个乘客没有买到车票
	 */
	public static int passagers;

	public static void passagersInLines() {
		passagers = totalPassagers - Sale.saledTikets;

	}

	// private static int saledTikets = 0;

	public static String linesDesc() {
		return "line1:" + Sale.line1.toString() + "\n" + "line2:" + Sale.line2.toString() + "\n" + "line3:"
				+ Sale.line3.toString() + "\n" + "line4:" + Sale.line4.toString() + "\n";
	}
}
