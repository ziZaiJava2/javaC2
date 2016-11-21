package com.xiwangong;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IntoDeliver {
	private String[] wanType = {"TAOCI","TIE","BUXIUGANG"};
	private List<Wan> wanwan = new ArrayList<Wan>();
	Random rand = new Random();
	public static int IntoWanCount = 0;

	public List<Wan> createWan() {
		Wan w;
		int a = (rand.nextInt(3) + 1) * 4;
		for (int i = 0; i < a; i++) {
			int b = rand.nextInt(3);
			w = WanFactory.getWans(wanType[b]);
			wanwan.add(w);
		}
		return wanwan;
	}

	public void intoDeliver(List<Wan> wanwan, WanDeliver wanDeliver) {
		IntoWanCount += wanwan.size();
		for (Wan wan : wanwan) {
			wanDeliver.addWan(wan);
		}
	}
}
