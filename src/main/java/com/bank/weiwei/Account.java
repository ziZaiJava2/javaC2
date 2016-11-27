package com.bank.weiwei;

public class Account {

	private String accountId;				//账户号
	private double moneyInAccount;			//存款金额
	
	public Account(String accountId, double moneyInAccount) {
		this.setAccountId(accountId);
		this.setMoneyInAccount(moneyInAccount);
	} 
	
	//给账户设置一个账号
	public void setAccountId(String accountId){
		this.accountId = accountId;
	}
	
	//获取账户的账号
	public String getAccountId() {
		return this.accountId;
	}
	
	//设置账户内的存款金额
	public void setMoneyInAccount(double moneyInAccount) {
		this.moneyInAccount = moneyInAccount;
	}
	
	//获取账户内的存款金额
	public double getMoneyInAccount() {			
		return this.moneyInAccount;
	}
	
	
	
}

