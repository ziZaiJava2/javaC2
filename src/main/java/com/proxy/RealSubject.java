package com.proxy;

public class RealSubject implements Subject{
	
	@Override
	public void speak() {
		
		System.out.println("RealSubject Execution");
	
	}

}
