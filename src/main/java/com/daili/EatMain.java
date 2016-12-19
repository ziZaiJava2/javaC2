package com.daili;

import java.lang.reflect.Proxy;

public class EatMain {

	public static void main(String[] args){
//		静态方法
		EatSomething e = new EatSomething();
		Eat eatInter = new EatProxy(e);
		eatInter.eat();
		
//		动态方法
		EatSomething e2 = new EatSomething();
		EatProxyMove ePy2 = new EatProxyMove(e2);
		Eat eat = (Eat) Proxy.newProxyInstance(e2.getClass().getClassLoader(), e2.getClass().getInterfaces(), ePy2);
		eat.eat();
	}
	
}
