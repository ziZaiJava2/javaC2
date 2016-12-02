package com.zizaitianyuan.javac2.lesson07;

class Student {
	private String name;
	private int credits;
	private String province;
	private static final String LOCAL = "SH";

	public Student(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return this.name;
	}

	public boolean isFullTime() { // 判断全日制学生
		return credits >= 12;
	}

	public int getCredits() { // 返回学生的学分
		return credits;
	}

	public void addCredits(int credits) { // 添加学分方法
		this.credits += credits;
	}

	public boolean isLocal() { // 判断学生籍贯
		return LOCAL.equals(this.province);
	}

	public void setLocaltion(String province) { // 学生籍贯的输入
		this.province = province;
	}

	public double getGAP() { // 返回学生平均成绩
		return this.getCredits();
	}

	public void addGrade(String grade) { // 普通学生添加学分
		switch (grade) {
		case "A":
			this.addCredits(4);
			break;

		case "B":
			this.addCredits(3);
			break;

		case "C":
			this.addCredits(2);
			break;

		case "D":
			this.addCredits(1);
			break;

		case "F":
			this.addCredits(0);
			break;
		}

	}

	public int setHonors(String grade) { // 荣誉学生添加分数
		this.addGrade(grade);
		return this.getCredits() + 1;
	}
}


