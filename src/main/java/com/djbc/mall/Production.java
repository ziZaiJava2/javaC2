package com.djbc.mall;

import java.util.Scanner;

public class Production {
	private int stuId;
	private String name;
	private String description;
	private double original_price;
	private double price;

	public int getStuId() {
		return stuId;
	}

	public void setStuId(int stuId) {
		this.stuId = stuId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getOriginal_price() {
		return original_price;
	}

	public void setOriginal_price(double original_price) {
		this.original_price = original_price;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public static Production getProduction(){
		Scanner in = new Scanner(System.in);
		Production production = new Production();
		System.out.println("请输入production的name：");
		production.setName(in.next());
		System.out.println("请输入production的description");
		production.setDescription(in.next());
		System.out.println("请输入production的original_price：");
		production.setOriginal_price(in.nextDouble());
		System.out.println("请输入production的price：");
		production.setPrice(in.nextDouble());
		in.close();
		
		return production;
	}

	public String toString() {
		String A = String.format("id:%d, name:%s, description:%s, original_price:%d, price:%d", stuId, name,
				description, original_price, price);
		return A;
	}
}
