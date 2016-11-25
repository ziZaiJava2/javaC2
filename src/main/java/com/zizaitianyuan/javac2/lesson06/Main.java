package com.zizaitianyuan.javac2.lesson06;

public class Main {

	public static void main(String[] args) {
		Bar b = new Bar(10);
		b.add(20);
		System.out.println(b);
	}
	
}

class Bar {
	public int bar;
	
	public Bar(int bar) {
		this.bar = bar;
	}
	
	public Bar add(int bar) {
		Bar b = new Bar(this.bar + bar);
		return b;
		
	}
	
	@Override
	public String toString() {
		return "" + this.bar;
	}
}

