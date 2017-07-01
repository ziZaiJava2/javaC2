package com.zizaitianyuan.luozheng;

import java.util.HashMap;
import java.util.Map;

import com.zizaitianyuan.luozheng.Account;

public class Bank {// Bank.class ��������
	Map<Person, Account> accountMap = new HashMap<Person, Account>();

	public Account register(Person person) {
		Account a = new Account(person.id, 0);
		person.myAccount = a;
		accountMap.put(person, a);
		return a;
	}

	public boolean saveMoney(Person person, double moneyNum) {
		if (accountMap.containsKey(person)) {
			if (person.cashNum >= moneyNum) {
				accountMap.get(person).moneyInAccount += moneyNum;
				person.cashNum -= moneyNum;
				return true;
			} else {
				System.out.println("�ֽ��㣡");
				return false;
			}
		} else {
			System.out.println("����ע�������˻�!");
			return false;
		}

	}

}
