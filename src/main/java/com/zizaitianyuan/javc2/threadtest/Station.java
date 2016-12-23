package com.zizaitianyuan.javc2.threadtest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.github.javafaker.Faker;

public class Station {
	public static void main(String[] args) {
		List<Passager> Passager = new ArrayList<Passager>(); 
		Passager.addAll(getPassager());
		TikectSellSystem ticketSellSystem = new TikectSellSystem(10000);
		TicketSellTask tk = new TicketSellTask(ticketSellSystem, Passager);
		ExecutorService ex = Executors.newFixedThreadPool(3);
		for(int i = 0; i < 3; i++){
		ex.execute(tk);
		}
		ex.shutdown();
	}
	
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
