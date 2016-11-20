package com.zizaitianyuan.javac2.lesson06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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
public class LineInStation {

	
	private static List<Person> line1 = new ArrayList<>();
	private static List<Person> line2 = new ArrayList<>();
	private static List<Person> line3 = new ArrayList<>();
	private static List<Person> line4 = new ArrayList<>();
	
	
	public static void main(String[] args) {
		
		
		
		for(int i = 0; i < 10; i++) {
			
			saleTickets();
			
			List<Person> passages = comingPassagers();
			lineUp(passages);
			
			passages = comingPassagers();
			lineUp(passages);
			
			System.out.println(linesDesc());
		}
		
		int passagers = passagersInLines();
		
		System.out.printf("总共有%d个乘客进入车站，卖出%d张车票，还有%d个乘客没有买到车票。\n", 
				totalPassagers, saledTikets, passagers);
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
//		（me）生成一个ArrayList名字为in，num生成1-3的随机数，把in的大小定为num
		ArrayList<String> in = new ArrayList<String>();
		Random rand = new Random();
		int num = rand.nextInt(3);
		in.size() = num;
		
//		（me）总人数统计
		totalPassagers = totalPassagers + in.size();
		
//		（me）一共16个姓名，随机生成1-16的数num2，在16个姓名中随机抽取到in中
		int num2 = rand.nextInt(16)
				for （int i = 1;i<=num;i++）{
					in.add(names[num2]);
	}
		return null;
	}
	
	private static int totalPassagers = 0;
	
	private List<String> names = Arrays.asList(
			"Jim", "Ken", "Leon", "Ada", "Lily", "Lucy", "Will", "Eagle",
			"David", "Zoe", "Wendy", "Acea", "Kin", "Fish", "Paul", "Dean"
			);
	
	
	/*
	 * 此方法将乘客排进队伍中，一同到来的乘客为了买票买到一起，他们会排到
	 * 同一个队伍。
	 * 
	 * 乘客会挑选最短的队伍进行排队
	 */
	public static void lineUp(List<Person> passages) {
//		取最小的数不知道有没有函数min
//		没有的话，只能一个个比
		if (line1.size() <= line2.size()){
			if (line1.size() <= line3.size()){
				if (line1.size() <= line4.size()){
//					当line1最短时，加入乘客
					line1.add(passages);
	}
	}
			
			
	}
		else
		
	}
	
	/*
	 * 这个方法给每个队伍卖出一张车票，并统计总共卖出的票数到（saledTikets）。
	 * 
	 * 拿到票的乘客会离开车站
	 * 
	 * 就是排队伍第一个位置的乘客从队列中删除
	 */
	public static void saleTickets() {
//		（me）能力不足，先不考虑空队
		line1.remove(1);
		line2.remove(1);
		line3.remove(1);
		line4.remove(1);
		
	}
	
	/*
	 * 统计还有多少个乘客没有买到车票
	 */
	public static int passagersInLines() {
//		（me）还在排队的人就是没买到票的人数
		int no = line1.size() + line2.size() + line3.size() + line4.size();
		System.out.println("还有%d个乘客没有买到车票" , no);
		return 0;
	}
	
	private static int saledTikets = 0;
	
	public static String linesDesc() {
		return  "line1:" + line1.toString() + "\n" + 
				"line2:" + line2.toString() + "\n" + 
				"line3:" + line3.toString() + "\n" + 
				"line4:" + line4.toString() + "\n";
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