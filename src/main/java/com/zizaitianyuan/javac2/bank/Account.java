package com.zizaitianyuan.javac2.bank;

public class Account {
	//定义账户号和存款金额的成员变量
	String accountId;
	double moneyInAccount;
	//定义一个有两个参数的构造方法
	public Account(String accountId,double moneyInAccount){
		this.setAccountId(accountId);
		this.setMoneyInAccount(moneyInAccount);
	}
	//main函数
	
    
	//获取账户号码
	public String getAccountId() {
		
		return accountId;
	}
     //给账户设置一个账号
	public void setAccountId(String accountId) {
		
		this.accountId = accountId;
	}
	//获取账户内存款金额
	public double getMoneyInAccount(){
		
		return moneyInAccount;
	}
	//设置存款金额
	public void setMoneyInAccount(double cashNum){
		
		this.moneyInAccount=moneyInAccount+cashNum;
	}
}
