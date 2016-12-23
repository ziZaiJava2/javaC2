package com.zizaitianyuan.canteen;

public class Canteen {
	public static int totalTablewares = 0; // 放入的盘子总数

	public static void main(String[] args) {

		Disher.hashMap();

		for (int i = 0; i < 10; i++) {
			totalTablewares += Portal.portaled();
			Thread r1 = new Disher("第一个洗碗工", "传送台第" + i + "执行");
			Thread r2 = new Disher("第二个洗碗工", "传送台第" + i + "执行");
			r1.start();
			r2.start();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("传送台放入的盘子总数为：" + totalTablewares);
		System.out.println("第一个员工清洗的盘子数为：" + Disher.cleanTableware1);
		System.out.println("第二个员工清洗的盘子数为：" + Disher.cleanTableware2);
		System.out.println("碗柜里的盘子数：" + Disher.cleanTablewares);
		System.out.println("传送台剩余的盘子数为：" + Portal.portalList.size());

		// System.out.println("碗柜里的盘子数："
		// +(Disher.map.get(Portal.MIN_PLATE).size()+
		// Disher.map.get(Portal.MAX_PLATE).size()+
		// Disher.map.get(Portal.MIN_BOWL).size()+
		// Disher.map.get(Portal.MAX_BOWL).size()));
	}
}
