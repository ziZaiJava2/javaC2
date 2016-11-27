package com.zizaitianyuan.javac2.lesson05;

public class Student {
	
	private String name;
	private int credit;
	private String Province;
	static final String LOCAL = "SH";
	
	public  Student(String name){
		this.name = name;
	}
	
	public String getName(){
		return this.name ;
	}
	
	public boolean isFullTime(){
		if(this.credit >= 12){
			return true;
		}else{return false;}
	}
	
	public int getCredits(){
		
		return this.credit;
	}
	
	public void addCredits(int credits){
		this.credit += credits;
	}
	
	public boolean isLocal(){
		if(this.Province != this.LOCAL){
			return false;
		}else{
			return true;
		}
	}
	
	public void setLocation(String Province){
		this.Province = Province;
	}
}
