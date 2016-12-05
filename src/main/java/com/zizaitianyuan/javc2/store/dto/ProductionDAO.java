package com.zizaitianyuan.javc2.store.dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.junit.runner.Result;

import com.mysql.jdbc.PreparedStatement;

public class ProductionDAO {


	public static boolean addProduction(Production production) throws ClassNotFoundException, SQLException {
		String sql = "insert into production(name,discription,original_price,price)values(?,?,?,?)";
		java.sql.PreparedStatement pst = MysqlUtil.addMysql(sql);
		pst.setString(1, production.getName());
		pst.setString(2, production.getDescription());
		pst.setInt(3, production.getOriginalPrice());
		pst.setInt(4, production.getPrice());

		return pst.execute(sql);
	}

	public static boolean deleteProduction(Production production) throws ClassNotFoundException, SQLException {
		String sql = "delete from production where name = " + production.getName();
		Statement st = MysqlUtil.useMysql(sql);
		st.execute(sql);
		return false;
	}

	public static boolean updateProduction(Production production) throws ClassNotFoundException, SQLException {
		if(production.getName() != null && !"".equals(production.getName())) {
			String sql = "update production set name = " + production.getName() +" where id = " + production.getId();
			Statement st = MysqlUtil.useMysql(sql);
			return st.execute(sql);
		}else if(production.getDescription()!= null && !"".equals(production.getDescription())){
			String sql = "update production set description = " + production.getDescription() +" where id = " + production.getId();
			Statement st = MysqlUtil.useMysql(sql);
			return st.execute(sql);
		}else if(production.getOriginalPrice() != 0){
			String sql = "update production set originalPrice = " + production.getOriginalPrice() +" where id = " + production.getId();
			Statement st = MysqlUtil.useMysql(sql);
			return st.execute(sql);
		}else if(production.getPrice() !=0){
			String sql = "update production set Price = " + production.getPrice() +" where id = " + production.getId();
			Statement st = MysqlUtil.useMysql(sql);
			return st.execute(sql);
		}else{
			return false;
		}
		
	}

	public static List<String> getAllProduction() throws ClassNotFoundException, SQLException {
		List<String> productionList = new ArrayList<>();
		String sql = "select * from production";
		Statement st = MysqlUtil.useMysql(sql);
		ResultSet rt = st.executeQuery(sql);
		while(rt.next()){
			String name = rt.getString("name");
			String descciption = rt.getString("decription");
			String adress = rt.getString("adress");
			
		}
		return null;

	}

}
