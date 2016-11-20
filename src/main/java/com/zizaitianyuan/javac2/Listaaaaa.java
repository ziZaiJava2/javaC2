package com.zizaitianyuan.javac2;

import java.util.HashMap;

public class Listaaaaa {
	public static int getSingleNumber(int[] numbers){	
		HashMap<Integer,Integer> result = new HashMap<Integer, Integer>();
		for(int num:numbers){
			if(result.containsKey(num)){
				result.remove(num);
			}else{
				result.put(num, num);
			}
			
		}
		for(int key: result.keySet()){
			return key;
		}
		System.out.println(numbers);
		return 0;
	}}
