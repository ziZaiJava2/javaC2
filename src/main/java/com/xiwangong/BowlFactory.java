package com.xiwangong;

public class BowlFactory {
	
	private static final String GangWan = new SteelBowl().getType();
	private static final String TieWan = new IronBowl().getType();
	private static final String CiWan = new CeramicsBowl().getType();

	public static Bowl getBowls(String types) {
		
		Bowl w = null;
		
		if (types.equals(GangWan)) {
			
			w = new SteelBowl();
			
		} else if (types.equals(TieWan)) {
			
			w = new IronBowl();
		
		} else if (types.equals(CiWan)) {
			
			w = new CeramicsBowl();
		
		} else {
			
			System.out.println("碗类型无法识别");
			
			System.exit(0);
		
		}
		
		return w;
	}
}
