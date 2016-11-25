package com.zizaitianyuan.javac2.practice;

import org.junit.Assert;

public class Student {
	private static String name;

	public Student(String name) {
		this.name = name;
	}

	public String getName() {

		return this.name;

	}

	public static void main(String[] args) {
		Student leon = new Student("leon");
		System.out.println(name);
	}

}
