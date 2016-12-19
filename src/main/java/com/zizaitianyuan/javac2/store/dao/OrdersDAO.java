package com.zizaitianyuan.javac2.store.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zizaitianyuan.javac2.store.dto.Orders;

public class OrdersDAO implements TAG {
	private static final String URL = "jdbc:mysql://localhost:3306/store?user=root&password=root";
	private PreparedStatement preState = null;

	/**
	 * 向订单表中添加数据
	 */
	public void addOrders(Orders orders) {
		String sql = "insert into orders (create_date,address,user_name,ispay)values(?,?,?,?);";
		try {
			preState = PrepareUtils.prepare(URL, sql);
			Date create_date = new Date(orders.getCreate_Date().getTime());
			preState.setDate(1, create_date);
			preState.setString(2, orders.getAddress());
			preState.setString(3, orders.getUser_name());
			preState.setString(4, orders.getIsPay());
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
	 * 删除订单表
	 */
	public void deleteOrders(String userName) {
		String sql = "delete from orders where user_name='" + userName + "'";
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
	public void update(String change, String name) {
		String sql = "update orders set ispay=? where user_name=?";
		try {
			preState = PrepareUtils.prepare(URL, sql);
			preState.setString(1, change);
			preState.setString(2, name);
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
	 * 获得指定订单对象
	 * 
	 * @param usersId
	 * @return
	 */
	public Orders getOrders(int ordersId) {
		Orders selectOrders = new Orders();
		String sql = "select create_date,address,user_name,ispay from Orders where id=?";
		try {
			preState = PrepareUtils.prepare(URL, sql);
			preState.setInt(1, ordersId);
			ResultSet res = preState.executeQuery();
			while (res.next()) {
				selectOrders.setCreate_Date(res.getDate("create_date"));
				selectOrders.setAddress(res.getString("address"));
				selectOrders.setUser_name(res.getString("user_name"));
				selectOrders.setIsPay(res.getString("ispay"));

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
		return selectOrders;
	}

	/**
	 * 获得订单表所有用户名
	 * 
	 * @return
	 */
	public List<String> getAllOrders() {
		String sql = "select user_name from orders";
		List<String> nameList = new ArrayList<>();
		try {
			preState = PrepareUtils.prepare(URL, sql);
			ResultSet res = preState.executeQuery();
			while (res.next()) {
				nameList.add(res.getString("user_name"));
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
		return nameList;
	}

	private void tellError(Exception e) {
		System.out.println("数据库命令执行失败");
		e.printStackTrace();
	}
}
