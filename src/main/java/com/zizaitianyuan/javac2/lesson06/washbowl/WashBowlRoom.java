package com.zizaitianyuan.javac2.lesson06.washbowl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WashBowlRoom {
	static String IRON = "Iron";
	static String CHINA = "China";
	static String PLASTIC = "Plastic";
	private static List<String> bowls = Arrays.asList("Iron", "China", "Iron", "Plastic", "Plastic", "Plastic", "Plastic", "Plastic",
			"China", "China", "Plastic", "Iron", "China", "Iron", "China", "Iron");
	private static Map<String,List> BowlCage = new HashMap<>();
	private static 	List<Bowl> ironBowl = new LinkedList<>();
	private static 	List<Bowl> chinaBowl = new LinkedList<>();
	private static 	List<Bowl> plasticBowl = new LinkedList<>();
	
	static List<Bowl> bowlCarryBand = new LinkedList<>();//传送带上的碗
	static int allBowls = 0;//所有的碗
	static int leaveBowls = 0;//剩下的碗
	static int chinaBowls = 0;//陶瓷碗
	static int ironBowls = 0;//铁腕
	static int plasticBowls = 0;//塑料碗
	static int manWashed = 0;//洗碗工洗了多少个碗
	public static void main(String[] args) {
          for(int i = 0; i < 10; i++){
        	  bowlCarryBand = inComingBowls();
        	  washBowl();
        	  BowlCage.put("china", chinaBowl);
        	  BowlCage.put("iron", ironBowl);
        	  BowlCage.put("plastic", plasticBowl);
          }
       System.out.println("总共进去：" + allBowls + "个 " + "还剩下：" +leaveBowls + "个 " );
       System.out.println("铁碗：" + ironBowls + "个 " + "陶瓷碗：" + chinaBowls + "个 " + "塑料碗：" + plasticBowls + "个");
       System.out.println("柜子里有:"+ chinaBowl.size() + ironBowl.size() + plasticBowl.size() +"碗");
       System.out.println("洗碗工总共洗了：" + manWashed);
	}
	//这个方法用来洗碗
	private static void washBowl() {
	   washMan(bowlCarryBand);
	}
     //洗碗工
	public static void washMan(List<Bowl> bowlCarryBand){
		int bowl = (int)(Math.random()*10);
		for(int i = 0; i < bowl; i++){
			getType(bowlCarryBand.get(0));
			if(bowlCarryBand.get(0).equals(CHINA)){
				chinaBowl.add(bowlCarryBand.get(0));
			
			}else if(bowlCarryBand.get(0).equals(IRON)){
				ironBowl.add(bowlCarryBand.get(0));
				
			}else if(bowlCarryBand.get(0).equals(PLASTIC)){
				plasticBowl.add(bowlCarryBand.get(0));
			}
			bowlCarryBand.remove(0);
			manWashed++;
			
		}
		
		
		
	}
	/*
	 * 这个方法用来随机生成1-10个碗放上传送带
	 */
	public static List<Bowl> inComingBowls(){
		int bowlNum = (int)(Math.random()*bowls.size());
		int timeBowl = (int)(Math.random()*10);
		List<Bowl> comingBowls = new LinkedList<Bowl>();
		for(int i = 0; i < timeBowl; i++){
		        Bowl bowl = new Bowl(bowls.get(bowlNum));
		        comingBowls.add(bowl);
		}
		allBowls = comingBowls.size();
				return comingBowls;
	}
 //这个方法用来判断碗的类型
	public static BowlType getType(Bowl bowl2) {
		BowlType bowl = null;
		if (bowl2.equals(IRON)) {
			bowl = new IronBowl();
			ironBowls++;
		} else if (bowl2.equals(CHINA)){
			bowl = new ChinaBowl();
			chinaBowls++;
		} else if (bowl2.equals(PLASTIC)) {
			bowl = new PlasticBowl();
			plasticBowls++;
		} else {
			System.out.println("你放的不是碗");
			
		}
           return bowl;
	}
}
