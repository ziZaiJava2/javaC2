package com.zizaitianyuan.javac2.lesson06.bank;

public class Account {
	private String accountId;
	private double moneyInAccount;
	public Account(String accountId, double moneyInAccount){
		this.accountId = accountId;
		this.moneyInAccount = moneyInAccount;
	}
	public String getAccuontIn(){
		return accountId;
	}
	public double getMoneyInAccount(){
		return moneyInAccount;
		
	}
}
