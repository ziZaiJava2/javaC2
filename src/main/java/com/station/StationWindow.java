package com.station;

import java.util.List;

public class StationWindow implements Runnable{
	
	
	
	private List<Person> line;
	
	public StationWindow(List<Person> line) {

		this.line = line;
		
	}
	@Override
	public void run() {
		
		saledTickets(line);
		
	}
	
	private synchronized void saledTickets(List<Person> line){

			while(!line.isEmpty()){
				
				line.remove(0);
			
				LineInStation.saledTikets ++;
		
		}
		
	}

}
