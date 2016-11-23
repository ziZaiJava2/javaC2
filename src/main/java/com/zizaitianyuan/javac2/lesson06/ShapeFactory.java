package com.zizaitianyuan.javac2.lesson06;

//从数据库或者文件读取出来的数据
public class ShapeFactory{
public static final String CIRCLE = "Circle";
public static final String SQUARE = "Square";
public static final String E_TRIANGLE = "EquilateralTriangle";

public static Shape getInstance(String type,int len){
	Shape s = null;
	if(CIRCLE.equals(type)){
		s = new Circle(len);
	} else if (SQUARE.equals(type)){
		s = new Square(len);
	} else if (E_TRIANGLE.equals(type)){
		s = new Etriangle(len);
	} else{
		System.out.println("输入错误");
		System.exit(0);
	}
	return s;
}

static String[][] data = {
		{"Circle","10"},
		{"Square","20"},
		{"Circle","11"},
		{"Circle","13"},
		{"Square","15"},
		{"EquilateralTriangle","10"}
};

public static void main(String[] args){
//	生成一个对对应图形的说明，并计算图形的周长perimeter
//	for(String[] shape : data){
//		String type = shape[0];
//		int len = Integer.parseInt(shape[1]);
//		
//		if(CIRCLE.equals(type)){
//			System.out.printf("圆形： 半径： &d，周长： %f \n",len,2 * len * Math.PI);
//		} else if (SQUARE.equals(type)){
//			System.out.printf("正方形： 边长： %d，周长： %d \n", len ,4 * len);
//		}else{
//			System.out.printIn("错误的输入");
//		}
//	}
	
	for(String[] shape : data) {//数组里放的是数组
//		String type = shape[0];
//		int len = Integer.parseInt(shape[1]);
//		
//		if(CIRCLE.equals(type)){
//			Circle s = new Circle(len);
//			System.out.print(c.toString() + ",");
//			System.out.println("周长： " + c.perimeter());
//		} else if (SQUARE.equals(type)){
//			Square s = new Square(len);
//			System.out.print(s.toString() + ",");
//			System.out.println("周长：" + s.perimeter());
//		}
		Shape s = ShapeFactory.getInstance(shape[0],Integer.parseInt(shape[1]));
		
		System.out.print(s.toString() + ",");
		System.out.println("周长：" + s.perimeter());
	}
}

}
class Circle implements Shape {
	
	private int r;
	
	public Circle(int r){
		this.r =r;
	}

	@Override
	public String toString(){
		return String.format("圆形.半径：&d",this.r);
	}
	
	public double perimeter(){
		return 2 * this.r * Math.PI;
	}
}


class Square implements Shape{
	
	private int side;
	public Square(int side){
		this.side = side;

	}
	@Override
	public String toString(){
		return String.format("正方形. 边长： %d",this.side);
	}
	
	public double perimeter(){
		return 4 * this.side;
	}
}

class Etriangle implements Shape{
	
	private int side;
	
	public Etriangle(int side){
		this.side = side;
	}
	@Override
	public String toString(){
		return String.format("等边三角形.边长：%d",this.side);
	}
	@Override
	public double perimeter(){
		return 3 * this.side;
	}
}

interface Shape{
	public String toString();
	public double perimeter();
}

