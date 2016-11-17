public class Practice4Box {
	/**
	 * 传入数组，通过箱排序算法实现从小到大排序。
	 * @param sourceArray
	 * @return
	 */
	
	public static int[] sort(int[] sourceArray) {
		/*
		 *	定义返回的数组和“箱子”。
		 */
		int[] result = new int[sourceArray.length];
		int a[] = new int[10];
		int k = 0;
		/*
		 *	遍历原数组并将相应的值放于对应的箱子里。
		 */
		for (int i = 0; i < sourceArray.length; i++) {
			a[sourceArray[i]]++;
		}
		/*
		 *	赋值给返回数组。
		 */
		for (int i = 0; i < 10; i++) {
			for (int j = 1; j <= a[i]; j++) {
				result[k++] = i;
			}
		}
		return result;
	}
}