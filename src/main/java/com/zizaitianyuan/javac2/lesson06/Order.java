package com.zizaitianyuan.javac2.lesson06;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {

	private Date createTime;
	
	private int id;
	
	private String owner;
	
	private Date deliveryDate;
	
	public Order(Date createTime, int id, String owner, Date deliveryDate) {
		this.createTime = createTime;
		this.id = id;
		this.owner = owner;
		
		this.deliveryDate = deliveryDate;
	}
	
	public Order(Date createTime, int id, String owner) {
		this(createTime, id, owner, null);
	}
	
	
	public static void main(String[] args) {
		
		Order o = new Order(new Date(), 1, "Kai");
	}
	
	public void test(){
		// List list = new ArrayList();
		// List<Object> list = new ArrayList<Object>();
		
		List<String> mylist = new ArrayList();
		mylist.add("test");
		String testStr = mylist.get(0);
		
	}
}
