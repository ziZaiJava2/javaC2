package com.zizaitianyuan.javac2.lesson06.practice;

public class Student {
	static final String LOCAL = "SH";
	private String isHonors = null;
	private int gradeCount = 0;
	private String province;
	private String stuName;
	private int credits = 0;
	private double gpaGrade = 0;

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
		return credits >= 12;
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
		this.credits += credits;
	}

	/**
	 * 设置学生的籍贯
	 * 
	 * @param Province
	 */
	public void setLocation(String province) {
		this.province = province;
	}

	/**
	 * 判断是否是本地学生
	 * 
	 * @return
	 */
	public boolean isLocal() {
		return LOCAL.equals(province);
	}

	/**
	 * 得到gpa成绩
	 * 
	 * @return 平均成绩成绩
	 */
	public double getGPA() {
		if ("honor".equals(isHonors)) {
			return (gpaGrade + gradeCount) / gradeCount;
		} else {
			return gpaGrade / gradeCount;
		}
	}

	/**
	 * "A"(4分), "B"(3分), "C"(2分gradeCount), "D"(1分), "F"(0分) 根据传入的等级分别计算成绩
	 * 
	 * @param grade
	 */
	public enum grade {
		A, B, C, D, E;
	}

	public void addGrade(grade g) {

		if ("honor".equals(isHonors)) {
			switch (g) {
			case A:
				gpaGrade += 5;
				gradeCount++;
				break;
			case B:
				gpaGrade += 4;
				gradeCount++;
				break;
			case C:
				gpaGrade += 3;
				gradeCount++;
				break;
			case D:
				gpaGrade += 2;
				gradeCount++;
				break;
			case E:
				gpaGrade += 0;
				break;
			}

		} else {
			switch (g) {
			case A:
				gpaGrade += 4;
				gradeCount++;
				break;
			case B:
				gpaGrade += 3;
				gradeCount++;
				break;
			case C:
				gpaGrade += 2;
				gradeCount++;
				break;
			case D:
				gpaGrade += 1;
				gradeCount++;
				break;
			case E:
				gpaGrade += 0;
				break;
			}

		}
	}
/**
 * 设定学生为荣誉学生
 */
	public void setHonors() {
		isHonors = "honor";
	}
}