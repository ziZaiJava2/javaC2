package com.xiwangong;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WashingDishes {

	public static void main(String[] args) throws InterruptedException {

		IntoConvey intoDeliver = new IntoConvey();
				
		ConveyorBelt wanDeliver = new ConveyorBelt();
		
		Cupboard wanGui = new Cupboard();
		
		XiWanGong jiarui = new XiWanGong(wanGui,wanDeliver);
		
		XiWanGong jiarui2 = new XiWanGong(wanGui,wanDeliver);
		
		ExecutorService es = Executors.newFixedThreadPool(2);
				
		for (int j = 0; j < 10; j++) {

			intoDeliver.intoDeliver(intoDeliver.createBowl(), wanDeliver);
				
			es.execute(jiarui);
			
			es.execute(jiarui2);
			
			Thread.sleep(10);
						
		}
		
		es.shutdown();
		
		System.out.println("总共放入" + IntoConvey.IntoWanCount + "个碗");
		
		System.out.println("洗碗工jiarui洗了"+jiarui.getCount()+"个碗,"+"洗碗工jiarui2洗了"+jiarui2.getCount()+"个碗");
		
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
