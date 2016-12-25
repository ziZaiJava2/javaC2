package com.zizaitianyuan.canteen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Disher implements Runnable {

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

	private int id;

	public Disher(int id) {
		this.id = id;
	}

	public static int cleanTablewares = 0; // 碗柜里总共有多少个盘子
	public static int cleanTableware1 = 0; // 第一个员工清洗的盘子数
	public static int cleanTableware2 = 0; // 第二个员工清洗的盘子数

	@Override
	public void run() {
		for (int n = 0; n < 10; n++) {
			synchronized (Disher.class) {
				try {
					Random random = new Random();
				for (int i = 0; i < random.nextInt(3) + 3; i++) {
					if (Portal.getPortalList().size() == 0) {
						break;
					}

					Tableware m = Portal.getPortalList().remove(0);
					String type = m.getType();
					List<Tableware> tableWares = map.get(type);
					if (tableWares == null) {
						System.out.println("Error:不存在该类型碗柜！");
					}
					System.out.println(
							"\t" + getDisher(id) + Thread.currentThread().getName() + " synchronized loop " + i);
					tableWares.add(m);
					increment();
					if (getDisher(id).equals("第一个洗碗工")) {
						cleanTableware1++;
					} else {
						cleanTableware2++;
					}
				}
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public synchronized void increment() {
		cleanTablewares++;
	}

	public static String getDisher(int id) {
		if (id == 1) {
			return "第一个洗碗工";
		} else {
			return "第二个洗碗工";
		}
	}

}
