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
	
	/*
	 *	使用了快速排序算法quicksort()，对sourceArray数组进行有小到大的排序。
	 */
	public static int[] sort(int[] sourceArray) {
		int[] result = new int[sourceArray.length];
		quicksort(sourceArray, 0, sourceArray.length - 1);
		result = sourceArray;
		return result;
	}
	
	/*
	 *	快速排序算法，传入3个参数：数组名，数组首元素的序号，数组尾元素的序号 。
	 */
	private static void quicksort(int sourceArray[], int left, int right) {
		
		/*
		 *	定义六个int变量
		 *	i:被赋值为传入的数组首元素序号。
		 *	j:被赋值为传入的数组尾元素序号。
		 *	temp:被赋值为数组首元素。
		 *	t:中间值，用于两数交换。
		 *	sourceArrayCopy[]:用于接受改变后的sourceArray数组的引用。 
		 */
		
		int i, j, temp, t, sourceArrayCopy[];
		if (left > right) {
			return;
		}
		i = left;
		j = right;
		temp = sourceArray[left];
		while (i != j) {
			while (sourceArray[j] >= temp && i < j) {
				j--;
			}
			while (sourceArray[i] <= temp && i < j) {
				i++;
			}
			if (i < j) {
				t = sourceArray[i];
				sourceArray[i] = sourceArray[j];
				sourceArray[j] = t;
			}
		}
		sourceArray[left] = sourceArray[i];
		sourceArray[i] = temp;
		sourceArrayCopy = sourceArray;
		quicksort(sourceArrayCopy, left, i - 1);
		quicksort(sourceArrayCopy, i + 1, right);
		return;

	}
}
