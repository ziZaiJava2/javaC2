package com.zizaitianyuan.javc2.store.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlUtil {
	
	public static PreparedStatement addMysql(String sql) throws ClassNotFoundException, SQLException{
		String url = "jdbc:mysql://localhost:3306/online_shopping?user=root&password=skyking";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url);
		PreparedStatement ps = con.prepareStatement(sql);
		return ps;
	}
	
	public static Statement useMysql(String sql) throws ClassNotFoundException, SQLException{
		String url = "jdbc:mysql://localhost:3306/online_shopping?user=root&password=skyking";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(url);
		Statement st = con.createStatement();
		return st;
		
	}
}
