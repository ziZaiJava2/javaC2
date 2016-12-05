package com.zizaitianyuan.javc2.store.dto;

import java.util.Date;

public class Order {
	private int userId;
	private boolean isPay = false;
	private String adress;
	private Date date;

	public Order(int userId, boolean isPay, String adress, Date date) {
		this.userId = userId;
		this.isPay = isPay;
		this.adress = adress;
		this.date = date;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public boolean isPay() {
		return isPay;
	}

	public void setPay(boolean isPay) {
		this.isPay = isPay;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
