package com.zizaitianyuan.javac2.lesson02;

public class Practice4 {

	/**
	 * 参数给定一个内容为 0~9的整型数组， 要求此方法返回从小到大排好序的数组
	 * 
	 * 例如 给定 sourceArray={5, 8, 6, 5, 0, 0, 9, 2, 1} 
	 * 返回结果应该是 {0, 0, 1, 2, 5, 5, 6, 8, 9};
	 * 
	 * @param sourceArray
	 *            一个给定的整型数组， 数组内容都是 0~9 的正数
	 * @return 对sourceArray 从小到大排好序的数组
	 */
	public static int[] sort(int[] sourceArray) {
		int[] result = new int[sourceArray.length];
		int temp;

		for (int x = 0; x < sourceArray.length; x++) {
			for (int y = 0; y < sourceArray.length - 1; y++) {

				if (sourceArray[y + 1] < sourceArray[y]) {//如果后面一个数比前面一个数大
					temp = sourceArray[y + 1];            //则两数交换 ，把小的数放到前面
					sourceArray[y + 1] = sourceArray[y];
					sourceArray[y] = temp;
				}
			}
		}
//		for (int a = 0; a < sourceArray.length; a++) {
//			result[a] = sourceArray[a];
//		}
		
		
		return sourceArray;
	}
}
