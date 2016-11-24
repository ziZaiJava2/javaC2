package com.zizaitianyuan.javac2.lesson06.washbowl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WashBowlRoom {
	static String IRON = "Iron";
	static String CHINA = "China";
	static String PLASTIC = "Plastic";
	private static String[] Bowls = {"Iron", "China", "Plastic", "Iron", "China", "China", "China", "Iron",
			"China", "Plastic", "Plastic", "Iron", "China", "Iron", "China", "Iron"};
	private static List<Bowl> bowls = new LinkedList<Bowl>();
	private static Map<String,List> BowlCage = new HashMap<>();
	private static List<Bowl> bowlCarryBand = new LinkedList<Bowl>();
	private static 	List<Bowl> ironBowl = new LinkedList<Bowl>();
	private static 	List<Bowl> chinaBowl = new LinkedList<Bowl>();
	private static 	List<Bowl> plasticBowl = new LinkedList<Bowl>();
	
	
	static int allBowls = 0;//所有的碗
	static int leaveBowls = 0;//剩下的碗
	static int chinaBowls = 0;//陶瓷碗
	static int ironBowls = 0;//铁腕
	static int plasticBowls = 0;//塑料碗
	static int manWashed = 0;//洗碗工洗了多少个碗
	public static void main(String[] args) {
		  bowls = putBowls(Bowls);
		  bowlCarryBand = bowlInComing(bowls);
          for(int i = 0; i < 10; i++){
        	  washBowls(bowlCarryBand);
          }
       putBowlInCage();
       System.out.println("总共进去：" + allBowls + "个 " + "还剩下：" + (allBowls -  manWashed) + "个 " );
       System.out.println("铁碗：" + ironBowls + "个 " + "陶瓷碗：" + chinaBowls + "个 " + "塑料碗：" + plasticBowls + "个");
       System.out.println("柜子里有:"+ chinaBowl.size() + ironBowl.size() + plasticBowl.size() +"碗");
       System.out.println("洗碗工总共洗了：" + manWashed);
	}
	/*
	 * 这个方法用来把碗放进进入洗碗的地方
	 */
	
	public static List<Bowl> putBowls(String[] bowls){
		List<Bowl> bowl = new LinkedList<>();
		Bowl wan;
		for(String b : bowls){
			if(CHINA.equals(b)){
			wan = new ChinaBowl(b);
			bowl.add(wan);
			allBowls++;
			chinaBowls++;
			}else if(IRON.equals(b)){
			wan = new IronBowl(b); 
			bowl.add(wan);
			allBowls++;
			ironBowls++;
			}else if(PLASTIC.equals(b)){
			wan = new PlasticBowl(b); 
			bowl.add(wan);
			allBowls++;
			plasticBowls++;
			}else{
				System.out.println("这是金碗放错地方了");
			}
		}
		return bowl;
	}	
	/*
	 * 此方法随机生成1-5个碗进入传送带
	 */
	public static List<Bowl> bowlInComing(List<Bowl> bowls){
		int num = (int)(Math.random()*5+1);
		int size = bowls.size();
		int bowlNum = (int)(Math.random()*size);
		for(int i = 0; i < num; i++){
		      bowlCarryBand.add(bowls.get(bowlNum));
		}
		
		return bowls;
		
	}
	/*
	 * 此方法用来洗碗，每次洗五个碗
	 */
	public static void washBowls(List<Bowl> bowlWashed){
		   for(int i = 0; i < 5; i++){
			   if(!bowlWashed.isEmpty()){
				   countBowl(bowlWashed.get(0));
				   bowlWashed.remove(0);
				   manWashed++; 
			   }
			  
		   }
	}
	/*
	 * 方法用来统计洗过各种碗的个数
	 */
	public static void countBowl(Bowl bowl){
		if(CHINA.equals(bowl.getBowlType())){
			chinaBowl.add(bowl);
			}else if(IRON.equals(bowl.getBowlType())){
			ironBowl.add(bowl);
			}else if(PLASTIC.equals(bowl.getBowlType())){
			plasticBowl.add(bowl);	
			}
	}
	
	public static void putBowlInCage(){
		BowlCage.put("CHINA",chinaBowl);
		BowlCage.put("IRON",ironBowl);
		BowlCage.put("PLASTIC",plasticBowl);
		
	}
}
