package com.zizaitianyuan.javac2.lesson06.bank;

public class Account {
	private String accountId;
	private double moneyInAccount;

	public Account(String accountId, double moneyInAccount) {
		this.accountId = accountId;
		this.moneyInAccount = moneyInAccount;
	}

	public String getAccuontId() {
		return accountId;
	}

	public double getMoneyInAccount() {
		return moneyInAccount;
	}

	public void setAccountId(String id) {
		this.accountId = id;
	}

	public void setMoneyInAccount(double money) {
		this.moneyInAccount = money;
	}
}
