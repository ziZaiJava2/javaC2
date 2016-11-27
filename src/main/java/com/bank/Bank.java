package com.bank;

import java.util.HashMap;
import java.util.Map;

public class Bank {
	private Map<String, Account> accountMap = new HashMap<>();

	public Account register(Person person) {
		Account account = new Account(person.getId(), 0);
		person.setAccount(account);
		accountMap.put(person.getId(), account);
		return account;
	}

	public boolean saveMoney(Person person, double moneyNum) {
		if (person.getAccount() == null) {
			System.out.println("请先注册银行账户");
			return false;
		} else if (person.getCashNum() < moneyNum) {
			System.out.println("现金不足");
			return false;
		} else {
			Account account = accountMap.get(person.getId());
			account.setMoneyInAccount(moneyNum);
			person.setCashNum(person.getCashNum() - moneyNum);
			return true;
		}
	}
}
