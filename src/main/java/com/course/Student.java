package com.course;

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

}
