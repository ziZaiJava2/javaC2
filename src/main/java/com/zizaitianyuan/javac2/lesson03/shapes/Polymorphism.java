
/*
 * 包： 后面一长串表示一个命名空间，对应的物理位置就是文件结构
 * 
 * 在这个命名空间中，类的名字必须是唯一的。你可以尝试在这个包下再建一个相同名字的类
 * 
 */
package com.zizaitianyuan.javac2.lesson03.shapes;


/*
 * 类定义的语法  
 * 	public class 类名 {}
 * 
 *      
 */
public class Polymorphism {
/*      		^ 类名，这是自己定义的，首字母大写 
 * 		^ class关键字，用来定义类
 * ^ 这个是表示可见性的关键字， 
 * 	
 *  public表示对所有人可见， 就是所有其他类中都可以定义这个类型的变量
 * 	private表示只对类本身可见， 
 *  不带这个关键字，表示包内空间
 *  protected，表示对子类可见
 *  
 *  
 *  每个文件都可以定义一个和这个文件名相同的public类。
 *  
 */
	
	/*
	 * 类变量。
	 * 
	 * 也就是通过关键字static修饰的类的花括号中定义的变量。
	 * 
	 * 同样的，public关键字表示对其他类可以访问。
	 * 
	 * 其他类想访问这个变量，需要使用Polymorphism.data来访问。
	 * 
	 * 也就是：
	 *     类名.类变量名
	 *     
	 *     
	 * 二维数组：
	 * 
	 * 我们一般说定义一个什么类型的数组，这个类型可以是基本类型，也可以是类
	 * 
	 * 例如 int[] a, 表示一个int类型的数组，可以看做一些连续保存的int类型的变量
	 * 那么 Circle[] c,表示的是一个Circle类型的数组，可以看做一些连续保存的Circle类型（引用变量）的变量
	 * 
	 * 
	 * 二维数组可以这么看连续保存的数组类型的变量。
	 * 
	 * int[] a
	 * ---  这一段这个数组中的元素是int类型的。
	 * 
	 * int[][] a
	 * ----- 这段表示这个数组中的元素是int[]类型的。
	 * 
	 */
	public static String[][] data = {
			{"Circle", "10"},  // 这是一个数组    
			{"Square", "20"},  // 这也是一个数组
			{"Circle", "11"},  // 这也是一个数组
			{"Circle", "13"},
			{"Square", "15"},
	};
	
	
	/*
	 * main方法是一个静态方法。和我们自己平时写的其他静态方法的定义没有什么区别。
	 * 只是java会把这个方法当做整个类的入口，从这个方法开始执行。
	 * 
	 * 也可以自己通过   Polymorphism.main({""}); 来调用。
	 * 									 ^ 这里传入一个字符串类型的数组
	 * 
	 * 你们可以试着在其他类中写一个main方法来调用这个静态方法。
	 * 
	 * 
	 * 静态方法的格式是:
	 * 
	 * public static Circle getInstance(String type) 
	 * 
	 * public 可以替换成其他可见性关键词，private等。
	 * 
	 * 第二个，static，说明是个静态方法。
	 * 
	 * Circle，返回类型。表示这个方法会返回一个什么类型的值。
	 * 			如果是基本类型，就是返回一个基本类型
	 * 			如果是类类型，就是返回一个这个类型的引用变量的值，也就是一个堆类对象的地址。
	 * 
	 * getInstance,方法名，就是这个方法的名字。
	 * 
	 * 参数列表，就是调用这个方法应该传什么东西给他。
	 * 
	 * 
	 * 静态方法，static关键字修饰， 就是通过
	 *  		类名.方法名(参数列表); 
	 * 的方式来调用。
	 * 
	 * void 这个表示这个方法的返回类型， void表示不返回值。
	 * 也可以是int.... 等基本类型，
	 * 或者 Circle... 等类的类型
	 * 
	 * 
	 * 如果返回类型不为void，那么方法执行完，一定要有一个 return XXX; 的语句。
	 * XXX和方法中定义的返回类型必须是一种类型，或者是返回类型的子类，因为我们说过，子类可以当做父类这个类型。
	 * 			
	 * 当方法执行到一个return语句的时候，后面的语句就不会执行了，方法直接返回。
	 * 
	 * 
	 */
	public static void main(String[] args) {
		
		// 我们的程序是生成一个对对应图形的说明，以及计算图形的周长 perimeter
		// 二维数组中的元素是String[]这个类型的数组，所以for-each语句中的类型就是String[],一个数组
		for(String[] shape: data) {
			/* 这里我们定义了一个String类型的变量，那么这个变量就只能接受一个Stirng的实例
			 * 
			 * String也是类，这个类型的变量也只能被赋一个new String()的对象。
			 * java只是提供了一个简单的方式让我们生成 String的对象。
			 * 你也可以这么生成String的对象。自己找个地方写一下下面这个语句。
			 *		String type = new String("Circle");
			 * 
			 */
			String type = shape[0];
			// Integer.paserInt就是对Integer这个类的一个静态方法parseInt的调用
			// 按住crtl，点击下面的parseInt方法，你可以跳过去看到方法定义。
			// 和我们写的静态方法没什么区别。
			
			int len = Integer.parseInt(shape[1]);
			// 这一行就是调用我们自己定义的一个静态方法。
			// 按住crtl, 点击getInstance跳转到实现去
			Shape s = ShapeFactory.getInstance(type, len);
			
			
			// 这里调用的是对象方法，然后将返回值和其他字符串拼接在一起。
			
			// 第一个s的实例是Circle，虽然赋值给了Shape，因为子类可以当做父类。
			
			// 但他自己本身是Cirlce,
			
			// 这里你可以这么理解
			
			/*
			 *	人是父类，男人是子类。我们任向杰是男人的实例。
			 *
			 *	我们说任向杰这个人		这个说法没错吧，他是男人，但是同时也是人。
			 *  但是我们说任向杰这个人，他不会因为你这么说，变的不是男人了。他虽然是人，但他仍然是个男人。
			 *  只是说他是人这个更泛指一些，他本身不会因为你怎么叫他就变化了。
			 */
			
			// 手动切换到Circle中去，找一下description方法
			
			// 切换回来之后，s.description()的调用返回了一个String的引用，然后将这个String的引用和后面的拼起来
			// 变成了 圆形， 半径： 10 周长为:
			// 然后调用s.perimeter()方法。
			System.out.println(s.description() + " 周长为: "  + s.perimeter());
		}
		
	}
	
}

