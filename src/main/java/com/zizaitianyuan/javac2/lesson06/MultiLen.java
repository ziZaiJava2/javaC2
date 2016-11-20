package com.zizaitianyuan.javac2.lesson06;

public class MultiLen {
	static String[][] data=new String[][]{
		{"Circle","10"},
		{"Square","20"},
		{"Circle","11"},
		{"Circle","13"},
		{"Square","15"}
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (String[] ss : data) {
			Shape s = ShapeFactory.Instances(ss[0], Integer.parseInt(ss[1]));
			System.out.print(s.toString() + ",");
			System.out.println(" 周长是:" + s.perimeter());
		}
	}
}
