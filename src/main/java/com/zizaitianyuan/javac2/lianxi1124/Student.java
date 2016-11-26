package com.zizaitianyuan.javac2.lianxi1124;

public class Student {
	/*
	 * 有一个构造函数，接受名字（String）作为参数 对象有个getName()的方法，可以取得学生的名字。
	 */
	private String stuName;

	public Student(String name) {
		this.stuName = name;
	}

	public String getName() {
		return stuName;
	}

}
