package com.xiwangong;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Cupboard {

	public Map<String, List<Bowl>> cupboard = new HashMap<String, List<Bowl>>();

	private List<Bowl> ww = new ArrayList<Bowl>();

	static int wanGuiAcount = 0;

	public void CupboardAddBowl(Bowl w) {

		ww.add(w);

		cupboard.put(w.getType(), ww);

		wanGuiAcount++;

	}
}
