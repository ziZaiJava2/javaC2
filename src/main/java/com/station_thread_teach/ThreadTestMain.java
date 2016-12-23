package com.station_thread_teach;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTestMain {
	public static void main(String[] args) {
		
		List<String> line1 = new ArrayList<>();
		List<String> line2 = new ArrayList<>();
		List<String> line3 = new ArrayList<>();
		List<String> line4 = new ArrayList<>();
		
		List<List<String>> lines = new ArrayList<>();
		
		lines.add(line1);
		lines.add(line2);
		lines.add(line3);
		lines.add(line4);
		
		ExecutorService es = Executors.newCachedThreadPool();
		
		PeopleCreator pc = new ThreadTestMain().new PeopleCreator(lines);
		
		TickerSeller ts1 = new ThreadTestMain().new TickerSeller(line1);
		TickerSeller ts2 = new ThreadTestMain().new TickerSeller(line2);
		TickerSeller ts3 = new ThreadTestMain().new TickerSeller(line3);
		TickerSeller ts4 = new ThreadTestMain().new TickerSeller(line4);
		
		es.execute(pc);
		es.execute(ts1);
		es.execute(ts2);
		es.execute(ts3);
		es.execute(ts4);
		
	}

	class TickerSeller implements Runnable {

		private List<String> line;

		public TickerSeller(List<String> line) {

			this.line = line;

		}

		@Override
		public void run() {
			while (true) {

				if (!line.isEmpty()) {

					synchronized (line) {// 尝试拿line的锁

						line.remove(0);

					}

				}

			}

		}
	}

	class PeopleCreator implements Runnable {

		private List<List<String>> lines;

		public PeopleCreator(List<List<String>> lines) {

			this.lines = lines;

		}

		@Override
		public void run() {

			while (true) {

				List<String> targetLine = null;

				int minLength = 0;

				for (List<String> line : lines) {

					int curLength = line.size();

					if (curLength < minLength) {

						targetLine = line;

						minLength = curLength;

					}

				}
				synchronized (targetLine) {
					
					targetLine.add("jiarui");

				}

			}

		}

	}
}
