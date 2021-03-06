package com.zizaitianyuan.javac2.lesson06;

import java.util.ArrayList;
import java.util.List;

public class RuntimeDemo {

	public static void main(String[] args) {
		String name = new String("Kai");
		
		Foo aFoo = new Foo();
		Foo foo = aFoo.append(name);
		
		System.out.println("size of aFoo: " + aFoo.strs.size());
		System.out.println(aFoo == foo);
		
		
		Foo anotherFoo = new Foo();
		foo = anotherFoo.append(name);
		System.out.println("size of anotherFoo: " + anotherFoo.strs.size());
		System.out.println(anotherFoo == foo);
		
		System.out.println("size of Foo.allStrs: " + Foo.allStrs.size());
		System.out.println(Foo.allStrs.get(0) == Foo.allStrs.get(1));
		
		System.out.println(aFoo.strs.get(0) == anotherFoo.strs.get(0));
		System.out.println(aFoo.strs.get(0) == Foo.allStrs.get(1));
	}
	 
	
	
}

class Foo {
	
	public static List<String> allStrs = new ArrayList<>();
	
	public List<String> strs = new ArrayList<>();
	
	public Foo append(String s) {
		
		List<String> all = Foo.allStrs;
		all.add(s);
		
		this.strs.add(s);
		
		return this;
	}
}
