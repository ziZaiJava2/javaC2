package com.proxy;

public class RealPerson implements Say{
	@Override
	public void say(String name){
		System.out.println("我是一个人名字叫"+name);
	}
}
