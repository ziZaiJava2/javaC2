package com.zizaitianyuan.javac2.lesson02;

public class Practice2 {

	/**
	 * 
	 * 斐波拉契数列１，　１，　２，　３，　５，　８，　１３
	 * 
	 * 从第三个数字起，每个数字都是前两个数字的和。
	 * 例如：第三个数字是第一个和第二个数字的和，第四个数字是第二个和第三个数字的和
	 * 
	 * 写成数学公式就是
	 * f(ｎ) = 1;当ｎ=1或者ｎ=2时
	 * f(n) = f(n-1) + f(n-2) 当n > 2时
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		fibonacci(6);
		//　请自行补充对ｆｉｂｏｎａｃｃｉ１的测试，这里我就不写了。
		
		if (fibonacci2(1) == 1 && fibonacci2(2) == 1 && fibonacci2(5) == 5 && fibonacci2(8) == 21) {
			System.out.println("fibonacci2正确");
		}

//		如果fibonacci3也实现了，选中下面三行，可以使用ｃｔｒｌ + /来取消注释
//		if (fibonacci3(1) == 1 && fibonacci3(2) == 1 && fibonacci3(5) == 5 && fibonacci3(8) == 21) {
//			System.out.println("fibonacci3正确");
//		}

	}
	
	
	/**
	 * 这个方法期望输入n的时候，返回一个数组，里面包含斐波拉契数列的前n个数
	 * 
	 * 例如：
	 * fibonacci(5)
	 * 返回下面的数组
	 * [1, 1, 2, 3, 5]
	 * @param n
	 * @return
	 */
	public static int[] fibonacci(int n) {
		int[] array = new int[n];
		array[0]=1;
		array[1]=1;
		for(int i=2;i<n;i++){
			array[i]=array[i-1]+array[i-2];
		}
		for(int j=0;j<n;j++){
			
			System.out.print(array[j]+" ");
		}
		return new int[n];
	}
	
	/**
	 * 这个方法期望输入ｎ的时候，返回斐波拉契数列的第ｎ个数
	 * 
	 * 例如：
	 * fibonacci(5)
	 * 返回5
	 * 
	 * 希望这个方法的实现中不要使用数组
	 * 
	 * @param n
	 * @return
	 */
	public static int fibonacci2(int n) {
		    if(n<=2)return 1;
			int a=1,b=1,c=0;
			for(int i=3; i<=n; c=a+b,a=b,b=c,i++);
			System.out.println(c);
			return c;
	}
	
	/**
	 * 如果你知道什么是递归，那么请用递归来实现这个方法
	 * 
	 * 并想一下怎么给不会的同学解释一下什么是递归
	 * 
	 * 如果不会，不用强求着去实现。
	 * 
	 * 如果你觉得知道自己很牛逼了，请写一个新方法，用尾递归来实现斐波拉契数列。
	 * 
	 * @param n
	 * @return
	 */
<<<<<<< HEAD
//<<<<<<< HEAD
//	public static int fibonacci3(int n) {
//		if (n<=2){
//			return 1;
//		}
//<<<<<<< HEAD
//<<<<<<< HEAD
//<<<<<<< HEAD
//<<<<<<< HEAD
//<<<<<<< HEAD
//<<<<<<< HEAD
//		return fibonacci3(n-1)+fibonacci2(nnnnn);
//=======
//		return fibonacci3(n-1)+fibonacci2(n);
//>>>>>>> 96cd5d5... a
//=======
//		return fibonacci3(n-1)+fibonacci2(nnnnn);
//>>>>>>> 18e6b51... f
//=======
//		return fibonacci3(n-1)+fibonacci2(n);
//>>>>>>> 08a7f75... a
//=======
//		return fibonacci3(n-1)+fibonacci2(nnnnn);
//>>>>>>> 10f312b... f
//=======
//		return fibonacci3(n-1)+fibonacci2(n);
//
//
//		return fibonacci3(n-1)+fibonacci2(nnnnn);
//

//
//
//>>>>>>> 48c0a27... homework
//	}
=======


	}
>>>>>>> 48c0a276687d744b1eae8ca0cdbc9ccdf7e9d1d8
}
