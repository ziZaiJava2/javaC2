package com.xiwangong;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WashingDishes {

	public static void main(String[] args) throws InterruptedException {

		IntoConvey intoDeliver = new IntoConvey();
				
		ConveyorBelt wanDeliver = new ConveyorBelt();
		
		Cupboard wanGui = new Cupboard();
		
		XiWanGong1 first = new XiWanGong1(wanGui,wanDeliver);
		
		XiWanGong2 two = new XiWanGong2(wanGui,wanDeliver);
		
		ExecutorService es = Executors.newFixedThreadPool(2);
				
		for (int j = 0; j < 10; j++) {

			intoDeliver.intoDeliver(intoDeliver.createBowl(), wanDeliver);
				
			es.execute(first);
			
			es.execute(two);
			
			Thread.sleep(0);
						
		}
		
		es.shutdown();
		
		System.out.println("总共放入" + IntoConvey.IntoWanCount + "个碗");
		
		System.out.println("洗碗工"+first.getName()+"洗了"+first.getCount()+"个碗,"+"洗碗工"+two.getName()+"洗了"+two.getCount()+"个碗");
		
		System.out.println("传送台还剩下" + ConveyorBelt.deliverWanCount + "个碗");
		
		System.out.println("碗柜里有" + Cupboard.wanGuiAcount + "个碗");
		
		if (IntoConvey.IntoWanCount == ConveyorBelt.deliverWanCount + Cupboard.wanGuiAcount) {
		
			System.out.println("jiarui1和jiarui2很厉害，没有丢一个碗");
		
		} else {
			
			System.out.println(
					"丢了" + (IntoConvey.IntoWanCount - ConveyorBelt.deliverWanCount - Cupboard.wanGuiAcount) + "个碗，扣工资！！！");
		
		}

	}

}
