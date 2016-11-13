package com.zizai.main;

import java.util.Random;
import java.util.Scanner;

public class NumberGuess {

	public static void main(String[] args) {
		
			//随机生产一个0~9数字  random.nextInt(9)  中9代表生成数字的范围
			Random random = new Random();
			int number = random.nextInt(9);
						
			//在控制台输出一句话，内容是括号里的内容
			System.out.println("请输入一个0~9的数字：");
			
			//监听控制台输入
			Scanner reader = new Scanner(System.in);
			//把控制台输入保存给一个变量
			int userInputNum = reader.nextInt();
			
			//判断语句if后面的括号是判断的条件，如果条件是真的就会走if后面大括号里的内容
			//如果判断调价是假的话，就会走else大括号的内容
			if(number == userInputNum){
				System.out.println("恭喜你答对了");
			}else{
				System.out.println("抱歉答错了！\n正确答案是："+number);
			}
	}

}
