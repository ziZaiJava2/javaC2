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
		for(int i = 0; i < n - 1; i++) 
        { 
            for(int x = i + 1; x < n; x++) 
            { 
                System.out.print(" "); 
            } 
            for(int y = 0; y < 2*i+1; y++) 
            { 
                System.out.print("*"); 
            } 
            System.out.println(); 
        } 
        for(int i = 0; i < n; i++) 
        { 
            for(int x = 0; x < i; x++) 
            { 
                System.out.print(" "); 
            } 
            for(int y = i; y < 2 * n - i - 1; y++) 
            { 
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
		for(int i=0;i<n;i++){
			for(int j=0;j<n-i;j++){
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
		for(int i=0;i<n;i++){
			for(int x=0;x<n-i-1;x++){
				System.out.print(" ");
			}
			for(int y=0;y<i+1;y++){
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
		int max=array[0];
		for(int i=1;i<array.length;i++){
			if(array[i]>max){
				max=array[i];
			}
		}
		return max;
	}
}
