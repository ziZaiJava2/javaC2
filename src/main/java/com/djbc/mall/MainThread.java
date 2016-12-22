package com.djbc.mall;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainThread {

	public static void main(String[] args){
		ExecutorService er = Executors.newScheduledThreadPool(2);
		for(int i = 0; i<5;i++){ 
			er.execute(new Task());
		}
		er.shutdown();
	
	}
}
