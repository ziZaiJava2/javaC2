package com.station_thread;

import java.util.List;
import java.util.Random;

public class PassIntoStation implements Runnable{
	
	private List<Person> passage;
	
	public PassIntoStation(List<Person> passage) {

		this.passage = passage;
		
	}
	
	@Override
	public void run() {
	
		intoStation(passage);
		
		try {
		
			Thread.sleep(200);
		
		} catch (InterruptedException e) {

			e.printStackTrace();
		
		}
		
	}
	
	private synchronized void intoStation(List<Person> passage){
		
		Random rand = new Random();
		
		int num=rand.nextInt(3)+1;
		
		for (int i = 1; i <= num ; i++) {
		
			Person per = new Person(LineInStation.names.get(rand.nextInt(LineInStation.names.size())));
			
			passage.add(per);
			
			LineInStation.totalPassagers++;
		
		}
		
	}

}
