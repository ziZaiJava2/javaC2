package com.zizaitianyuan.javac2.lesson03.shapes;

public class ShapeFactory {

	public static final String CIRCLE = "Circle";
	
	public static final String SQUARE = "Square";
	
	
	/*
	 * 看到没有，格式还是老样子，
	 * 
	 * public static 返回类型  方法名(参数列表)
	 * 
	 * 这个方法返回类型是Shape，就是说要是一个Shape类型或者是他的子类。
	 * 因为Shape是一个接口，所以就是实现了这个接口的子类。
	 * 
	 * 这个方法的名字是getInstance，
	 * 所以我们能够通过ShapeFactory.getInstance(...)的方式来调用
	 * 
	 * 这个方法的参数列表是String, int
	 * 表示第一个参数是String， 第二个参数是int
	 * 所以我们第一个参数必须是一个对string实例的引用，第二个参数必须是一个int
	 * 
	 * 你可以试试其他类型，这样程序会报错。
	 * 
	 * 
	 * 然后我们要求了必须返回Shape类型的引用。
	 * 
	 * 所以我们的方法中无论那条路下来，都必须有一个return XXX;的语句来返回一个这样的类型。
	 * 
	 * 你可以尝试删除一下其中某一个return语句，会提示你那条分支没有return语句。
	 */
	public static Shape getInstance(String type, int len) {
		
		/*
		 * 这里的CIRCLE是静态类变量
		 * 我们说了，静态类变量必须通过  类名.静态类变量名的方式来访问。
		 * 
		 * 但是因为他们处于同一个类中，所以类名可以省略。
		 * 
		 * 你也可以改成	ShapeFactory.CIRCLE,自己改了试试看。
		 * 
		 */
		if (CIRCLE.equals(type)) {
			// new一个对象的语法，就是产生一个这个类型的具体实例，在堆中生成一个对象，占用内存的。然后
			// 这个return语句把这个堆中的地址返回了出去，就是一个Shape类型的引用变量值。
			// 好好回忆一下今天的课。
			return new Circle(len);
		} else {
			return new Square(len);
		} 
	}
}
