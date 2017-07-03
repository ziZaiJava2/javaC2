package com.zizaitianyuan.luozheng3;

import java.util.Scanner;

/**
 * 要求打印一个高度为2n - 1的菱形
 * 
 * 例如n = 3时： * *** ***** *** *
 */

public class Test1 {
	public static void main(String arge[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("请输入行数：");
		int rows = sc.nextInt();// 行數
		for (int i = 1; i <= rows; i++) {// 上半部分
			// 打印空格
			for (int j = 1; j <= rows - i; j++) {
				System.out.print(" ");
			}
			// 打印*
			for (int j = 1; j <= 2 * i - 1; j++) {
				System.out.print("*");
			}
			// 完成一行就换行
			System.out.println();
		}
		for (int i = 1; i <= rows - 1; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= 2 * (rows - 1 - i) + 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
}
