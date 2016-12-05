package com.zizaitianyuan.javc2.store.dto;

public class Production {
	private String name;
	private String description;
	private int originnalPrice;
	private int price;
    private int id;
	public Production(String name, String description, int originalPrice, int price, int id) {
		this.name = name;
		this.description = description;
		this.originnalPrice = originalPrice;
		this.price = price;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getOriginalPrice() {
		return originnalPrice;
	}

	public void setOriginalPrice(int originnalPrice) {
		this.originnalPrice = originnalPrice;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
