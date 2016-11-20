package com.zizaitianyuan.javac2.lesson02;

public class Practice3 {

	private static int MAX_SIZE = 5;
	
	/**
	 * 
	 * 传入两个***有序***的正整数数组(都大于０)，两个数组的整数个数小于5个
	 * 
	 * 这是我近期工作中碰到的，也是以前同时刚刚碰到的一个实际工作中的问题，这个问题
	 * 我们之后还会拿出来几次使用不同的解法来说明一些写代码要注意的问题。
	 * 
	 * 今天我们用最笨的方法来解决。如果能提供多个解法也可以。
	 * 
	 * 写一个程序：
	 * 将两个数组都含有的元素放入result.inBoth中；
	 * 将第一个数组有，第二个数组没有的元素放入result.onlyInSource中；
	 * 将第二个数组右，但是第一个数组中没有的元素放入result.notInSource中
	 * 
	 * 例如
	 * source = [1, 3, 6, 9]
	 * newData = [3, 9, 11, 21]
	 * 
	 * 那么返回的结果
	 * result.onlyInsource = [1, 6, 0, ...]
	 * result.inBoth = [3, 9, 0, ...]
	 * result.notInSource = [11, 21, 0, ...]
	 * 
	 * 
	 * 写完之后，在eclipse中左边选中src/test/java/.../Practice3Test.java这个文件，右键 -> Run as -> JUnit Test
	 * 
	 * 如果执行没有错误的话，就说明写对了。
	 * 
	 * @param source
	 * @param newData
	 * @return
	 */
	public static Result merge(int[] source, int[] newData) {
		
		Result result = new Result();
		
		// 这个时候，我初始化了三个数组，数组里面都是5个零
		result.onlyInSource = new int[MAX_SIZE];
		result.inBoth = new int[MAX_SIZE];
		result.notInSource = new int[MAX_SIZE];
		
		
		
		// 把你的计算过程写在这里, 不同的值放进不同的数组里面
		// 比如两个数组都有的值是１，使用这个语句　result.inBoth[n] = 1;
		// 比如只在source有的值是１，使用这个语句　result.onlyInsource[n] = 1;
		// 比如只在newData有的值是１，使用这个语句　result.notInSource[n] = 1;
		// 其中ｎ是你要放入元素的位置
		
		
		// 这里写计算过程：
//		int num=0;
//		for(int x = 0;x < source.length;x++ ){
//			for(int y = 0 ; y < newData.length;y++){
//				if(source[x] == newData[y]){
//					
//						result.inBoth[num++]=source[x];
//						source[x] = 0;
//						newData[y] = 0;
//						break;
//					
//				}
//			}
//		}
//		
//		
//		for (int x = 0; x < source.length; x++) {
//			for (int y = 0; y < newData.length; y++) {
//				if (source[x] != newData[y]) {
//					for (int z = 0; z < source.length; z++) {
//						result.onlyInSource[z] = source[x];
//					}
//				}
//			}
//		}
//		
//		
//		for (int x = 0; x < source.length; x++) {
//			for (int y = 0; y < newData.length; y++) {
//
//				if (source[x] != newData[y]) {
//					for (int z = 0; z < newData.length; z++) {
//						result.notInSource[z] = source[y];
//
//					}
//				}
//			}
//		}
//		
//		
//		return result;
//	}
		
		
		int b = 0, c= 0, d = 0;
		for (int i = 0; i < source.length; i++) {
			for (int j = 0; j < newData.length; j++) {
				if (newData[j] == source[i]) {
					result.inBoth[b++] = source[i];
					source[i] = 0;
					newData[j] = 0;
					break;
				}
			}
		}
		/**
		 * 遍历两个数组，将符合期望的元素分别传入onlyInSource和notInSource，并实现正数在前，0在后。
		 */
		
		for (int i = 0; i < source.length; i++) {
			if (source[i] != 0) {
				result.onlyInSource[c++] = source[i];
			}
		}
		
		for (int i = 0; i < newData.length; i++) {
			if (newData[i] != 0) {
				result.notInSource[d++] = newData[i];
			}
		}
		return result;}
}

class Result {
	int[] onlyInSource;
	int[] inBoth;
	int[] notInSource;
}