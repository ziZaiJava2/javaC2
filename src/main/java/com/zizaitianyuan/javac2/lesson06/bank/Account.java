package com.zizaitianyuan.javac2.lesson06.bank;

public class Account {
	private String accountId;
	private double moneyInAccount;

	public Account(String accountId, double moneyInAccount) {
		this.accountId = accountId;
		this.moneyInAccount = moneyInAccount;
	}

	/**
	 * 返回用户id
	 * 
	 * @return
	 */
	public String getAccuontId() {
		return accountId;
	}

	/**
	 * 返回用户在账户里面的钱数值
	 * 
	 * @return
	 */
	public double getMoneyInAccount() {
		return moneyInAccount;
	}

	/**
	 * 设置银行账户
	 * 
	 * @param id
	 */
	public void setAccountId(String id) {
		this.accountId = id;
	}

	/**
	 * 向账户里面存钱
	 * 
	 * @param money
	 */
	public void setMoneyInAccount(double money) {
		this.moneyInAccount = money;
	}
}
