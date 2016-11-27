package com.bank;

//String accountId: 账户号。

//double moneyInAccount： 存款金额

public class Account {
	private String accountId; // 账户号
	double moneyInAccount; // 存款金额

	// 构造方法
	// 需要自己写一个两个参数的构造方法， 参数分别为 accountId, moneyInAccount
	public Account(String id, double money) {
		this.accountId = id;
		this.moneyInAccount = money;
	}

	// 方法
	// 为每个成员变量写对应的getter和setter方法。
	// 先练习手写，不要用eclipse生成，这一点用eclipse生成很简单，但是自己手写很多人不一定会写。

	// String getAccountId（） 获取账户号码,
	public String getAccountId() {
		return this.accountId;
	}

	// void setAccountId（String accountId） 给账户设置一个账号
	public void setAccound(String accountId) {
		this.accountId = accountId;
	}

	// double getMoneyInAccount（） 获取账户内存款金额,
	public double getMoneyInAccount() {
		return this.moneyInAccount;
	}

	// 向账户存款
	// void setMoneyInAccount（double moneyInAccount） 设置存款金额
	public void setMoneyInAccount(double setMoney) {
		this.moneyInAccount += setMoney;
	}

}
