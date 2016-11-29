package com.zizaitianyuan.javac2.practice;

public class Student {
	private static String name;
	private String isHonors = null;
	private int credits;
	private String province;
	static  String LOCAL = "SH";
	
	public Student(String name) {
		this.name = name;
	}

	public String getName() {

		return this.name;

	}
	public boolean isFullTime() {

		return credits>12 ;
        //添加一个新的方法isFullTime()到Student类，该方法返回一个布尔值，用来判断学生是否是全日制的学生。
	}
	public int getCredits() {

		return credits;
       //添加一个getCredits()方法，获取学生的学分，返回一个int类型
	}
	public void addCredits(int credits) {

		this.credits += credits;
       //添加一个方法addCredits(int credits),用来给学生添加学分,是累加...
	}
	public boolean isLocal() {
	 return LOCAL.equals(province);
		
	}
	public void setLocation(String province) {

		this.province = province;

	}

	public String getIsHonors() {
		return isHonors;
	}

	public void setIsHonors(String isHonors) {
		this.isHonors = isHonors;
	}
	

}
