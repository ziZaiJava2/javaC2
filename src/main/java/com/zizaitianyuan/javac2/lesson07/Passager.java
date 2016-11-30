package com.zizaitianyuan.javac2.lesson07;

public class Passager {

	private String name;
	private String gender;
	
	private String id;
	
	public Passager(String id, String name, String gender) {
		this.id = id;
		this.name = name;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public String getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "{" + this.name + ", " + this.gender + ", " + this.id + "}"; 
	}
}
