package com.djbc.mall;

public class MyThread extends Thread{
	
	public void run(){
		System.out.println("偶啊");
	}
	
	public static void main(String[] args) {
		Thread mythread1 = new MyThread();
		Thread mythread2 = new MyThread();
		mythread1.start();
		mythread2.start();
	}
}
