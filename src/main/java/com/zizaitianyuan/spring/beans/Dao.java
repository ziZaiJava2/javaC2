package com.zizaitianyuan.spring.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("dao")
public class Dao {
	
	private String database;
	

	public String getDatabase() {
		return database;
	}



	@Value("Oracle")
	public void setDatabase(String database) {
		this.database = database;
	}



	@Override
	public String toString() {
		return  String.format("dao(%s %s)", super.toString(), database);
	}
}
