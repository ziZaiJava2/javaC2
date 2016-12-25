package com.zizaitianyuan.canteen;

import java.util.LinkedList;
import java.util.Random;

public class Portal {
	public static final String MIN_PLATE = "MinPlate";
	public static final String MAX_PLATE = "MaxPlate";
	public static final String MIN_BOWL = "MinBowl";
	public static final String MAX_BOWL = "MaxBowl";

	private static LinkedList<Tableware> portalList = new LinkedList<Tableware>();

	public static void portaled() {
		
		String[] type = { MIN_PLATE, MAX_PLATE, MIN_BOWL, MAX_BOWL };
		Random random = new Random();
		for (int n = 0; n < 15; n++) {
			int a = random.nextInt(9);
			for (int i = 0; i < a + 4; i++) {
				Tableware s = null;
				int m = random.nextInt(type.length);
				if (MIN_PLATE.equals(type[m])) {
					s = new MinPlate();
				} else if (MAX_PLATE.equals(type[m])) {
					s = new MaxPlate();
				} else if (MIN_BOWL.equals(type[m])) {
					s = new MinBowl();
				} else {
					s = new MaxBowl();
				}

				getPortalList().add(s);
				Canteen.totalTablewares++;
			}
		}

	}
	
	public static synchronized LinkedList<Tableware> getPortalList(){
		return portalList;
	}
}
