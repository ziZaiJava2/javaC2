package com.zizaitianyuan.javac2.lesson06;

public class Circle implements Shape{
	int r;

	public Circle(int r) {
		this.r = r;
	}

	@Override
	public String toString() {
		return String.format("圆形,半径%d", this.r);
	}
	
	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return 2 * this.r * Math.PI;
	}
}
