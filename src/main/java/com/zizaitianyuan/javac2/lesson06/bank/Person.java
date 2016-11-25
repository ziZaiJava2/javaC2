package com.zizaitianyuan.javac2.lesson06.bank;

public class Person {
	private String id;
	private String name;
	private double cashNum;
	private Account myAccuont = null;

	public Person(String id, String name, double cashNum) {
		this.id = id;
		this.name = name;
		this.cashNum = cashNum;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setCashNum(double cashNum) {
		this.cashNum = cashNum;
	}

	public double getCashNum() {
		return cashNum;
	}

	public Account getMyAccount() {
		return myAccuont;
	}

	public void setMyAccount(Account account) {
		this.myAccuont = account;
	}

	public void showMyMoney() {
		System.out.println(name + " " + "现金：" + cashNum);
	}
}
