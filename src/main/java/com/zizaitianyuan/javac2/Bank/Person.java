package com.zizaitianyuan.javac2.Bank;

/**
 * Created by SPIDER on 2017/6/30.
 */
public class Person {

  private String id;
  private String name;
  private double cashNum;
  private Account myAccount;

  public Person(String id, String name, double cashNum) {
    this.id = id;
    this.name = name;
    this.cashNum = cashNum;
    this.myAccount = null;
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

  public Account getMyAccount() {
    return myAccount;
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

  public void setMyAccount(Account myAccount) {
    this.myAccount = myAccount;
  }

  public void showMyMoney() {
    System.out.println("cash:" + getCashNum());
    System.out.println("moneyInAccount:" + getMyAccount().getMoneyInAccount());
  }
}
