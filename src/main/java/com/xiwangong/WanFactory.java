package com.xiwangong;

public class WanFactory {
	private static final String GangWan = "GangWan";
	private static final String TieWan = "TieWan";
	private static final String CiWan = "CiWan";

	public static Wan getWans(String type) {
		Wan w = null;
		if (type.equals(GangWan)) {
			w = new GangWan();
		} else if (type.equals(TieWan)) {
			w = new TieWan();
		} else if (type.equals(CiWan)) {
			w = new CiWan();
		} else {
			System.out.println("碗类型无法识别");
			System.exit(0);
		}
		return w;
	}
}
