package com.zizaitianyuan.javac2.lesson03;

public class Dish {
//	这次我们模拟一个食堂洗碗窗口
//	这次练习的整个框架都需要自己写。内容来源于上次练习和昨天讲的内容。
//	第一步：
//	定义几种碗和盘子的类型。每种类型都有一个字符串*常量*
//	他们都提供了一个叫做getType的方法，可以取得盘子类型的字符串。
//	定义一个静态方法根据传入字符串生成对应类型的对象
	static String[][] data = {
			{"Circle", "red "},
			{"Square", "blue"},
			{"Circle", "blue"},
			{"Circle", "blue"},
			{"Square", "red "},
	};
	public static final String CIRCLE = "Circle";
	public static final String Square = "Square";
	
	
	
	interface Things{
		public String  toString(); 
		
		
	}
	
	
	
//	第二步：
//	一个洗碗传送台，可以定义为一个LinkedList类型，每次从尾部放入要洗的盘子，从头拿出盘子去洗。
//	要求所有类型的盘子都能放入传送台，但是只有盘子可以放上去，你不能放一个人的对象上去。

	
	
	
	
//	第三步：
//	一个碗柜，这个碗柜按盘子类型把洗好的碗分类放进去。
//	碗柜可以定义成map，key是各种盘子类型字符串，value是一个list，用来保存洗好的碗。

	
	
	
	
//	第四步：
//	两个洗碗工，他们可以随机从传送台取3到5个盘子，洗完放入碗柜。并记下自己洗了多少碗
//	这个你们可以暂时定义成两个方法，他们从传送台取随机的盘子数量，放入碗柜

	
	
	
//	第五步：
//	定义一个方法随机放入4到12个盘子到传送台，并统计总共放入盘子的数量

	
	
	
//	第六步：
//	main方法，循环十次，每次循环先调用放入盘子的方法，然后调用两个洗碗工方法。
//	之后统计总共放入多少个盘子。每个洗碗工洗了多少个，传送台上还剩下多少个盘子。碗柜里总共有多少个盘子，各种类型的盘子是多少。
//	最后看看盘子有没有丢

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
