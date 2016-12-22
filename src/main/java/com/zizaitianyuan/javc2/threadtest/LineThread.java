package com.zizaitianyuan.javc2.threadtest;

public class LineThread implements Runnable {
	//票的总数
	private int tickets;
	public LineThread(int tickets){
		this.tickets = tickets;
	}
	@Override
	public  synchronized void run() {
		int customeTic = 0;
		while(tickets > customeTic){
			//每个乘客要买的票在1 - 5 之间
			customeTic  = (int) (5 * Math.random() + 1);
			tickets -= customeTic;
			System.out.println(Thread.currentThread().getName() + "卖出去" + customeTic + "张" + "还剩下"  + tickets + "张");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
