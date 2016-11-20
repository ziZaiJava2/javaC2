package com.zizaitianyuan.javac2.lesson06;

public class ShapeFactory {
	private static final String CIRCLE = "Circle";
	private static final String SQUARE = "Square";

	public static Shape Instances(String type, int len) {
		Shape s = null;
		if (CIRCLE.equals(type)) {
			s = new Circle(len);
		} else if (SQUARE.equals(type)) {
			s = new Square(len);
		} else {
			System.out.println("数据错误!!");
			System.exit(0);
		}
		return s;
	}
}
