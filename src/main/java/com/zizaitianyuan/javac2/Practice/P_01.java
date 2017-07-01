package com.zizaitianyuan.javac2.Practice;

import java.util.*;

/**
 * Created by SPIDER on 2017/7/1.
 */
public class P_01 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= (2 * n - 1); j++) {
        if (j <= n - i) {
          System.out.print(" ");
        } else if (j < n + i) {
          System.out.print("*");
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
    for (int i = n - 1; i > 0; i--) {
      for (int j = 1; j <= (2 * n - 1); j++) {
        if (j <= n - i) {
          System.out.print(" ");
        } else if (j < n + i) {
          System.out.print("*");
        } else {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
  }
}
