package com.xiwangong;

public class WashingDishes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntoConvey intoDeliver = new IntoConvey();
		XiWanGong jiarui1 = new XiWanGong();
		XiWanGong jiarui2 = new XiWanGong();
		ConveyorBelt wanDeliver = new ConveyorBelt();
		Cupboard wanGui = new Cupboard();
		for (int j = 0; j < 10; j++) {
			intoDeliver.intoDeliver(intoDeliver.createBowl(), wanDeliver);
			jiarui1.getWan(wanGui, wanDeliver);
			jiarui2.getWan(wanGui, wanDeliver);
		}
		System.out.println("总共放入" + IntoConvey.IntoWanCount + "个碗");
		System.out
				.println("洗碗工jiarui1洗了" + jiarui1.getCount() + "个碗" + " " + "洗碗工jiarui2洗了" + jiarui2.getCount() + "个碗");
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
