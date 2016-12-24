package com.zizaitianyuan.javc2.threadtest;

public class TikectSellSystem {
	//票的总数
	private int  allTickets;
	//买一次间隔1s；
	private int time = 1000;
	public TikectSellSystem(int allTickets){
		this.allTickets = allTickets;
	}
	
	
	public void sellTickets(String lineName, String customeName, int num){
		
		synchronized (TikectSellSystem.class) {
			
			//每个乘客可能买1 - 5 张票
			int customeT = (int)(5*Math.random() + 1);
			//只有所有车票在多余乘客要买的车票的数字的时候才会买票
			if(allTickets > customeT){
				allTickets -= customeT;
				System.out.println(customeName +   " 买了" + customeT + "张" + "还剩下" + allTickets);
			}
			try {
				Thread.sleep(time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
