package com.xiwangong;

import java.util.Random;

public class XiWanGong implements Runnable{
	
	public int count = 0;
	
	private int Acount = new Random().nextInt(3) + 3;
	
	private Cupboard wanGui;
	
	private ConveyorBelt wanDeliver;
	
	public XiWanGong(Cupboard wanGui,ConveyorBelt wanDeliver){
		
		this.wanGui = wanGui;
		
		this.wanDeliver = wanDeliver;
		
	}
	
	@Override
	public void run() {
		
		wash();
		
	}
	
	private synchronized void wash(){
		
		for (int i = 0; i < Acount; i++) {
			
			Bowl w = wanDeliver.removeBowl();
			
			System.out.println("洗刷刷");
			
			wanGui.CupboardAddBowl(w);
			
			count++;
			
		}
		
	}
	
//	public synchronized void getWan(Cupboard wanGui, ConveyorBelt wanDeliver) {
//		
//			Bowl w = wanDeliver.removeBowl();
//			
//			washBowlAndIntoCupboard(w, wanGui);
//	
//	}
//
//	public synchronized void washBowlAndIntoCupboard(Bowl w, Cupboard wanGui) {
//	
//		System.out.println("洗刷刷");
//		
//		wanGui.CupboardAddBowl(w);
//		
//		count++;
//	
//	}

	public int getCount() {
	
		return count;
	}
	
}
