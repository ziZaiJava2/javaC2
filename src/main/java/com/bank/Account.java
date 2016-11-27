package com.bank;

public class Account {
	private String accountId;
	private double moneyInAccount;

	public Account(String accountId, double moneyInAccount) {
		this.accountId = accountId;
		this.moneyInAccount = moneyInAccount;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public double getMoneyInAccount() {
		return moneyInAccount;
	}

	public void setMoneyInAccount(double moneyInAccount) {
		this.moneyInAccount = moneyInAccount;
	}

}
