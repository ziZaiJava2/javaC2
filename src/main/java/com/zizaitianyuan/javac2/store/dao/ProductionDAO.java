package com.zizaitianyuan.javac2.store.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.zizaitianyuan.javac2.store.dto.Production;

public class ProductionDAO {
	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		String url = "jdbc:mysql://localhost:3306/store?user=root&password=120221136";
		Class.forName("com.mysql.jdbc.Diver");
		Connection con = null;
		Statement stat = null;
		try {
			String sql="";
			
			 con = DriverManager.getConnection(url);
			
			 stat=con.createStatement();
			
			stat.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			stat.close();
			con.close();
		}
	}

	
	
	// 当调用这个方法时， 会把Production 对象里的数据存到数据库中
	private void addProduction(Production production){
		String sql = "insert into production(name,description,original_price,price)values()";
	}

	// 当调用这个方法时， 根据productionId 删除对应数据库中数据
	private void deleteProduction(int productionId) {
       
	}

	// 当调用这个方法时，根据productionId 更改 production对象里的数据到对应的数据库中
	private void updateProduction(Production production) {

	}

	// 通过给定的产品id 去数据库查找对应数据， 返回值是一个会把Production 对象
	private void getProduction(int productionId) {

	}

	// 查找所有的商品， 方法返回值是一个 list
	private void getAllProduction() {

	}
}
