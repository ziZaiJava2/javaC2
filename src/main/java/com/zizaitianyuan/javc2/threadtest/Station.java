package com.zizaitianyuan.javc2.threadtest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.github.javafaker.Faker;

public class Station {
	
	public static void main(String[] args) {
		List<Passager> line1 = new ArrayList<>();
		List<Passager> line2 = new ArrayList<>();
		List<Passager> line3 = new ArrayList<>();
		List<Passager> line4 = new ArrayList<>();
		//生成四个队伍
		line1.addAll(getPassager());
		line2.addAll(getPassager());
		line3.addAll(getPassager());
		line4.addAll(getPassager());
		//只有一个售票系统对象
		TikectSellSystem ticketSellSystem = new TikectSellSystem(10000);
		//分别对应四个窗口对应每一个线程，并先给没给线程的每个队伍初始化一个队伍
		TicketSellTask tk1 = new TicketSellTask(ticketSellSystem, line1);
		TicketSellTask tk2 = new TicketSellTask(ticketSellSystem, line2);
		TicketSellTask tk3 = new TicketSellTask(ticketSellSystem, line3);
		TicketSellTask tk4 = new TicketSellTask(ticketSellSystem, line4);
		
		CreatPassager cp = new CreatPassager(tk1, tk2, tk3, tk4);
		
		ExecutorService ex = Executors.newFixedThreadPool(5);
		ex.execute(tk1);
		ex.execute(tk2);
		ex.execute(tk3);
		ex.execute(tk4);
		ex.execute(cp);
		ex.shutdown();
	}
	//开始生成50个乘客
	public static List<Passager> getPassager(){
		List<Passager> passager = new ArrayList<>();
		Faker f = new Faker();
		for(int i = 0; i < 50; i++){
			Passager p = new Passager(f.name().fullName());
			passager.add(p);
		}
		return passager;
	}
}
