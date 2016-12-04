package com.zizaitianyuan.javac2.jdbd.school;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc {

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		String url="jdbc:mysql://localhost:3306/school2?user=root&password=root";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = null;
		Statement stat = null;
		try {
			String sql="insert into student(name',class)values('hu ll','class 4')";
			con = DriverManager.getConnection(url);
			stat =con.createStatement();
			stat.execute(sql);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			stat.close();
			con.close();
		}
	}

}
