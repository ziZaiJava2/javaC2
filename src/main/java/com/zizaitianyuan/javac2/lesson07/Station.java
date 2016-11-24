package com.zizaitianyuan.javac2.lesson07;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;





public class Station {
	
	
	private static List<Passager> line1 = new ArrayList<>();//List<>只能加应用对象里面的实例
	private static List<Passager> line2 = new ArrayList<>();
	

	public static void main(String[] args) {
		
		
		for(int i = 0;i < 10;i++){
			List<Passager> passagers = comPassagers();
			System.out.println(passagers);
			lineUp(passagers);
			
			printLines();
		}

	}
	
	
	


	private static void lineUp(List<Passager> passagers2) {
		List<Passager> min = line1;
		if(line1.size() > line2.size()){
			min = line2;
		}
		min.addAll(passagers2);
		
	}
    
	
	private static void saleTiket(List<Passager> line) {
		if(line1.size() > 0 ){
			line1.remove(0);
		}
		if(!line2.isEmpty()){
			line2.remove(0);
		}
	}




	private static void printLines(){
		System.out.println("line1:" + line1);
		System.out.println("line2:" + line2);
	}
	
	private static String[][] names = {
			{"a","ab"},
			{"b","bc"},
			{"c","ce"}
	};
	private static List<Passager> comPassagers(){
		
		List<Passager> passagers = new ArrayList<>();
		Random random = new Random();
		int number = random.nextInt(3) + 1;
		for (int i = 1; i < number; i++) {
			Passager passager = new Passager("id-01",names[i][0],names[i][1]);
			passagers.add(passager);
	}
        return passagers;
	}
}
