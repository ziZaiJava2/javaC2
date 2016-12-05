package com.zizaitianyuan.javac2.store.dto;

import java.util.Date;

public class Orders {
	private Date create_date;
	private String address;
	private String user_name;
	private String ispay;

	public String getIsPay() {
		return ispay;
	}

	public void setIsPay(String isPay) {
		this.ispay = isPay;
	}

	public Date getCreate_Date() {
		return create_date;
	}

	public void setCreate_Date(Date create_date) {
		this.create_date = create_date;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

}
