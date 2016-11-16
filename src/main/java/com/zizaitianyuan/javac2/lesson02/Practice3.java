package com.zizaitianyuan.javac2.lesson02;

public class Practice3 {

	private static int MAX_SIZE = 5;

	
	/**
	 * 
	 * 传入两个***有序***的不重复的正整数数组(都大于０)，两个数组的整数个数小于5个
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


	/**
	 * 
	 * 传入两个***有序***的正整数数组(都大于０)，两个数组的整数个数小于5个
	 * 
	 * 这是我近期工作中碰到的，也是以前同事刚刚碰到的一个实际工作中的问题，这个问题 我们之后还会拿出来几次使用不同的解法来说明一些写代码要注意的问题。
	 * 
	 * 今天我们用最笨的方法来解决。如果能提供多个解法也可以。
	 * 
	 * 写一个程序： 将两个数组都含有的元素放入result.inBoth中；
	 * 将第一个数组有，第二个数组没有的元素放入result.onlyInSource中；
	 * 将第二个数组有，但是第一个数组中没有的元素放入result.notInSource中
	 * 
	 * 例如 source = [1, 3, 6, 9] newData = [3, 9, 11, 21]
	 * 
	 * 那么返回的结果 result.onlyInsource = [1, 6, 0, ...] result.inBoth = [3, 9, 0,
	 * ...] result.notInSource = [11, 21, 0, ...]
	 * 
	 * 
	 * 写完之后，在eclipse中左边选中src/test/java/.../Practice3Test.java这个文件，右键 -> Run as
	 * -> JUnit Test

	 * 
	 * 如果执行没有错误的话，就说明写对了。
	 * 
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

		for (int i = 0; i < source.length; i++) {
			int j;
			for (j = 0; j < newData.length; j++) {
				if (source[i] == newData[j]) {
					result.inBoth[i] = source[i];
					break;
				}
                       System.out.println();
			}

			if (j == 5) {
				result.onlyInSource[i] = source[i];
			}

		}
		for (int i = 0; i < newData.length; i++) {
			int j = 0;
			for (j = 0; j < source.length; j++) {
				if (source[i] == newData[j]) {
					continue;
				}
				if (j == 5) {
					result.onlyInSource[i] = newData[i];
				}
			}

		}

		return result;
	}
}


	class Result {
		int[] onlyInSource;
		int[] inBoth;
		int[] notInSource;
	}


