package com.zizaitianyuan.javac2.lesson02;

import java.util.Arrays;
import java.util.Random;

public class Practice {

	
	public static void main(String[] args) {
		
		
		printReverseTriangle(3);
		
		printReverseTriangle2(3);
		
		
		int[] array = new int[10];
		Random r = new Random(0);
		for(int i = 0; i < 10; i++) {
			array[i] = r.nextInt(100);
		}
		System.out.println(Arrays.toString(array));
		System.out.println(getMax(array));
	}
	
	
	
	
	
	/**
	 * 要求打印一个高度为2n - 1的菱形
	 * 
	 * 例如n = 3时：
	 *    *
	 *   ***
	 *  *****
	 *   ***
	 *    *
	 */
	public static void skyking(int n) {
		int x, y, z;
           System.out.println("5555555555");
		
		// 下半部分，与上半部分相似
		for (x = n; x <= 2 * n - 1; x++) {
	
		}
	}
	
	//0000000000
	
	/**
	 * 打印高度为n的倒三角
	 * 
	 * 例如n=3时：
	 * 
	 * ***
	 * **
	 * *
	 * 
	 * @param n
	 */
	public static void printReverseTriangle(int n) {
		for (int x = 1; x <= n; x++) {
			for (int y = n; y >= x; y--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	/**
	 * 打印高度为n的倒三角
	 * 
	 * 例如n=3时：
	 * 
	 *   *
	 *  **
	 * ***
	 * 
	 * @param n
	 */
	public static void printReverseTriangle2(int n) {
		for (int x = 1; x <= n; x++) {

			for (int y = 1; y <= n; y++) {
				if (x + y <= n) {               //例如第一行第一个 1+1   ；  第三行第二个 3+2        
					System.out.print(" ");
				} else
					System.out.print("*");
			}

			System.out.println();
		}

	}	
	/**
	 *  返回传入数组中最大的整数
	 *  
	 * @param array
	 * @return
	 */
	public static int getMax(int[] array) {

		for (int x = 1; x < array.length; x++) {
			if (array[0] < array[x]) {
				array[0] = array[x];
			}
		}
		return array[0];
	}
}
