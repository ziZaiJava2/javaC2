package com.zizaitianyuan.javac2.lesson07;

public class Passager {

	private String name;
	private String gender;
	private String id;

	public Passager(String id,String name,String gender){
		this.id = id;   //this的作用
		this.name = name;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
    @Override
    public String toString(){
    	return "[" + this.name + " , " + this.name + " , " + this.id + "]";
    }
}
