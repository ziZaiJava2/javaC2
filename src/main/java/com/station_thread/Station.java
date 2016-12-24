package com.station_thread;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Station {

	private static String passage[] = new String[] { "A", "B", "C", "D" };

	public static void main(String[] args) throws InterruptedException {

		List<String> line1 = new ArrayList<>();
		List<String> line2 = new ArrayList<>();
		List<String> line3 = new ArrayList<>();
		List<String> line4 = new ArrayList<>();

		Random ran = new Random();
		
		/**
		 * 负责创建初始的旅客 为了防止没有创建完CPU资源被抢夺，加了锁
		 */
		synchronized (Station.class) {

			for (int i = 0; i < 5; i++) {

				line1.add(passage[ran.nextInt(4)]);
				line2.add(passage[ran.nextInt(4)]);
				line3.add(passage[ran.nextInt(4)]);
				line4.add(passage[ran.nextInt(4)]);

			}

		}

		List<List<String>> lines = new ArrayList<>();
		
		lines.add(line1);
		lines.add(line2);
		lines.add(line3);
		lines.add(line4);


		AddPassage ad = new AddPassage(lines);

		/**
		 * 建立四个窗口对象，每个对象对应一个线程
		 */
		StationWindow window1 = new StationWindow(line1, "窗口1");
		StationWindow window2 = new StationWindow(line2, "窗口2");
		StationWindow window3 = new StationWindow(line3, "窗口3");
		StationWindow window4 = new StationWindow(line4, "窗口4");

		ExecutorService es = Executors.newCachedThreadPool();

		es.execute(ad);

		es.execute(window1);
		es.execute(window2);
		es.execute(window3);
		es.execute(window4);

		es.shutdown();

	}
}
