package com.zizaitianyuan.javac2.lesson02;

public class Practice4 {

	/**
	 * 参数给定一个内容为 0~9的整型数组， 要求此方法返回从小到大排好序的数组
	 * 
	 * 例如 给定 sourceArray={5, 8, 6, 5, 0, 0, 9, 2, 1} 返回结果应该是 {0, 0, 1, 2, 5, 5,
	 * 6, 8, 9};
	 * 
	 * @param sourceArray
	 *            一个给定的整型数组， 数组内容都是 0~9 的正数
	 * @return 对sourceArray 从小到大排好序的数组
	 */
	public static int[] sort(int[] sourceArray) {
		int[] result = new int[sourceArray.length];
<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> 5ce9789... practice4
		for (int i = sourceArray.length - 2; i >= 0; i--) {
			for (int j = 0; j <= i; j++) {
				if (sourceArray[j] > sourceArray[j + 1]) {
					int tmp;
					tmp = sourceArray[j];
					sourceArray[j] = sourceArray[j + 1];
					sourceArray[j + 1] = tmp;
				}
			}
		}
<<<<<<< HEAD
<<<<<<< HEAD

<<<<<<< HEAD
=======
		Arrays.sort(sourceArray);
		
>>>>>>> 6c21a42... practice4
=======
>>>>>>> 5ce9789... practice4
=======
>>>>>>> 8377485... 4
=======
		
		
>>>>>>> 0f4775d... 0
		return sourceArray;
	}
}
