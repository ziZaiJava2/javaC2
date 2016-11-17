package com.zizaitianyuan.javac2.lesson.example.javaclass;

public class Employee extends Person{

	private String componyName;
	
	public Employee(String name, int age){
		super(name, age);
	}
	
	public Employee(String name, int age, String componyName){
		super(name, age);
		this.componyName = componyName;
	}
	
	/*
	 * 错误的构造函数， 因为子类初始化必须先调用父类的构造函数， 任何类没有定义构造函数的话， Java会自动提供一个
	 * 没有参数的构造函数。 有其他有参数的构造函数定义的话， java就不会自动提供这个构造函数。
	 * 当子类构造函数中没有显示的调用父类构造函数时， java会默认调用父类无参数的构造函数
	 */
//	public Employee(String componyName){
//		this.componyName = componyName;
//	}
	
	/*
	 * 子类可以使用父类中的方法， 即使子类中没有这个方法的定义
	 * e.g. 
	 *		Employee weiwei = new Employee("weiwei", 18);
	 *		weiwei.sayHello();
	 */
	
	/*
	 * 当子类定义了和父类相同的方法时， 会重写父类的方法。
	 */
	public void sayHello(){
		System.out.printf("Hello, my name is %s, %d years old, working in %s, I'm a employee", name, age, componyName);
	}
	
	
	public void sayHelloWorld(){
		System.out.println("Hello world");
	}
	
	public static void main(String args[]){
		Employee weiwei = new Employee("weiwei", 18, "野村证券");
//		Person weiwei = new Employee("weiwei", 18, "野村证券");
		weiwei.sayHelloWorld();
		
	}
}
