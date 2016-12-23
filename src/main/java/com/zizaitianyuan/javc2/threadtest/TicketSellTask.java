package com.zizaitianyuan.javc2.threadtest;

import java.util.List;

public class TicketSellTask implements Runnable{
	
	private TikectSellSystem ticketSellSystem;
	
	//每买外一队，售票员休息10秒
	
	private List<Passager> line;
	 public TicketSellTask(TikectSellSystem ticketSellSystem, List<Passager> line) {
		 this.ticketSellSystem = ticketSellSystem;
		 this.line = line;
	 }
	
	@Override
	public void run() {
		
		while(true){
			ticketSellSystem.sellTickets(Thread.currentThread().getName(), line.get(0).getName());
			line.remove(0);
		}
	}

}
