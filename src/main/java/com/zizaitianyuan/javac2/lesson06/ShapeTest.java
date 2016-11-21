package com.zizaitianyuan.javac2.lesson06;

public class ShapeTest {
	static final String CIRCLE = "Circle";
	static final String SQUARE = "Square";

	static String[][] data = { { "Circle", "10" }, { "Square", "20" }, { "Circle", "11" }, { "Circle", "13" },
			{ "Square", "15" }, { "EquilateralTriangle", "10" } };

	public static void main(String[] args) {
		
		for(String [] shape : data){
			Shape s = ShapeFactory.getInstance(shape[0], Integer.parseInt(shape[1]));
			
			System.out.print(s.toString()+ ",");
			System.out.println("周长是：" + s.perimeter());
		}

	}

}
