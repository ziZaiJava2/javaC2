package com.zizaitianyuan.javac2.lianxi1124;

public class Student {
	static final String LOCAL = "SH";
	private String isHonors = null;
	private int gradeCount = 0;
	private String province;
	private String stuName;
	private int credits = 0;
	private double gpaGrade = 0;
	/*
	 * 有一个构造函数，接受名字（String）作为参数 对象有个getName()的方法，可以取得学生的名字。
	 */
	

	public Student(String name) {
		this.stuName = name;
	}

	public String getName() {
		return stuName;
	}
	/*
	 * 判断是否是全日制学生
	 */
	public boolean isFullTime() {
		return credits >= 12;
	}
	/*
	 * 这个方法用来获取学分
	 */
	public int getCredits() {
		return credits;
	}
	/*
	 * 给学生添加学分
	 */
	public void addCredits(int credits) {
		this.credits += credits;
	}
	/*
	 * 设置学生的籍贯
	
	 */
	public void setLocation(String province) {
		this.province = province;
	}
	/*
	 * 判断是否是本地学生
	 */
	public boolean isLocal() {
		return LOCAL.equals(province);
	}

}
