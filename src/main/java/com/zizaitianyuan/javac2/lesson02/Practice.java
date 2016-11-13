package com.zizaitianyuan.javac2.lesson02;

import java.util.Arrays;
import java.util.Random;

public class Practice {

	
	public static void main(String[] args) {
		
		printDiamond(3);
		
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
	public static void printDiamond(int n) {
<<<<<<< HEAD
		int x, y, z;

		// 上半部分
		for (x = 1; x < n; x++) {
			for (y = 1; y <= 2 * n - 1; y++) {
				if ((x + y) == (n + 1)) {              // 第一行正中间的*号，第二行正中间（左边+1）的*号出现时，
					for (z = 1; z <= 2 * x - 1; z++) { // 输出*号，同时控制个数
						System.out.print("*");
					}
				} else {                               // 不满足条件的则输出空格
					System.out.print(" ");
				}
			}
			System.out.println();
		}

		// 下半部分，与上半部分相似
		for (x = n; x <= 2 * n - 1; x++) {
			for (y = 1; y <= 2 * n - 1; y++) {
				if ((n - (x - n) + y) == (n + 1)) {     // (n-(x-n)等于上半部分的x
					for (z = 2 * (n - (x - n)) - 1; z > 0; z--) {
						System.out.print("*");
					}
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
=======
		int n1=3;
		for(int i=1;i<=n1;i++){
            for(int j=1;j<=n1-i;j++){
			System.out.print(" ");
			}
			for(int j=1;j<=(2*i-1);j++){
			System.out.print("*");
			}
			System.out.println();
			}
			
		for(int i=n1-1;i>0;i--){
			for(int j=1;j<=n1-i;j++){
			System.out.print(" ");
			}
			for(int j=1;j<=(2*i-1);j++){
			System.out.print("*");
			}
			System.out.println();
			}
>>>>>>> f480394... homework~
	}

	
	
	
	
	
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
<<<<<<< HEAD
		for (int x = 1; x <= n; x++) {
			for (int y = n; y >= x; y--) {
				System.out.print("*");
			}
			System.out.println();
		}
=======
		int n1 = 3;
		for(int i =0;i<=n1;i++){
			for(int j=i+1;j<=n1;j++){
				System.out.print("*");
			}
			System.out.println();}
>>>>>>> f480394... homework~
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
<<<<<<< HEAD
		for (int x = 1; x <= n; x++) {

			for (int y = 1; y <= n; y++) {
				if (x + y <= n) {               //例如第一行第一个 1+1   ；  第三行第二个 3+2        
					System.out.print(" ");
				} else
					System.out.print("*");
			}

			System.out.println();
		}

=======
		int n2 = 3;
		for(int i =0;i<=n2;i++){
			for(int j=n2;j>=i;j--){
				System.out.print(" ");
			}
			for(int q=i;q>0;q--){
				System.out.print("*");
			}
			System.out.println();
			}
		
	
>>>>>>> f480394... homework~
	}	
	/**
	 *  返回传入数组中最大的整数
	 *  
	 * @param array
	 * @return
	 */
	public static int getMax(int[] array) {
<<<<<<< HEAD

		for (int x = 1; x < array.length; x++) {
			if (array[0] < array[x]) {
				array[0] = array[x];
			}
		}
		return array[0];
=======
		int n=array[0];
		for(int i = 0; i < 10; i++){
			if(array[i]>n)
			n=array[i];
			
		}
		return n;
>>>>>>> f480394... homework~
	}
}