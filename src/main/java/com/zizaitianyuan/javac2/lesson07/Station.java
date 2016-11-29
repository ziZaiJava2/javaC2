package com.zizaitianyuan.javac2.lesson07;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Station {
	
	public static List<Passager> line01 = new ArrayList<>();
	public static List<Passager> line02 = new ArrayList<>();

	public static void main(String[] args) {
		
		for(int i = 0; i < 10; i++) {
			List<Passager> passagers = generatePassagers();
			lineUp(passagers);
			
			saleTickets();
			
			printLines();
		}
	}
	
	

	private static void saleTickets() {
		if (line01.size() > 0) {
			line01.remove(0);
		}
		if (line02.size() > 0) {
			line02.remove(0);
		}
	}



	private static void printLines() {
		System.out.println("line01:" + line01);
		System.out.println("line02:" + line02);
	}



	private static void lineUp(List<Passager> passagers) {
		List<Passager> line = line01;
		if (line.size() > line02.size()) {
			line = line02;
		}
		line.addAll(passagers);
	}

	private static String[][] names = {
			{"Kai", "male"}, 
			{"Leon", "male"},
			{"Ada", "female"}
	};
	
	private static List<Passager> generatePassagers() {
		List<Passager> passagers = new ArrayList<>();
		
		Random r = new Random();
		int number = r.nextInt(3) + 1;
		for(int i = 0; i < number; i++) {
			passagers.add(new Passager("id-0" + i, names[i][0], names[i][1]));
		}
		
		return passagers;
	}
}
