package com.zizaitianyuan.luozheng2;

public class Student {
	String name;
	int credits = 0;
	static String Local = "SH";
	double grade;
	int time;// 增加了几次成绩

	public Student(String name) {
		this.name = name;
	}

	public String getName() {// 可以取得学生的名字
		return name;
	}

	public boolean isFullTime() {
		if (credits == 12) {
			return true;
		} else {
			return false;
		}

	}

	public int getCredits() {
		return credits;
	}

	public void addCredits(int credits) {
		this.credits += credits;
	}

	public boolean isLocal() {
		if (Local == "shanghai") {
			return true;
		} else {
			return false;
		}
	}

	public void setLocal(String Province) {
		this.Local = Province;
	}

	public double getGPA() {
		return grade / time;
	}

	public void addGrade(String grade) {
		switch (grade) {
		case "A":
			this.grade = 4;
			break;
		case "B":
			this.grade = 3;
			break;
		case "C":
			this.grade = 2;
			break;
		case "D":
			this.grade = 1;
			break;
		case "E":
			this.grade = 0;
			break;
		default:
			System.out.println("输入错误！");
		}
		/**
		 * 合法的成绩有"A"(4分) "B"(3分) "C"(2分) "D"(1分) "E"(0分)
		 */
		time++;
	}

}
