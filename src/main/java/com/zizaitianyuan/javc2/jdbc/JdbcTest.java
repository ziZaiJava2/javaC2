package com.zizaitianyuan.javc2.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcTest {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
       String url = "jdbc:mysql://localhost:3306/mall?user=root&password=skyking";
       Class.forName("com.mysql.jdbc.Driver");
       Connection con = null;
       Statement s = null;
       try {
    	  
    	   String sql1 = "insert into user( name, nickname,email, adress, account)values( '任向杰1', '交作业的御用宠物', '11@qq.com', '上海电机学院', '20000')";
           String sql2 = "insert into user( name, nickname,email, adress, account)values( '任向杰2', '交作业的御用宠物', '11@qq.com', '上海电机学院', '20000')";
           String sql3 = "insert into user( name, nickname,email, adress, account)values( '任向杰3', '交作业的御用宠物', '11@qq.com', '上海电机学院', '20000')";

           con = DriverManager.getConnection(url);
		   s = con.createStatement();
		   con.setAutoCommit(false);
		   try{
		   s.execute(sql1);
		   s.execute(sql2);
		   s.execute(sql3);
		   
		   con.commit();
		   }catch(SQLException e){
			   con.rollback();
			   
		   }
//		 String sql3 = "select * from user";
//		 ResultSet rs =  s.executeQuery(sql3);
//		 while(rs.next()){
//			int stuId =  rs.getInt("id");
//			String stuName = rs.getNString("name");
//			String adress = rs.getNString("adress");
//			System.out.print(stuId + " "  + stuName + " " + adress);
//			System.out.println();
//		 }
	} catch (SQLException e) {
		e.printStackTrace();
	}finally{
		s.close();
		con.close();
	}
//		insertUser("skyking","hahah", "null","tiandi", 20000);
	}
//   public static void insertUser(String name,String nickname, String email,String adress, double account) throws ClassNotFoundException, SQLException{
//	   String url = "jdbc:mysql://localhost:3306/mall?user=root&password=skyking";
//       Class.forName("com.mysql.jdbc.Driver");
//       Connection con = null;
//	   String sql = "insert into user( name, nickname,email, adress, account)values( ?, ?, ?, ?, ?)";
//       PreparedStatement st = con.prepareStatement(sql);
//       st.setString(1, name);
//       st.setString(2, nickname);
//       st.setString(3, email);
//       st.setString(4, adress);
//       st.setDouble(5, account);
//       st.execute(sql);
//       con.close();
//       
//   }
}
