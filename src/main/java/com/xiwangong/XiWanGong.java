package com.xiwangong;

import java.util.Random;

public class XiWanGong implements Runnable {

	public int count = 0;

	private int Acount = new Random().nextInt(3) + 3;

	private Cupboard wanGui;

	private ConveyorBelt wanDeliver;

	private IntoConvey intoDeliver = WashingDishes.intoDeliver;

	public XiWanGong() {
	}

	public XiWanGong(Cupboard wanGui, ConveyorBelt wanDeliver) {

		this.wanGui = wanGui;

		this.wanDeliver = wanDeliver;

	}

	@Override
	public void run() {
				
		while (true) {
			
			wash();

		}
	}

	private synchronized void wash() {

		intoDeliver.intoDeliver(intoDeliver.createBowl(), wanDeliver);

		for (int i = 0; i < Acount; i++) {

			Bowl w = wanDeliver.removeBowl();

			// System.out.println("洗刷刷");

			wanGui.CupboardAddBowl(w);

			count++;

		}

	}

	public int getCount() {

		return count;
	}

	public String getName() {

		return null;

	}
}
