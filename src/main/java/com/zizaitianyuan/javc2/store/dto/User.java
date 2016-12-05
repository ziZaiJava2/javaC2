package com.zizaitianyuan.javc2.store.dto;

public class User {
	private String name;
	private String nickName;
	private String email;
	private String adress;
	private double account;

	public User(String name, String nickName, String eamil, String adress, double account) {
		this.name = name;
		this.nickName = nickName;
		this.email = email;
		this.adress = adress;
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public double getAccount() {
		return account;
	}

	public void setAccount(double account) {
		this.account = account;
	}
}
