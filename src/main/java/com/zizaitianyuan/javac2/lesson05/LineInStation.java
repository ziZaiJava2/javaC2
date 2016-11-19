package com.zizaitianyuan.javac2.lesson05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LineInStation {

	
	private static List<Person> line1 = new ArrayList<>();
	private static List<Person> line2 = new ArrayList<>();
	private static List<Person> line3 = new ArrayList<>();
	private static List<Person> line4 = new ArrayList<>();
	
	
	public static void main(String[] args) {
		
		
		
		for(int i = 0; i < 10; i++) {
			
			saleTickets();
			
			List<Person> passages = comingPassages();
			lineUp(passages);
			
			passages = comingPassages();
			lineUp(passages);
			
			System.out.println(linesDesc());
		}
	}
	
	
	/*
	 * 此方法应该随机生成一个长度为1~3的list，表示1~3个乘客来到车站
	 * 
	 * 乘客的名字从名字库中取得，使用过的名字从库里删除TODO
	 * 
	 */
	public static List<Person> comingPassages() {
		return null;
	}
	
	
	/*
	 * 此方法将乘客排进队伍中，一同到来的乘客为了买票买到一起，他们会排到
	 * 同一个队伍。
	 * 
	 * 乘客会挑选最短的队伍进行排队
	 */
	public static void lineUp(List<Person> passages) {
		
	}
	
	/*
	 * 这个方法给每个队伍卖出一张车票，就是排队伍第一个位置的乘客从队列中删除
	 */
	public static void saleTickets() {
		
	}
	
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