package com.xiwangong;

import java.util.Random;

public class XiWanGong {
	private int count = 0;
	private int Acount = new Random().nextInt(3) + 3;
	
	public void getWan(Cupboard wanGui, ConveyorBelt wanDeliver) {
		for (int i = 0; i < Acount; i++) {
			Bowl w = wanDeliver.removeBowl();
			washBowlAndIntoCupboard(w, wanGui);
		}
	}

	public void washBowlAndIntoCupboard(Bowl w, Cupboard wanGui) {
		System.out.println("洗刷刷");
		wanGui.CupboardAddBowl(w);
		count++;
	}

	public int getCount() {
		return count;
	}
}
