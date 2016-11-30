package com.zizaitianyuan.javac2.lesson06;

public class Animal {

	public String desc() {
		return "Animal";
	}

	public static void main(String[] args) {

		Dog dog = new Dog();

		System.out.println(dog.desc());
	}
}

class Dog extends Animal {

	@Override
	public String desc() {
		return super.desc() + " Dog";
	}

}
