package com.course.huang;

public class Student {
	
	private String name;
	private int credit;
	private String province;
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
		return LOCAL.equals(this.province);
	}
	
	public void setLocation(String province){
		this.province = province;
	}
}
