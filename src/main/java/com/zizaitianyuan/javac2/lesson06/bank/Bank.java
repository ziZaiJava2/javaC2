package com.zizaitianyuan.javac2.lesson06.bank;

import java.util.HashMap;
import java.util.Map;

public class Bank {
	private static Map<String, Account> accountMap = new HashMap<>();

	/**
	 * 注册新的银行账户
	 * 
	 * @param person
	 *            读取用户信息
	 * @param moneyNum
	 *            初始为0
	 * @return 返回一个新的Account对象
	 */
	public Account register(Person person) {
		Account account = new Account(person.getId(), 0);
		accountMap.put(person.getId(), account);
		return account;
	}
    /**
     * 
     * @param person 账户对象
     * @param moneyNum 用户准备存入多少钱
     * @return 返回是否成功
     */
	public boolean saveMoney(Person person, double moneyNum) {
		if (!accountMap.containsKey(person.getId())) {
			System.out.println("你未在本银行开户，请先开户");
			return false;
		} else if (person.getCashNum() < moneyNum) {
			System.out.println("现金不足！");
			return false;
		} else {
			accountMap.get(person.getMyAccount().getAccuontId()).setMoneyInAccount(moneyNum);
			person.setCashNum(person.getCashNum() - moneyNum);
			return true;
		}
	}
}
