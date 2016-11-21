package com.xiwangong;

import java.util.Random;

public class XiWanGong {
	private int count = 0;
	private int Acount = new Random().nextInt(3) + 3;

	public void getWan(Wan w, WanGui wanGui, WanDeliver wanDeliver) {
		for (int i = 0; i < Acount; i++) {
			w = wanDeliver.removeWan();
			washWanAndIntoWanGui(w, wanGui);
		}
	}

	public void washWanAndIntoWanGui(Wan w, WanGui wanGui) {
		System.out.println("洗刷刷");
		wanGui.addWanGui(w);
		++count;
	}

	public int getCount() {
		return count;
	}
}
