package com.xiwangong;

public class WanFactory {
	
	private static final String GangWan = new GangWan().getType();
	private static final String TieWan = new TieWan().getType();
	private static final String CiWan = new CiWan().getType();

	public static Wan getWans(String types) {
		Wan w = null;
		if (types.equals(GangWan)) {
			w = new GangWan();
		} else if (types.equals(TieWan)) {
			w = new TieWan();
		} else if (types.equals(CiWan)) {
			w = new CiWan();
		} else {
			System.out.println("碗类型无法识别");
			System.exit(0);
		}
		return w;
	}
}
