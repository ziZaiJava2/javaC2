package com.zizaitianyuan.javac2.lesson06;

public class Circle implements Shape{
	private int r;
	
	public Circle(int r){
		this.r = r;
	}
	
	
     public String toString(){
    	 return String.format("圆形，半径：%d",this.r);
     }
	public double perimeter() {
		
		return 2*Math.PI*this.r;
	}

}
