package com.zizaitianyuan.javc2.threadtest;

import java.util.ArrayList;
import java.util.List;

import com.github.javafaker.Faker;

public class CreatPassager implements Runnable {
	
	private TicketSellTask tk1;
	private TicketSellTask tk2;
	private TicketSellTask tk3;
	private TicketSellTask tk4;
	
	private List<Passager> line1;
	private List<Passager> line2;
	private List<Passager> line3;
	private List<Passager> line4;
	@Override
	public void run() {
		while(true){
		addPassagers(line1,line2,line3,line4);
		try {
			//添加一次人，这个线程休眠100s。在获取最新的队伍信息
			Thread.sleep(100000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setLine1();
		setLine2();
		setLine3();
		setLine4();
		}
	}
	public void setLine1() {
		this.line1 = tk1.getLine();
	}
	public void setLine2() {
		this.line2 = tk2.getLine();
	}
	public void setLine3() {
		this.line3 = tk3.getLine();
	}
	public void setLine4() {
		this.line4 = tk4.getLine();
	}
	
	
	public CreatPassager(TicketSellTask tk1, TicketSellTask tk2, TicketSellTask tk3, TicketSellTask tk4){
		this.tk1 = tk1;
		this.tk2 = tk2;
		this.tk3 = tk3;
		this.tk4 = tk4;
	}
	
	//乘客选择人数最少的队伍
	public void addPassagers(List<Passager> line1, List<Passager> line2, List<Passager> line3,
		List<Passager> line4) {
	
		
		int min = getMinLine(line1, line2, line3, line4);
		switch(min){
		 case 1 :
			 tk1.setLine(getPassager1());;
			 break;
		 case 2 :
			 tk2.setLine(getPassager1());
			 break;
		 case 3 :
			 tk3.setLine(getPassager1());
			 break;
		 case 4 :
			 tk4.setLine(getPassager1());
			 break;
			 
		}
	}
	
	//得出人数最少的队伍
	public  int getMinLine(List<Passager> line1, List<Passager> line2, List<Passager> line3, List<Passager> line4){
		int[] arr = {line1.size(), line2.size(), line3.size(),line4.size()};
		int min = arr[0];
		int index = 1;
		for(int i = 1; i < arr.length; i++){
			if(min > arr[i]){
				min = arr[i];
				index = i + 1;
			}
		}
		return index;
	}
	
	//随机刷新十个乘客
	public  List<Passager> getPassager1(){
		List<Passager> passager = new ArrayList<>();
		Faker f = new Faker();
		for(int i = 0; i < (int)(10*Math.random()); i++){
			Passager p = new Passager(f.name().fullName());
			passager.add(p);
		}
		return passager;
	}
}
