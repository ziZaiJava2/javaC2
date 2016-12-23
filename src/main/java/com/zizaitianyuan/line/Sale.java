package com.zizaitianyuan.line;

import java.util.ArrayList;
import java.util.List;

public class Sale extends Thread{
	public static List<Person> line1 = new ArrayList<>();
	public static List<Person> line2 = new ArrayList<>();
	public static List<Person> line3 = new ArrayList<>();
	public static List<Person> line4 = new ArrayList<>();
	public static int saledTikets = 0;
	
	
	private int id;
	public Sale(int id){
		this.id = id;
	}
	
	public void run() {
		synchronized (this) {
		if((this.id == 1) && (line1.size() != 0)) {
			line1.remove(0);
			incement();
		}

		if((this.id == 2) && (line2.size() != 0)) {
			line2.remove(0);
			incement();
		}

		if((this.id == 3) && (line3.size() != 0)) {
			line3.remove(0);
			incement();
		}

		if((this.id == 4) && (line4.size() != 0)) {
			line4.remove(0);
			incement();
		}
		}
		
	}
	
	public synchronized void incement(){
		saledTikets++;
	}
	
}
