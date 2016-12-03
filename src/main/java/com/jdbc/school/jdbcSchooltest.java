package com.jdbc.school;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class jdbcSchooltest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// URL 格式
		// jdbc:<dbType>://<host>:<port>/<databaseName>?user=<userName>&password=<password>
		String url = "jdbc:mysql://localhost:3306/student?user=root&password=3610";

		// 与mysql connection driver 的类建立关系并初始化该驱动类
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = null;
		Statement stat = null;
		// 通过DriverManager 与数据库建立一个链接

		try {
			String sql = "insert into student(name,location) values('liangshaohaun','sdfsdf')";
			conn = DriverManager.getConnection(url);
			stat = conn.createStatement();
			stat.execute(sql);
			
			
			String querySql = "select * from student";
			ResultSet rs = stat.executeQuery(querySql);
			while (rs.next()) {
				int stuid =	rs.getInt("id");
				String name = rs.getString("name");
				String location = rs.getString("location");
				System.out.println(String.format("id: %d, name: %s, location %b",stuid , name, location));		
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			stat.close();
			conn.close();
		}

	}

}