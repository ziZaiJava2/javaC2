package com.zizaitianyuan.javac2.lesson03.shapes;

public class Circle implements Shape {
	
	private int r;

	public Circle(int len) {
		this.r = len;
	}

	@Override
	public double perimeter() {
		//					这个Math.PI就是对一个类变量的引用，可以ctrl，点击PI跳过去看看定义
		return 2 * this.r * Math.PI;
	}

	
	/*
	 * 
	 * 看看这里，我们的实例方法的定义，就是比类方法少了一个static，其他的都一样
	 * 
	 * public,不解释了
	 * 
	 * 返回值，String,表示要返回一个String对象在堆中的地址值，你就理解成要饭会一个String对象。自己体会
	 * 
	 * 方法名description
	 * 
	 * 参数列表，这里是空的。
	 * 
	 * 对实例方法的调用
	 * 
	 * 		类型变量.方法名(参数列表)；
	 * 
	 * 这里区别就是通过类实例来调用。
	 * 
	 */
	@Override
	public String description() {
		// 这里因为方法要求返回一个String的对象
		// 所以我们反回了一个。这个String对象的引返回了给调用方法。
		// 好，我们在退回到main方法中去
		return "圆形， 半径" + this.r;
	}

}
