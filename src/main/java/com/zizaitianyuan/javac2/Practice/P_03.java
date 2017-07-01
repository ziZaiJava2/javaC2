package com.zizaitianyuan.javac2.Practice;

/**
 * Created by SPIDER on 2017/7/1.
 */
public class P_03 {

  static final int max = 5;

  public static void main(String[] args) {
    result r = new result();
    int[] a = {1, 3, 6, 9};
    int[] b = {3, 9, 11, 21};
    check(r, a, b);
    System.out.print("inBoth:");
    for (int i = 0; i < max; i++) {
      if (r.inBoth[i] != Integer.MAX_VALUE) {
        System.out.print(r.inBoth[i] + " ");
      }
    }
    System.out.print("\nonlyInSource:");
    for (int i = 0; i < max; i++) {
      if (r.onlyInSource[i] != Integer.MAX_VALUE) {
        System.out.print(r.onlyInSource[i] + " ");
      }
    }
    System.out.print("\nnotInSource:");
    for (int i = 0; i < max; i++) {
      if (r.notInSource[i] != Integer.MAX_VALUE) {
        System.out.print(r.notInSource[i] + " ");
      }
    }
  }

  public static void check(result r, int[] a, int[] b) {
    r.inBoth = new int[max];
    r.notInSource = new int[max];
    r.onlyInSource = new int[max];
    for (int i = 0; i < max; i++) {
      r.inBoth[i] = Integer.MAX_VALUE;
      r.notInSource[i] = Integer.MAX_VALUE;
      r.onlyInSource[i] = Integer.MAX_VALUE;
    }
    int i, j;
    for (i = 0; i < a.length; i++) {
      for (j = 0; j < b.length; j++) {
        if (a[i] == b[j]) {
          r.inBoth[i] = a[i];
          break;
        }
      }
      if (j == b.length) {
        r.onlyInSource[i] = a[i];
      }
    }
    for (i = 0; i < b.length; i++) {
      for (j = 0; j < max; j++) {
        if (b[i] == r.inBoth[j]) {
          break;
        }
      }
      if (j == max) {
        r.notInSource[i] = b[i];
      }
    }
  }
}

class result {

  int[] onlyInSource;
  int[] inBoth;
  int[] notInSource;
}