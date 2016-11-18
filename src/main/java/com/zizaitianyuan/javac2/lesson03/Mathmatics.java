package com.zizaitianyuan.javac2.lesson03;

public class Mathmatics {

	
	public static int add(int a, int b) {
		return a + b;
	}
	
	/*
	 * overload,方法名字不变，但是参数变了，这里的变包括参数个数
	 */
	public static int add(int a, int b, int c) {
		return a + b + c;
	}
	
	/*
	 * 以及参数类型的变化
	 */
	public static double add(double a, double b) {
		return a + b;
	}
	
	/*
	 *  但是，Java中返回值不算做签名的一部分，所以单独改变返回值的话，不能算作overload.
	 *  
	 *  取消下面的注释，会发现eclipse会报错说重复定义方法了
	 */
//	public static int add(double a, double b) {
//		{
//	     return(int)(a+b);
//	}
	
	
	// 补充减法，命名为sub
	
	public static int sub(int a, int b) {
		return a - b;
	}

	public static int sub(int a, int b, int c) {
		return a - b - c;
	}

	public static double sub(double a, double b) {
		return a - b;
	}
	
	/*
	 * 做完题再补充一个知识点，可变参数列表
	 * 
	 * 我们继续重载add方法，这次这个新的方法可以接受任意数量整数
	 */
	public static int add(int ...args) {
	//                        ^ 这里的...表达式的是可以接受任意个整数，而args的类型是一个***整数数组***
		int sum = 0;
		// 这里我们就可以用for-each来循环了，因为args是一个数组
		for(int arg: args) {
			sum += arg;
		}
		return sum;
	}
	
	/*
	 * 继续重载add, 可变参数可以和其他参数一起使用，但是可变参数列表必须放在最后一个.想想为什么？
	 */
	public static double add(double a, double ...args) {
		double sum = a;
		for(double arg : args) {
			sum += arg;
		}
		return sum;
	}
	
	/*
	 * 自己尝试给sub添加可变参数列表
	 */
	public static double sub(double a, double... args) {
		double nub = a;
		for (double arg : args) {
			nub -= arg;
		}
		return nub;
	}
}
