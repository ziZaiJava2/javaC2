package com.zizaitianyuan.javac2.store.dto;

public class Production {
	private String name;
	private String description;
	private int original_price;
	private int price;

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

	public int getOriginal_price() {
		return original_price;
	}

	public void setOriginal_price(int original_price) {
		this.original_price = original_price;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
