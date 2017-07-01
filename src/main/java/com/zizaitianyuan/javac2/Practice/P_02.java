package com.zizaitianyuan.javac2.Practice;

import java.util.*;

/**
 * Created by SPIDER on 2017/7/1.
 */
public class P_02 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int[] result = fibonacci(n);
    for (int i = 0; i < result.length; i++) {
      System.out.print(result[i] + " ");
    }
  }

  public static int[] fibonacci(int n) {
    int[] temp = new int[n];
    temp[0] = temp[1] = 1;
    for (int i = 2; i < temp.length; i++) {
      temp[i] = temp[i - 1] + temp[i - 2];
    }
    return temp;
  }
}
