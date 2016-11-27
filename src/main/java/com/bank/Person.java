package com.bank;

public class Person {
	private String id;
	private String name;
	private double cashNum;
	private Account myAccount = null;

	public Person(String id, String name, double cashNum) {
		this.id = id;
		this.name = name;
		this.cashNum = cashNum;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCashNum(double cashNum) {
		this.cashNum = cashNum;
	}

	public void setAccount(Account myAccount) {
		this.myAccount = myAccount;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getCashNum() {
		return cashNum;
	}

	public Account getAccount() {
		return myAccount;
	}

	public void showMyMoney() {
		System.out.println("现金为" + getCashNum() + ",银行账户里有" + getAccount().getMoneyInAccount());
	}

}
