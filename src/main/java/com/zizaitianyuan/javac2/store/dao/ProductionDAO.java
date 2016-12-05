package com.zizaitianyuan.javac2.store.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zizaitianyuan.javac2.store.dto.Production;

public class ProductionDAO {
	private static final String URL = "jdbc:mysql://localhost:3306/store?user=root&password=root";
	private PreparedStatement preState = null;

	/**
	 * 向商品表中添加数据
	 */
	public void addProduction(Production production) {
		String sql = "insert into production (name,description,original_price,price)values(?,?,?,?);";
		try {
			preState = PrepareUtils.prepare(URL, sql);
			preState.setString(1, production.getName());
			preState.setString(2, production.getDescription());
			preState.setInt(3, production.getOriginal_price());
			preState.setInt(4, production.getPrice());
			preState.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			tellError(e);
		} finally {
			try {
				preState.close();
				PrepareUtils.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 删除商品表
	 */
	public void deleteProduction() {
		String sql = "drop table production";
		try {
			preState = PrepareUtils.prepare(URL, sql);
			preState.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			tellError(e);
		} finally {
			try {
				preState.close();
				PrepareUtils.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 更新指定表的指定列
	 * 
	 * @param tableName
	 * @param column
	 * @param change
	 */
	public void updateProduction(String column, String change, int id) {
		String sql = "update production set ?=? where id=?";
		try {
			preState = PrepareUtils.prepare(URL, sql);
			preState.setString(1, column);
			preState.setString(2, change);
			preState.setInt(3, id);
			preState.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			tellError(e);
		} finally {
			try {
				preState.close();
				PrepareUtils.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 获得指定商品对象
	 * 
	 * @param usersId
	 * @return
	 */
	public Production getProduction(int productionId) {
		Production selectProduction = new Production();
		String sql = "select name,description,original_price,price from production where id=?";
		try {
			preState = PrepareUtils.prepare(URL, sql);
			preState.setInt(1, productionId);
			ResultSet res = preState.executeQuery();
			selectProduction.setName(res.getString("name"));
			selectProduction.setDescription(res.getString("description"));
			selectProduction.setOriginal_price(res.getInt("original_price"));
			selectProduction.setPrice(res.getInt("price"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			tellError(e);
		} finally {
			try {
				preState.close();
				PrepareUtils.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return selectProduction;
	}

	/**
	 * 获得商品表所有商品名
	 * 
	 * @return
	 */
	public List<String> getAllProduction() {
		String sql = "select name from production";
		List<String> productionList = new ArrayList<>();
		try {
			preState = PrepareUtils.prepare(URL, sql);
			ResultSet res = preState.executeQuery();
			while (res.next()) {
				productionList.add(res.getString("name"));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			tellError(e);
		} finally {
			try {
				preState.close();
				PrepareUtils.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return productionList;
	}

	private void tellError(Exception e) {
		System.out.println("数据库命令执行失败");
		e.printStackTrace();
	}
}
