package com.thread;

import java.util.ArrayList;
import java.util.List;

/*生成乘客，加入n个队列中最短的（不太想考虑队伍爆炸的情况，所以就让sleep多等些时间）
 * 
 * 要做的事情：
 * 输入所有的队列(元素)
 * 循环：----找到其中最短的(公锁)
 *      ---加入队尾（公锁）
 *      ---打印出哪个队列加入了人
 *      ---睡眠一会儿，假装在生成人
 * ·需要输入的参数（成员变量）为：含有所有line的list
 * ·不需要返回值
*/
public class BirthPerson implements Runnable {
	private static List<List<Person>> list = new ArrayList<List<Person>>();

	public BirthPerson(List<List<Person>> list) {
		this.list = list;
	}



	@Override
	public void run() {
			try {
				while (true) {
					synchronized (list) {
						
					List<Person> line = new ArrayList<Person>();
					line = list.get(0);
					int number = 0;
					// 循环找到最短的队列
					for (int i = 0; i < list.size(); i++) {
						if (line.size() > list.get(i).size()) {
							line = list.get(i);
							number = i;
						}
					}
					// 循环结束，加入那个人，打印一下，并睡眠
					line.add(new Person("一个人"));
					System.out.println((number+1) + "列加入了乘客");

					Thread.sleep(400);
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

	}

}
