package com.station;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * 这个类用来模拟乘客进站排队买票。
 * 
 * line1到line4表示4个窗口，乘客排队，然后买票离开。
 * 
 * 完成下面的方法：
 * 
 * comingPassagers， 用来生成进站的乘客。
 * lineUp， 用来将生成的乘客排入到售票窗口
 * saleTickets， 用来模拟售出车票
 * 
 * passagersInLines， 用来统计最后还有多少乘客没有买到车票
 * 
 * 
 */
public class LineInStation{

	private static List<Person> line1 = new ArrayList<>();
	private static List<Person> line2 = new ArrayList<>();
	private static List<Person> line3 = new ArrayList<>();
	private static List<Person> line4 = new ArrayList<>();
	protected ExecutorService es1 = Executors.newSingleThreadExecutor();
	protected ExecutorService es2 = Executors.newFixedThreadPool(4);
	
	public static void main(String[] args) throws InterruptedException {		
		
		LineInStation station = new LineInStation();
		
		for (int i = 0; i < 10; i++) {

			saleTickets();

			List<Person> passages = comingPassagers();
			lineUp(passages);

			passages = comingPassagers();
			lineUp(passages);

			System.out.println(linesDesc());
		
		}

		station.es1.shutdown();
		station.es2.shutdown();
		
		int passagers = passagersInLines();

		System.out.printf("总共有%d个乘客进入车站，卖出%d张车票，还有%d个乘客没有买到车票。\n", totalPassagers, saledTikets, passagers);

	}

	/*
	 * 此方法应该随机生成一个长度为1~3的list，表示1~3个乘客来到车站，
	 * 
	 * 并统计总的进站人数到(totalPassagers)
	 * 
	 * 名字随机从names中获取,也可以自己想办法生成
	 * 
	 */
	public static List<Person> comingPassagers() throws InterruptedException {
		/*
		 * 随机建立长度不同的List
		 */
		LineInStation station = new LineInStation();
		
		List<Person> comPass = new ArrayList<Person>();
		
		PassIntoStation intoStation =  new PassIntoStation(comPass);
			
		station.es1.execute(intoStation);	
		
		Thread.sleep(5);
				
		return comPass;
	
	}

	protected static int totalPassagers = 0;

	protected static List<String> names = Arrays.asList("Jim", "Ken", "Leon", "Ada", "Lily", "Lucy", "Will", "Eagle",
			"David", "Zoe", "Wendy", "Acea", "Kin", "Fish", "Paul", "Dean");

	/*
	 * 此方法将乘客排进队伍中，一同到来的乘客为了买票买到一起，他们会排到 同一个队伍。
	 * 
	 * 乘客会挑选最短的队伍进行排队
	 */
	public static void lineUp(List<Person> passages) {
		if (line1.isEmpty()) {
			
			line1.addAll(passages);
		
		} else if (line2.isEmpty()) {
		
			line2.addAll(passages);
		
		} else if (line3.isEmpty()) {
		
			line3.addAll(passages);
		
		} else if (line4.isEmpty()) {
		
			line4.addAll(passages);
		
		} else {
		
			int a[] = new int[] { line1.size(), 1, line2.size(), 2, line3.size(), 3, line4.size(), 4 };
			
			int index = 0;
			
			@SuppressWarnings("unused")
			int min = a[0];
			
			for (int i = 2; i < 7; i += 2) {
			
				if (a[i] < a[0]) {
				
					min = a[i];
					
					index = i + 1;
				
				}
			
			}
			switch (a[index]) {
			
			case 1: {
			
				line1.addAll(passages);
			
			}
			
			case 2: {
			
				line2.addAll(passages);
			
			}
			
			case 3: {
			
				line3.addAll(passages);
			
			}
			
			case 4: {
			
				line4.addAll(passages);
			
			}
			
			}

		}

	}
	

	/*
	 * 这个方法给每个队伍卖出一张车票，并统计总共卖出的票数到（saledTikets）。
	 * 
	 * 拿到票的乘客会离开车站
	 * 
	 * 就是排队伍第一个位置的乘客从队列中删除
	 */
	
	public static void saleTickets() throws InterruptedException {
		
		LineInStation station = new LineInStation();
		
		StationWindow window1 = new StationWindow(line1);
		
		StationWindow window2 = new StationWindow(line2);
		
		StationWindow window3 = new StationWindow(line3);
		
		StationWindow window4 = new StationWindow(line4);
		
		synchronized (LineInStation.class) {
			
			station.es2.execute(window1);
			
			station.es2.execute(window2);
			
			station.es2.execute(window3);
			
			station.es2.execute(window4);
			
		}
						
	}
	
	/*
	 * 统计还有多少个乘客没有买到车票
	 */
	public static int passagersInLines() {
		return totalPassagers - saledTikets;
	}

	protected static int saledTikets = 0;

	public static String linesDesc() {
		return "line1:" + line1.toString() + "\n" + "line2:" + line2.toString() + "\n" + "line3:" + line3.toString()
				+ "\n" + "line4:" + line4.toString() + "\n";
	}

}

class Person {
	private String name;

	public Person(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public String toString() {
		return name;
	}
}











