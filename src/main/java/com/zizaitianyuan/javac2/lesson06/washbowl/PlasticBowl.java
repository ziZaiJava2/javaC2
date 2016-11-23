package com.zizaitianyuan.javac2.lesson06.washbowl;

public class PlasticBowl implements Bowl {

	private String bowl;
	public PlasticBowl(String bowl){
		this.bowl = bowl;
	}
	public String getBowlType(){
		return bowl;
		
	}
}
