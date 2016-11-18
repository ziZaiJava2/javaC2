package com.zizaitianyuan.javac2.jingsaiti;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;



public class WashTheBowl {
	public static void main(String[] args) { 
		LinkedList<getType>line = new LinkedList<>();
		for (int i = 0; i < 10; i++) {

			washedBowl();
		}
		
	}
	private static void washedBowl() {
		// TODO Auto-generated method stub
		
	}
	private static final Bowl bowl = null;

	/*
	 * 初始化一个用来存储所有碗和盆的List， 最后面的代码块用来构造一些学生对象 并把他们保存在 allBowls中
	 */
	public static ArrayList<Bowl> allBowls = new ArrayList<Bowl>();

	// 一个Map 用来存储碗和盆的碗柜， key是各种盘子类型字符串， value是一个list
	public static Map<String, Bowl> bowlMapWithNameKey = new HashMap<String, Bowl>();
	

		
    
	 
	 	

}





class getType{
	public static final String CIRCLE = "Circle";

	public static final String SQUARE = "Square";

	public static final String E_TRIANGLE = "EquilateralTriangle";
	
	public static final String SMALL = "Small";
	
	public static final String BIG = "Big";

	public static Shape getInstance(String type, int len) {
		Shape s = null;
		if (CIRCLE.equals(type)) {
			s = new Circle(len);
		} else if (SQUARE.equals(type)) {
			s = new Square(len);
		} else if (E_TRIANGLE.equals(type)) {
			s = new ETriangle(len);
		} else {
			System.out.println("错误的输入！！！");
			System.exit(0);
		}
		return s;
	}
	
}

class Bowl {
	// 型号
	private String id;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}	
	

	


interface Shape {
	public String toString();

	public double perimeter();
}

