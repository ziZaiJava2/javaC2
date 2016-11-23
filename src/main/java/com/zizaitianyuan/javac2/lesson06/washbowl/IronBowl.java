package com.zizaitianyuan.javac2.lesson06.washbowl;

public class IronBowl implements Bowl{
	private String bowl;
	public IronBowl(String bowl){
		this.bowl = bowl;
	}
	public String getBowlType(){
		return bowl;
		
	}
}
