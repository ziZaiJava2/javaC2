package com.zizaitianyuan.canteen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Disher extends Thread {

	static HashMap<String, List<Tableware>> map = new HashMap<>();

	public static void hashMap() {
		List<Tableware> minPlateList = new ArrayList<Tableware>();
		List<Tableware> maxPlateList = new ArrayList<Tableware>();
		List<Tableware> minBowlList = new ArrayList<Tableware>();
		List<Tableware> maxBowlList = new ArrayList<Tableware>();

		map.put(Portal.MIN_PLATE, minPlateList);
		map.put(Portal.MAX_PLATE, maxPlateList);
		map.put(Portal.MIN_BOWL, minBowlList);
		map.put(Portal.MAX_BOWL, maxBowlList);
	}

	public static int cleanTablewares = 0;
	@Override
	public void run() {
		try {
			synchronized (Portal.portalList) {
				Random random = new Random();

				for (int i = 0; i < random.nextInt(3) + 3; i++) {
					if (Portal.portalList.size() == 0) {
						break;
					}

					Tableware m = Portal.portalList.remove(0);
					String type = m.getType();
					List<Tableware> tableWares = map.get(type);
					if (tableWares == null) {
						System.out.println("Error:不存在该类型碗柜！");
					}
					tableWares.add(m);
					increment();
				}
				Thread.sleep(10);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
	
	public synchronized void increment(){
		cleanTablewares++;
	}

}
