package com.course;

import java.util.ArrayList;
import java.util.List;

/**
 * ѧ����
 * 
 * @author Administrator
 *
 */
public class Student {
	private static final String LOCAL = "SH";
	private String name;
	private int cre;
	private String province = null;
	private List<String> gpa = new ArrayList<String>();
	private double sumGrade;

	// ����Student����
	public Student(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return getName();
	}

	// �ж��Ƿ�Ϊȫ����ѧ��
	public boolean iffullTime() {
		return cre >= 12;
	}

	// ���ѧ��
	public int getCredits() {
		return cre;
	}

	// ����ѧ��
	public int addCredits(int credits) {
		return cre += credits;
	}

	// �ж��Ƿ�Ϊ����ѧ��
	public boolean isLocal() {
		return "SH".equals(LOCAL);
	}

	// ����ѧ������
	public void setLocation(String province) {
		if (!isLocal()) {
			this.province = province;
		}
	}

	public String getProvince() {
		return province;
	}

	public double getGPA() {

		return multiGrade() / gpa.size();
	}

	private double multiGrade() {
		for (String grade : gpa) {
			switch (grade) {
			case "A": {
				sumGrade += 4;
				break;
			}
			case "B": {
				sumGrade += 3;
				break;
			}
			case "C": {
				sumGrade += 2;
				break;
			}
			case "D": {
				sumGrade += 1;
				break;
			}
			default: {

			}
			}
		}
		return sumGrade;
	}

	public void addGrade(String grade) {
		gpa.add(grade.toUpperCase());
	}

}
