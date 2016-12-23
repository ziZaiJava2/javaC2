package com.xiwangong;


public class XiWanGong1 extends XiWanGong{
	private String name = "jiarui1";
	public XiWanGong1(Cupboard wanGui,ConveyorBelt wanDeliver){
		
		super(wanGui,wanDeliver);
		
	}
	
	public String getName(){
		
		return name;
		
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
	
}
