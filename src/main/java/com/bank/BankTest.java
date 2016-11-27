package com.bank;

public class BankTest {
	public static void main(String[] args) {
		Person person1 = new Person("110", "Tom", 10000);
		Person person2 = new Person("120", "Jerry", 500000);
		Person person3 = new Person("119", "Mary", 800000);
		Bank icbc = new Bank();
		regis(icbc, person1);
		regis(icbc, person2);
		regis(icbc, person3);
		icbc.saveMoney(person1, 5000);
		icbc.saveMoney(person2, 100000);
		icbc.saveMoney(person3, 500000);
		person1.showMyMoney();
		person2.showMyMoney();
		person3.showMyMoney();
	}

	private static void regis(Bank bank, Person person) {
		bank.register(person);
	}
}
