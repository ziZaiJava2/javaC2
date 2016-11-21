package com.zizaitianyuan.javac2.lesson03.shapes;

public class Square implements Shape {
	
	private int side;

	public Square(int len) {
		this.side = len;
	}

	@Override
	public double perimeter() {
		// 看到没有，在同一个类中，都是实例方法或者变量，this也是可以省略的。
		return 4 * side;
	}

	@Override
	public String description() {
		return "正方形, 边长" + this.side;
	}

}
