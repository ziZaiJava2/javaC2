package com.zizaitianyuan.javc2.threadtest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StationTest {

	public static void main(String[] args) {
		LineThread lt = new LineThread(100000);
		
		ExecutorService es = Executors.newFixedThreadPool(4);
			for(int i = 0; i < 4; i++){
				es.execute(lt);
			}
		
		es.shutdown();
	}

}
