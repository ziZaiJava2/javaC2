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
		
   	
		
		for(int i =1; i <= n; i++){
			for(int k = 0; k < n-i; k++){
				System.out.print(" ");
			}
			for(int j = 1; j <=2*i-1; j++){
				System.out.print("*");
			}
			System.out.println();
		}
   		for(int i = 1; i < n; i++){
   		   	for(int j = 0; j < i; j++){
   		   		System.out.print(" ");
   		   	}
   		   	for(int k = 0; k < -2*i+5; k++){
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
	 * ***
	 * **
	 * *
	 * 
	 * @param n
	 */
	public static void printReverseTriangle(int n) {
		
		for( int i = n; i > 0; i--){
			for(int j = 0; j < i; j++){
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
		for( int i = 1; i <= n; i++){
				for(int j = 1; j <= n-i; j++){
					System.out.print(" ");
			}
				for(int k = 1; k <= i; k++){
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
		int i;
		for( i = 0; i < 8; i++){
			if(array[i]>array[i+1]){
				int tmp;
				tmp = array[i];
				array[i] = array[i+1];
				array[i+1] = tmp;
			}
		}
		
		int max = array[i];
		return max;
	
	}
}
