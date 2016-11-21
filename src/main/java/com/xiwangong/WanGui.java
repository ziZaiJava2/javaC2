package com.xiwangong;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WanGui {
	public Map<String, List<Wan>> wanGui = new HashMap<String, List<Wan>>();
	private List<Wan> ww = new ArrayList<Wan>();
	static int wanGuiAcount = 0;

	public void addWanGui(Wan w) {
		ww.add(w);
		wanGui.put(w.getType(), ww);
		wanGuiAcount++;
	}
}
