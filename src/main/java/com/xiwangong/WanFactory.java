package com.xiwangong;

public class WanFactory {
	private static final String GangWan = "BUXIUGANG";
	private static final String TieWan = "TIE";
	private static final String CiWan = "TAOCI";

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
			System.out.println(types);
			System.exit(0);
		}
		return w;
	}
}
