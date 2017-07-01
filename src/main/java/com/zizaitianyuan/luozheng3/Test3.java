package com.zizaitianyuan.luozheng3;

import java.util.Scanner;

public class Test3 {
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
	public static int fibonacci(int x) {//返回最后一个数
		int[] demo = new int[x];
		for (int i = 0; i < x; i++) {
			if (i == 0||i==1) {
				demo[i] = 1;
			} else {
				demo[i] = demo[i-1]+demo[i-2];

			}
		}
		System.out.print(demo[x-1]);
		return demo[x-1];
	}
}
