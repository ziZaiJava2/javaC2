package com.xiwangong;

import java.util.LinkedList;
import java.util.List;

public class WanDeliver {
	static int deliverWanCount = 0;
	public List<Wan> deliver = new LinkedList<Wan>();

	public void addWan(Wan w) {
		deliver.add(w);
		deliverWanCount++;
	}

	public Wan removeWan() {
		deliverWanCount--;
		return deliver.get(0);
	}

}
