package com.station_thread;

import java.util.List;
import java.util.Random;

/**
 * 负责安排人进站的线程
 * 
 * @author Administrator
 *
 */
public class AddPassage implements Runnable {

	private List<List<String>> lines;

	private String[] passage = new String[] { "A", "B", "C", "D" };

	private Random ran = new Random();

	private List<String> target = null;

	private boolean isFull = false;

	public static int passCount = 20;// 在主函数里随机添加了20个起始的旅客，故passCount为20。

	public AddPassage(List<List<String>> lines) {

		this.lines = lines;

	}

	@Override
	public void run() {

		while (!isFull) {

			try {

				add();

			} catch (InterruptedException e) {

				e.printStackTrace();

			}

		}

	}

	/**
	 * 随机添加人进入队伍，每个人进站间隔200ms，当人数为200时结束进站 旅客会选择最短队伍排队
	 * 
	 * @throws InterruptedException
	 */
	private void add() throws InterruptedException {

		int a = ran.nextInt(4);

		synchronized (AddPassage.class) {
			
			target = lines.get(0);

			for (List<String> line : lines) {
				
				if (line.size() < target.size()) {
					
					target = line;
					
				}
				
			}
			
		}
		
		synchronized (target) {

			
			target.add(passage[a]);

			passCount++;

			System.out.println("现在车站有" + passCount + "个人");
		
			if (passCount > 200) {
				
				isFull = true;
				
			}

		}

		Thread.sleep(100);

	}

}
