package com.station_thread;

import java.util.List;

/**
 * 负责窗口售票的线程
 * 
 * @author Administrator
 *
 */
public class StationWindow implements Runnable {

	private List<String> line;

	private boolean isGG = false;

	private int ticket = 200;// 每个窗口都有200张票

	private String name;

	public StationWindow(List<String> line, String name) {

		this.line = line;
		this.name = name;

	}

	@Override
	public void run() {

		while (!isGG) {
			try {

				Thread.sleep(100);

			} catch (InterruptedException e) {

				e.printStackTrace();

			}
			saledTickets();

		}

	}

	/**
	 * 因为窗口与排队处理的是同一个list，需锁list。
	 */
	private void saledTickets() {

		synchronized (line) {
			
			if (line.size() > 0) {

				System.out.println("现在车站有" + (--AddPassage.passCount) + "人");

				String pass = line.remove(0);

				System.out.println(pass + "买到了回家的票");

				ticket--;

				if (ticket <= 0) {

					System.out.println("***" + name + "票已经卖光了***");

					isGG = true;

				} else if (ticket % 10 == 0) {

					System.out.println(name + "***还剩" + ticket + "张票***");

				}

			}
		}
	}

}
