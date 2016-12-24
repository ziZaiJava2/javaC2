package com.thread;

import java.util.ArrayList;
import java.util.List;

/* 只需要在自己的队列中买一张票即可
 * 
 * 要做的事情：
 * 输入自己对应的队列
 * 循环：----在队伍头处删除一个人（公锁）
 *      ---睡眠一会儿，假装干活
 * ·需要输入的参数（成员变量）为：对应的line,为了打印更清晰，再输入一个窗口名字
 * 注意：虽然窗口只管自己的line（看上去自己锁就行了），但是有个产人机，也会对List中的line做写的操作，所以要公锁
 * ·不需要返回值
*/
public class SaleTickets implements Runnable {
	private String name;
	private List<Person> line = new ArrayList<Person>();//不可以设置为static因为只属于自己

	public SaleTickets(List<Person> line, String name) {
		this.line = line;
		this.name = name;
	}

	@Override
	public void run() {
		try {
			while (true) {
				synchronized (line) {
					if (line.size() > 0) {
						Thread.sleep(1000);
						line.remove(0);
						System.out.println(name + "窗口执行了\n");
					}
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
