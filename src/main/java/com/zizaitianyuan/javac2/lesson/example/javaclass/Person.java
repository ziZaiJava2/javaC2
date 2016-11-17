package com.zizaitianyuan.javac2.lesson.example.javaclass;

public class Person {
	public String name;
	public int age;


	public Person(String name) {
		this.name = name;
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
//		sayHello();
	}

	public Person(int age, String name) {
		this.name = name;
		this.age = age;
	}

	public void sayHello() {
		System.out.printf("Hello, my name is %s, %d years old, I'm a person", name, age);
	}
	
}
