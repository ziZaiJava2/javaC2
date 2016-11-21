package com.zizaitianyuan.javac2.lesson06;

public class Square implements Shape {
	private int side;
	
	public Square(int side){
		this.side = side;
	}
	
	
     public String toString(){
    	 return String.format("正方形,边长：%d",this.side);
     }
	public double perimeter() {
		
		return 4*this.side;
	}
}
