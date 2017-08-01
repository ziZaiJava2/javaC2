package store.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import store.dto.Production;
import store.dto.User;

public class UserDAO {
	public static void main(String args[]) {

	}
	
	
	static Scanner reader = new Scanner(System.in);
	public static void addUser(User user) {
		try {
			String url = "jdbc:mysql://localhost:3306/store?user=root&password=root";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url);
			PreparedStatement ps = con.prepareStatement("insert user (name,address,mailbox,wallet)values(?,?,?,?)");
			ps.setString(1, user.getName());
			ps.setString(2, user.getAddress());
			ps.setString(3, user.getMailbox());
			ps.setDouble(4, user.getWallet());
			ps.execute();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteUser(int userId) {
		try {
			String url = "jdbc:mysql://localhost:3306/store?user=root&password=root";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url);
			PreparedStatement ps = con.prepareStatement("delete from user where id = ?");
			ps.setInt(1, userId);
			ps.execute();
			ps.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public static void updateUser(User user) {
		try {
			String url = "jdbc:mysql://localhost:3306/store?user=root&password=root";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url);
			PreparedStatement ps = con.prepareStatement("update user set address = ? where name = ?");
			System.out.print("原地址为" + user.getAddress() + "请输入你要修改的地址:");
			String change = reader.nextLine();
			ps.setString(1, change);
			ps.setString(2, user.getName());
			ps.execute();
			ps.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}
	
	public static List<User> getAllProduction() {
		List<User> l = new ArrayList<User>();
		try {
			String url = "jdbc:mysql://localhost:3306/store?user=root&password=root";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url);
			PreparedStatement ps = con.prepareStatement("select * from user");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				l.add((User)rs);
			}
			ps.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return l;

	}
}
