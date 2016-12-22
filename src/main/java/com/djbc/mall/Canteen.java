package com.djbc.mall;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Canteen {
	public static int totalTablewares = 0;   //放入的盘子总数
	public static int cleanTableware1 = 0;   //第一个员工清洗的盘子数
	public static int cleanTableware2 = 0;   //第二个员工清洗的盘子数
	public static int cleanTablewares = 0;   //碗柜里总共有多少个盘子
	public static int overTableware = 0;     //剩余的盘子总数
	public static void main(String[] args) {
		
		Portal.hashMap();
		Portal r1 =new Portal();
		Portal r2 =new Portal();
		
		
		for(int i = 0;i < 10;i++){
			totalTablewares += Portal.portaled();			
			cleanTableware1 += r1.dishwasher();
			cleanTableware2 += r2.dishwasher();
		}
		cleanTablewares = cleanTableware1 + cleanTableware2;
		overTableware = totalTablewares - cleanTablewares;
		
		System.out.println("放入的盘子总数为：" + totalTablewares);
		System.out.println("第一个员工清洗的盘子数为：" + cleanTableware1);
		System.out.println("第二个员工清洗的盘子数为：" + cleanTableware2);
		System.out.println("传送台剩余的盘子数为：" + Portal.portalList.size());
		System.out.println(cleanTablewares);
		
		
		
		System.out.println("碗柜里的盘子数：" +(Portal.map.get(Portal.MIN_PLATE).size()+ Portal.map.get(Portal.MAX_PLATE).size()+ Portal.map.get(Portal.MIN_BOWL).size()+ Portal.map.get(Portal.MAX_BOWL).size()));
	}
}
interface Tableware{
	public String getType();
	
}

class MinPlate implements Tableware{
	public String getType(){
		return Portal.MIN_PLATE;		
	}
}

class MaxPlate implements Tableware{
	public String getType(){
		return Portal.MAX_PLATE;		
	}
}

class MinBowl implements Tableware{
	public String getType(){
		return Portal.MIN_BOWL;		
	}
}

class MaxBowl implements Tableware{
	public String getType(){
		return Portal.MAX_BOWL;		
	}	
}

class Portal{
	
	
	static HashMap<String,List<Tableware>> map = new HashMap<>();
	public static void hashMap(){
		List<Tableware> minPlateList = new ArrayList<Tableware>();
		List<Tableware> maxPlateList = new ArrayList<Tableware>();
		List<Tableware> minBowlList = new ArrayList<Tableware>();
		List<Tableware> maxBowlList = new ArrayList<Tableware>();
		
		map.put(MIN_PLATE, minPlateList);
		map.put(MAX_PLATE, maxPlateList);
		map.put(MIN_BOWL, minBowlList);		
		map.put(MAX_BOWL, maxBowlList);
	}
	
	public static final String MIN_PLATE = "MinPlate";
	public static final String MAX_PLATE = "MaxPlate";
	public static final String MIN_BOWL = "MinBowl";
	public static final String MAX_BOWL = "MaxBowl";

	static LinkedList<Tableware> portalList = new LinkedList<Tableware>();
	
	
	
	public static int portaled() {
		int totalTableware = 0;
		String[] type = { MIN_PLATE, MAX_PLATE, MIN_BOWL, MAX_BOWL };

		Random random = new Random();
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
			} else{
				s = new MaxBowl();
			}

			portalList.add(s);
			totalTableware++;
		}
		return totalTableware;
	}
		
	
	

	public int dishwasher(){
		int cleanTableware = 0;
		Random random = new Random();
		int b = random.nextInt(3);
		
		for(int i = 0;i < b+3;i++){		
			
			if (portalList.size() == 0) {
				break;
			}
			
			Tableware m = portalList.remove(0);
			String type = m.getType();
			List<Tableware> tableWares = map.get(type);
			if (tableWares == null) {
				System.out.println("Error");
			}
			tableWares.add(m);
			
			cleanTableware++;
		}
		return cleanTableware;
	}
	
}
