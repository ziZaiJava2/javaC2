package com.lianxi;
//创建一个学生的类（Student），
//有一个构造函数，接受名字（String）作为参数

public class Student {
	static final String LOCAL = "SH";
	private String name;
	private int score;
	private String province;

	public Student(String name) {
		this.name = name;
	}

//对象有个getName()的方法，可以取得学生的名字。
	public String getName() {
		return this.name;
	}


	public boolean isFullTime() {
		return this.score >= 12;
	}

	public int getCredits() {
		return this.score;
	}

	public void addCredits(int credits) {
		this.score += credits;
	}


	public boolean isLocal() {
		return "SH".equals(this.province);
	}

//	添加新方法setLocation(String Province),用来设置学生的籍贯
	public void setLocation(String province) {
		this.province = province;
	}

	public String getLocal() {
		return this.province;
	}
	
}
