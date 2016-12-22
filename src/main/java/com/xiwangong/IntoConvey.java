package com.xiwangong;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class IntoConvey {
	
	private String[] wanType = {"CERAMICS","STAINLESS STEEL","IRON"};
	
	private List<Bowl> wanwan = new ArrayList<Bowl>();
	
	Random rand = new Random();
	
	public static int IntoWanCount = 0;

	public List<Bowl> createBowl() {
	
		Bowl w;
		
		int a = (rand.nextInt(3) + 1) * 4;
		
		for (int i = 0; i < a; i++) {
		
			int b = rand.nextInt(3);
			
			w = BowlFactory.getBowls(wanType[b]);
			
			wanwan.add(w);
		
		}
		
		return wanwan;
	
	}

	public void intoDeliver(List<Bowl> wanwan, ConveyorBelt wanDeliver) {
	
		IntoWanCount += wanwan.size();
		
		for (Bowl wan : wanwan) {
		
			wanDeliver.addBowl(wan);
		
		}
	
	}
}
