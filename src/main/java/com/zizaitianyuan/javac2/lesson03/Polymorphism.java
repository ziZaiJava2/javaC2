
package com.zizaitianyuan.javac2.lesson03;

public class Polymorphism {
	
	// 假设这部分数据是从数据库或者文件读取出来的数据
	static String[][] data = {
			{"Circle", "10"},
			{"Square", "20"},
			{"Circle", "11"},
			{"Circle", "13"},
			{"Square", "15"},
			{"EquilateralTriangle","10"}
	};
	
	
	public static void main(String[] args) {
		
		// 我们的程序是生成一个对对应图形的说明，以及计算图形的周长 perimeter
	for (String[] shape :data) {
		
//		getInstance 在主函数开始时调用，返回一个实例化对象，此对象是static的，在内存中保留着它的引用，即内存中有一块区域专门用来存放静态方法和变量，
//		* 可以直接使用，调用多次返回同一个对象。
		
//		Integer.parseInt(String)就是将String字符类型数据转换为Integer整型数据
		
		Shape s =ShapeFactory.getInstance(shape[0], Integer.parseInt(shape[1]));  
		
		System.out.print(s.toString()+ "，");
		System.out.println("周长： "+s.perimeter());
	}
		
	}
	
	
}

class ShapeFactory{
	public static final String CIRCLE = "Circle";
	
	public static final String SQUARE = "Square";
	
	public static final String E_TRIANGLE = "EquilateralTriangle";

	static Shape getInstance(String type, int len){
		
		Shape s = null;
		if(CIRCLE.equals(type)){
			s = new Circle(len);
		}else if (SQUARE.equals(type)){
			s = new Square(len);
		}else if (E_TRIANGLE.equals(type)){
			s = new ETriangle(len);
		}else{
			System.out.println("错误的输入！！！");
			System.exit(0);
		}
		return s;
	}		
}

//implements是一个类实现一个接口用的关键字，它是用来实现接口中定义的抽象方法。
//实现一个接口，必须实现接口中的所有方法。

class ETriangle implements Shape {
	
	private int side;
	
	public ETriangle(int side){
		this.side = side;
	}
	@Override
	public String toString(){
		
//		String类新增了一个很有用的静态方法String.format(): 
//			format(Locale l, String format, Object... args) 使用指定的语言环境、格式字符串和参数返回一个格式化字符串。 
//			format(String format, Object... args) 使用指定的格式字符串和参数返回一个格式化字符串。
//			举几个这个方法实用的例子(注释是输出结果)： 
		
		return String.format("等边三角形.边长：%d",this.side);
	}
	
	@Override
	public double perimeter(){
		return 3*this.side;
	}
	
}

class Circle implements Shape {
	
	private int r;
	
	public Circle(int r){
		this.r = r;
	}
	@Override
	public String toString(){
		return String.format("圆形.半径长：%d",this.r);
	}
	
	@Override
	public double perimeter(){
		return 2*this.r*Math.PI;
	}
	
}

class Square implements Shape {
	
	private int side;
	
	 public Square(int side){
		this.side = side;
	}
	@Override
	public String toString(){
		return String.format("正方形.边长：%d",this.side);
	}
	
	@Override
	public double perimeter(){
		return 4*this.side;
	}
	
}

class Point{
	
}

interface Shape {

	public String toString();

	public double perimeter();
}
