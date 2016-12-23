package com.zizaitianyuan.javc2.threadtest;

public class Passager {

	private String name;
	
	
	public Passager( String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}


	
	
	@Override
	public String toString() {
		return "{" + this.name + "}"; 
	}
}
