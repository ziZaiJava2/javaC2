package com.shop.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class UseDatabase {
	private static final String URL = "jdbc:mysql://localhost:3306/shop_java?user=root&password=root";

	public void createTable(String tableName) {
		String sql="create table "+tableName+
				"(id int not null auto_increment,"
				+"name varchar(100) not null,"
				+"description text,"
				+"original_price DECIMAL(16, 4),"
				+"price DECIMAL(16, 4),"
				+"primary key(id)"+")";
		try {
			executeUpdate(sql);
		} catch (Exception e) {
			error(e);
		}
	}

	public void insert(String tableName,String name, String description, int original_price, int price) {
		String sql="insert into "+tableName+"(name,description,original_price,price,primary)values("
				+"'"+name+"'"+",'"+description+"',"+original_price+","+price+");";
		try {
			executeUpdate(sql);
		} catch (Exception e) {
			error(e);
		}
	}

	public void deleteTable(String tableName) {
		String sql = "drop table " + tableName;
		try {
			executeUpdate(sql);
		} catch (Exception e) {
			error(e);
		}
	}

	public void queryTable(String column, String tableName) {
		String sql = "select " + column + " from " + tableName;
		try {
			System.out.println(executeQuery(sql));
		} catch (Exception e) {
			error(e);
		}
	}

	private void error(Exception e) {
		System.out.println("sql执行失败");
		e.printStackTrace();
	}

	private Statement prepare() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL);
		Statement state = con.createStatement();
		return state;
	}

	private void executeUpdate(String sql) throws Exception {
		prepare().executeUpdate(sql);
	}

	private String executeQuery(String sql) throws Exception {
		ResultSet res = prepare().executeQuery(sql);
		return res.getString(0);
	}

}
