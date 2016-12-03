package com.zizaitianyuan.javac2.bank00;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DJBC {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String url = "jdbc:mysql://localhost:3306/school?user=root&password=root";
		Class.forName("com.mysql.jdbc.Driver");
		
		Connection conn = null;
		Statement stmt = null;
		
		try{
			String sql1 = "select name from school.teacher;";
			String sql2;
			String sql3;
			
			conn = DriverManager.getConnection(url);
			stmt = conn.createStatement();
			conn.setAutoCommit(false);
			
			
			try{
				stmt.execute(sql1);
				stmt.execute(sql2);
				stmt.execute(sql3);
				conn.commit();
			}catch(SQLException e){
				conn.rollback();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			stmt.close();
			conn.close();
		}
	}

}
