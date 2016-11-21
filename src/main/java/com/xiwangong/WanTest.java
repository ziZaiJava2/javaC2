package com.xiwangong;

public class WanTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntoDeliver intoDeliver = new IntoDeliver();
		XiWanGong jiarui1 = new XiWanGong();
		XiWanGong jiarui2 = new XiWanGong();
		WanDeliver wanDeliver = new WanDeliver();
		WanGui wanGui = new WanGui();
		for (int j = 0; j < 10; j++) {
			intoDeliver.intoDeliver(intoDeliver.createWan(), wanDeliver);
			jiarui1.getWan(wanGui, wanDeliver);
			jiarui2.getWan(wanGui, wanDeliver);
		}
		System.out.println("总共放入" + IntoDeliver.IntoWanCount + "个碗");
		System.out
				.println("洗碗工jiarui1洗了" + jiarui1.getCount() + "个碗" + " " + "洗碗工jiarui2洗了" + jiarui2.getCount() + "个碗");
		System.out.println("传送台还剩下" + WanDeliver.deliverWanCount + "个碗");
		System.out.println("碗柜里有" + WanGui.wanGuiAcount + "个碗");
		if (IntoDeliver.IntoWanCount == WanDeliver.deliverWanCount + WanGui.wanGuiAcount) {
			System.out.println("jiarui1和jiarui2很厉害，没有丢一个碗");
		} else {
			System.out.println(
					"丢了" + (IntoDeliver.IntoWanCount - WanDeliver.deliverWanCount - WanGui.wanGuiAcount) + "个碗，扣工资！！！");
		}

	}

}
