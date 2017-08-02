package store.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import store.dto.Order;

import store.dto.Production;

public class OrderDAO {

	public static void main(String[] args) {
		Order o = new Order();
		o.setOrderId(1);
		o.setCustomerId(2);
		o.setProductionsId(2);
		o.setAmount(1);
		o.setTotal(73);
		o.setState("未支付");
		//addOrder(o);
		//updateOrder(o);
		//getOrder(1);
		//getAllOrder();
		//deleteOrder(1);
	}
	static Scanner reader = new Scanner (System.in);
	public static void addOrder(Order order) {
		try {
			String url = "jdbc:mysql://localhost:3306/store?user=root&password=root";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url);
			PreparedStatement ps = con
					.prepareStatement("insert orders (customer_id,productions_id,amount,total,state)values(?,?,?,?,?)");
			ps.setInt(1, order.getCustomerId());
			ps.setInt(2, order.getProductionsId());
			ps.setInt(3, order.getAmount());
			ps.setDouble(4, order.getTotal());
			ps.setString(5, order.getState());
			ps.execute();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteOrder(int orderId) {
		try {
			String url = "jdbc:mysql://localhost:3306/store?user=root&password=root";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url);
			PreparedStatement ps = con.prepareStatement("delete from orders where order_id = ?");
			ps.setInt(1, orderId);
			ps.execute();
			ps.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public static void updateOrder(Order order) {
		try {
			String url = "jdbc:mysql://localhost:3306/store?user=root&password=root";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url);
			PreparedStatement ps = con.prepareStatement("update orders set state = ? where order_id = ?");
			System.out.print("交易状态:" + order.getState() + "确认付款了可输入已支付修改交易状态:");
			String change = reader.nextLine();
			ps.setString(1, change);
			ps.setInt(2, order.getOrderId());
			ps.execute();
			ps.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public static Order getOrder(int orderId) {
		Order o = new Order();
		try {
			String url = "jdbc:mysql://localhost:3306/store?user=root&password=root";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url);
			PreparedStatement ps = con.prepareStatement("select * from orders where order_id = ?");
			ps.setInt(1, orderId);
			ResultSet rs = ps.executeQuery();
			o = (Order) rs;
			ps.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return o;

	}
	
	public static List<Order> getAllOrder() {
		List<Order> l = new ArrayList<Order>();
		try {
			String url = "jdbc:mysql://localhost:3306/store?user=root&password=root";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url);
			PreparedStatement ps = con.prepareStatement("select * from orders");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				l.add((Order)rs);
			}
			ps.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return l;

	}
	
}
