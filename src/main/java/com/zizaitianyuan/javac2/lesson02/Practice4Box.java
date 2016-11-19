package com.zizaitianyuan.javac2.lesson02;

public class Practice4Box {
	/**
	 * �������飬ͨ���������㷨ʵ�ִ�С��������
	 * @param sourceArray
	 * @return
	 */
	
	public static int[] sort(int[] sourceArray) {
		/*
		 *	���巵�ص�����͡����ӡ���
		 */
		int[] result = new int[sourceArray.length];
		int a[] = new int[10];
		int k = 0;
		/*
		 *	����ԭ���鲢����Ӧ��ֵ���ڶ�Ӧ�������
		 */
		for (int i = 0; i < sourceArray.length; i++) {
			a[sourceArray[i]]++;
		}
		/*
		 *	��ֵ���������顣
		 */
		for (int i = 0; i < 10; i++) {
			for (int j = 1; j <= a[i]; j++) {
				result[k++] = i;
			}
		}
		return result;
	}
}