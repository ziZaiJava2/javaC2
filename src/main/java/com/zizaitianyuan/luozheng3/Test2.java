package com.zizaitianyuan.luozheng3;

import java.util.Scanner;

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
/**
 * 
 * 斐波拉契数列１， １， ２， ３， ５， ８， １３
 * 
 * 从第三个数字起，每个数字都是前两个数字的和。 例如：第三个数字是第一个和第二个数字的和，第四个数字是第二个和第三个数字的和
 * 
 * 写成数学公式就是 f(ｎ) = 1;当ｎ=1或者ｎ=2时 f(n) = f(n-1) + f(n-2) 当n > 2时
 * 
 * @param args
 */

public class Test2 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入一个数字：");
		int x = sc.nextInt();
		fibonaccis(x);
		System.out.println();//分离
		fibonacci(x);
	}

	public static int[] fibonaccis(int x) {//返回数组
		int[] demo = new int[x];
		for (int i = 0; i < x; i++) {
			if (i == 0||i==1) {
				demo[i] = 1;
			} else {
				demo[i] = demo[i-1]+demo[i-2];

			}
			System.out.print(demo[i] + " ");
		}
		return demo;
	}
	public static int[] fibonacci(int x) {//返回最后一个数
		int[] demo = new int[x];
		for (int i = 0; i < x; i++) {
			if (i == 0||i==1) {
				demo[i] = 1;
			} else {
				demo[i] = demo[i-1]+demo[i-2];

			}
		}
		System.out.print(demo[x-1]);
		return demo;
	}

}
