package com.zizaitianyuan.javac2.Bank;

/**
 * Created by SPIDER on 2017/6/30.
 */
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

  public double getMoneyInAccount() {
    return moneyInAccount;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public void setMoneyInAccount(double moneyInAccount) {
    this.moneyInAccount = moneyInAccount;
  }
}
