package com.zizaitianyuan.canteen;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Canteen {
	public static int totalTablewares = 0; // 放入的盘子总数

	public static void main(String[] args) {

		Disher.hashMap();
		try {
			Portal.portaled();
			Thread.sleep(5000);
			ExecutorService es = Executors.newFixedThreadPool(2);
			for (int i = 1; i < 3; i++) {
				es.execute(new Disher(i));
			}
			es.shutdown();
			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("传送台放入的盘子总数为：" + totalTablewares);
		System.out.println("第一个员工清洗的盘子数为：" + Disher.cleanTableware1);
		System.out.println("第二个员工清洗的盘子数为：" + Disher.cleanTableware2);
		System.out.println("碗柜里的盘子数：" + Disher.cleanTablewares);
		System.out.println("传送台剩余的盘子数为：" + Portal.getPortalList().size());

		// System.out.println("碗柜里的盘子数："
		// +(Disher.map.get(Portal.MIN_PLATE).size()+
		// Disher.map.get(Portal.MAX_PLATE).size()+
		// Disher.map.get(Portal.MIN_BOWL).size()+
		// Disher.map.get(Portal.MAX_BOWL).size()));
	}
}
