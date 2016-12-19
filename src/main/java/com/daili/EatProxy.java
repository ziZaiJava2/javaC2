package com.daili;

public class EatProxy implements Eat{
	private EatSomething eating = new EatSomething();

	public EatProxy(EatSomething eating){
		this.eating = eating;
	}
	public void eat() {
		System.out.println("我饿了");
		
		eating.eat();
		
		System.out.println("好像没吃饱");
		
	}


}
