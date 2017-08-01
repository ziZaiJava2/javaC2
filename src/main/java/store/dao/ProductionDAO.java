package store.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import store.dto.Production;

public class ProductionDAO {
	static Scanner reader = new Scanner(System.in);

	public static void main(String args[]) {
		/*
		 * Production p1 = new Production(); p1.setName("小黄书");
		 * p1.setDescription("徐徐最爱的上海鸭王传"); p1.setOriginal_price(100.0);
		 * p1.setPrice(99.9); Production p2 = new Production();
		 * p2.setName("java高级程序设计"); p2.setDescription("即使看不懂也确实是本好书");
		 * p2.setOriginal_price(79.9); p2.setPrice(72); addProduction(p1);
		 * addProduction(p2); deleteProduction(1); updateProduction(p2);
		 */
		System.out.println(getProduction(2));
		System.out.println(getAllProduction());

	}

	public static void addProduction(Production production) {
		try {
			String url = "jdbc:mysql://localhost:3306/store?user=root&password=root";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url);
			PreparedStatement ps = con
					.prepareStatement("insert production (name,description,original_price,price)values(?,?,?,?)");
			ps.setString(1, production.getName());
			ps.setString(2, production.getDescription());
			ps.setDouble(3, production.getOriginal_price());
			ps.setDouble(4, production.getPrice());
			ps.execute();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteProduction(int productionId) {
		try {
			String url = "jdbc:mysql://localhost:3306/store?user=root&password=root";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url);
			PreparedStatement ps = con.prepareStatement("delete from production where id = ?");
			ps.setInt(1, productionId);
			ps.execute();
			ps.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public static void updateProduction(Production production) {
		try {
			String url = "jdbc:mysql://localhost:3306/store?user=root&password=root";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url);
			PreparedStatement ps = con.prepareStatement("update production set price = ? where name = ?");
			System.out.print("原价格为" + production.getPrice() + "请输入你要修改的价钱:");
			Double change = reader.nextDouble();
			ps.setDouble(1, change);
			ps.setString(2, production.getName());
			ps.execute();
			ps.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public static Production getProduction(int productionId) {
		Production p = new Production();
		try {
			String url = "jdbc:mysql://localhost:3306/store?user=root&password=root";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url);
			PreparedStatement ps = con.prepareStatement("select * from production where id = ?");
			ps.setInt(1, productionId);
			ResultSet rs = ps.executeQuery();
			p = (Production) rs;
			ps.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return p;

	}

	public static List<Production> getAllProduction() {
		List<Production> l = new ArrayList<Production>();
		try {
			String url = "jdbc:mysql://localhost:3306/store?user=root&password=root";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url);
			PreparedStatement ps = con.prepareStatement("select * from production");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				l.add((Production)rs);
			}
			ps.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return l;

	}

}
