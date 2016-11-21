package com.zizaitianyuan.javac2.lesson06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class WashBowls {
	private static int allBowls = 0;//总共进去的碗
    private static int whoBowls1 = 0;
    private static int whoBowls2 = 0;//每个人洗了多少碗
    private static int otherBowls = 0;//还剩多少碗
    private static int squreBowls = 0;//方形碗
    private static int circleBowls = 0;//圆形碗
    static String type1 = "Square";
    static String type2 = "Circle";
    static List<Bowl> CarryBand = new LinkedList<Bowl>(); 
    static Map<String,Bowl> bowlCage = new HashMap<String,Bowl>();
    private static List<String> bowls = Arrays.asList("Square", "Square", "Square", "Circle", "Square", "Square", "Circle", "Circle",
			"Circle", "Square", "Square", "Circle", "Square", "Square", "Circle", "Circle");
    
          public static void main(String[] args) {
			for(int i = 0; i < 10; i++){
				
				List<Bowl> bowls = inComingBowls();
				
			}
		}
          
          private static List<Bowl> inComingBowls() {
			// TODO Auto-generated method stub
			return null;
		}

		public static void washBowls(){
        	  
          }
          
          public static void manWashBowl1(){
        	  
          }
          public static void manWashBolw2(){
        	  
          }
          
}
class Bowl{
	private String type;
	
	public Bowl(String type){
		this.type = type;
	}
	
	public String getBowl(){
		return type;
	}
}