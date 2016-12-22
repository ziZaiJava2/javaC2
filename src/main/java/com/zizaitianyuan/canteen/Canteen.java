package com.zizaitianyuan.canteen;

public class Canteen {
	public static int totalTablewares = 0;   //放入的盘子总数
//	public static int cleanTableware1 = 0;   //第一个员工清洗的盘子数
//	public static int cleanTableware2 = 0;   //第二个员工清洗的盘子数
//	public static int cleanTablewares = 0;   //碗柜里总共有多少个盘子
	public static int overTableware = 0;     //剩余的盘子总数
	public static void main(String[] args) {
		
		Disher.hashMap();
		
		for(int i = 0;i < 10;i++){
			totalTablewares += Portal.portaled();
			Thread r1 = new Disher();
			Thread r2 = new Disher();
			r1.start();
			r2.start();
			
		}
//		cleanTablewares = cleanTableware1 + cleanTableware2;
//		overTableware = totalTablewares - cleanTablewares;
//		
		System.out.println("放入的盘子总数为：" + totalTablewares);
//		System.out.println("第一个员工清洗的盘子数为：" + cleanTableware1);
//		System.out.println("第二个员工清洗的盘子数为：" + cleanTableware2);
		System.out.println("传送台剩余的盘子数为：" + Portal.portalList.size());
		System.out.println("碗柜里的盘子数：" +Disher.cleanTablewares);
		
		
		
//		System.out.println("碗柜里的盘子数：" +(Disher.map.get(Portal.MIN_PLATE).size()+ Disher.map.get(Portal.MAX_PLATE).size()+ Disher.map.get(Portal.MIN_BOWL).size()+ Disher.map.get(Portal.MAX_BOWL).size()));
	}
}
