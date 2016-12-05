package com.zizaitianyuan.javac2.store.dto;

import java.sql.Date;

public class Order {
	
	private Date create_date;
	private String address;
	private String user_name;
	private String state;
	
	
	public String getState() {
		return state;
	}




	public void setState(String state) {
		this.state = state;
	}




	public Date getCreate_date() {
		return create_date;
	}




	public void setCreate_date(Date create_date) {
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




	
	
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
