package com.zizaitianyuan.javac2.lesson06.bank;

public class BankUse {
	public static void main(String[] args) {
		Person person1 = new Person("123456", "贾瑞", 10000);
		Person person2 = new Person("123456789", "梁教官", 500000);
		Person person3 = new Person("123456789123", "高程", 800000);
		Bank icbc = new Bank();
		person1.setMyAccount(icbc.register(person1));
		person2.setMyAccount(icbc.register(person2));
		person3.setMyAccount(icbc.register(person3));
		System.out.println("是否成功: " + icbc.saveMoney(person1, 5000));
		System.out.println("是否成功: " + icbc.saveMoney(person2, 100000));
		System.out.println("是否成功: " + icbc.saveMoney(person3, 500000));
		person1.showMyMoney();
		person2.showMyMoney();
		person3.showMyMoney();
	}
}
