package com.zizaitianyuan.javac2.jdbd.school;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SchoolJdbcTset {

	
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		String url="jdbc:mysql://localhost:3306/school2?user=root&password=120221136";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = null;
		Statement stat = null;
		try {
			String sql1="insert into student(name,class)values('hu ll','class 4')";
			String sql2="insert into student(name,class,test)values('hu ll','class 4','test')";
			String sql3="insert into student(name,class)values('hu ll','class 4')";
			con = DriverManager.getConnection(url);
			stat =con.createStatement();
			con.setAutoCommit(false);
			//stat.execute(sql);
			try{
				stat.execute(sql1);
				stat.execute(sql2);
				stat.execute(sql3);
				
				con.commit();//及格sql语句同时失败
			}catch(SQLException e){
				con.rollback();//將沒提交的信息儲存回上面的execute
			}
			
			String querysql="select*from student";
			ResultSet rs=stat.executeQuery(querysql);
			while(rs.next()){
			int student_id=	rs.getInt("id");
			String name=rs.getString("name");
			System.out.printf(" id:%d name:%s",student_id,name);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			stat.close();
			con.close();
		}
	}
	public void insertStudent(String name) throws ClassNotFoundException, SQLException{
		String url="jdbc:mysql://localhost:3306/school2?user=root&password=120221136";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = null;
		String sql="insert into student(name)values(?)";
		PreparedStatement stat=con.prepareStatement(sql);//傳入動態參數
		stat.setString(1, name);
		stat.execute();
		//java.sql.Date
		//stat.setDate
		//String sql="insert into student(name)values('"+name);
	}

}
