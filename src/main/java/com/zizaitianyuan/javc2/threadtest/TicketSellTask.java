package com.zizaitianyuan.javc2.threadtest;

import java.util.List;

public class TicketSellTask implements Runnable{
	
	private TikectSellSystem ticketSellSystem;
	
	private List<Passager> line;
	
	 public TicketSellTask(TikectSellSystem ticketSellSystem, List<Passager> line) {
		 this.ticketSellSystem = ticketSellSystem;
		 this.line = line;
	 }
	
	@Override
	public void run() {
		
		while(true){
			synchronized (line) {
				if(!line.isEmpty()){
					ticketSellSystem.sellTickets(Thread.currentThread().getName(), line.get(0).getName());
					line.remove(0);
				}
			}
		}
	}

	public List<Passager> getLine() {
		return line;
	}

	public void setLine(List<Passager> line) {
		this.line = line;
	}

}
