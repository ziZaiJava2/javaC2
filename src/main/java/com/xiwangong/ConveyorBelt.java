package com.xiwangong;

import java.util.LinkedList;
import java.util.List;

public class ConveyorBelt {
	static int deliverWanCount = 0;
	public List<Bowl> deliver = new LinkedList<Bowl>();

	public void addBowl(Bowl w) {
		deliver.add(w);
		deliverWanCount++;
	}

	public Bowl removeBowl() {
		deliverWanCount--;
		return deliver.get(0);
	}

}
