package com.zizaitianyuan.javac2.store.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {
	private static final String URL="jdbc:mysql://localhost:3306/online_shopping";
	private static final String NAME="root";
	private static final String PASSWORD="120221136";
	

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//1.加載驅動程序
		Class.forName("com.mysql.jdbc.Driver");
		//2.連接數據庫
		Connection conn=  DriverManager.getConnection(URL, NAME, PASSWORD);
	    //3.通過數據庫的連接操作數據庫，實現增刪改查
		Statement stmt =  conn.createStatement();
		ResultSet rs= stmt.executeQuery("select name from production");
		
		while(rs.next()){
			System.out.println(rs.getString("name"));
		}
	}    

}



