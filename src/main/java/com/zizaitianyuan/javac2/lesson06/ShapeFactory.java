package com.zizaitianyuan.javac2.lesson06;

public class ShapeFactory {
	static final String CIRCLE = "Circle";
	static final String SQUARE = "Square";
	
	public static Shape getInstance(String type, int len){
		
		Shape s = null;
		if(CIRCLE.equals(type)){
			s = new Circle(len);
		}else if(SQUARE.equals(type)){
			s = new Square(len);
		}else{
			System.out.println("输入错误");
			System.exit(0);
		}
		
		
		return s;
		
	}
	
}
