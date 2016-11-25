package com.zizaitianyuan.javac2.lesson06.practice;

public class Student {
	static final String local = "SH";
	private String province;
	private String stuName;
	private int credits = 0;

	public Student(String name) {
		this.stuName = name;

	}

	/**
	 * 获取名字
	 * 
	 * @return
	 */
	public String getName() {
		return stuName;
	}

	/**
	 * 判断是否是全日制学生
	 * 
	 * @return
	 */
	public boolean isFullTime() {
		if (credits >= 12) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 这个方法用来获取学分
	 * 
	 * @return
	 */
	public int getCredits() {
		return credits;
	}

	/**
	 * 给学生添加学分
	 * 
	 * @param credits
	 */
	public void addCredits(int credits) {
           this.credits = credits;
	}
	/**
	 * 设置学生的籍贯
	 * @param Province
	 */
	public void SetLocation(String province){
		this.province = province;
	}
	/**
	 * 判断是否是本地学生
	 * @return
	 */
	public boolean isLocal(){
		if(province.equals(local)){
			return true;
		}else{
			return false;
		}
	}
}
