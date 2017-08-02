package store.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import store.dto.Category;
import store.dto.Production;

public class CategoryDAO {

	public static void main(String[] args) {
		Category c = new Category();
		c.setCategoryName("游戏类");
		// addCategory(c);
		// updateCategory(c);
		// getCategory(1);
		// getAllCategory();
		deleteCategory(2);
	}

	static Scanner reader = new Scanner(System.in);

	public static void addCategory(Category category) {
		try {
			String url = "jdbc:mysql://localhost:3306/store?user=root&password=root";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url);
			PreparedStatement ps = con.prepareStatement("insert category (category_name)values(?)");
			ps.setString(1, category.getCategoryName());
			ps.execute();
			ps.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void updateCategory(Category category) {
		try {
			String url = "jdbc:mysql://localhost:3306/store?user=root&password=root";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url);
			PreparedStatement ps = con
					.prepareStatement("update category set category_name = ? where category_name = ?");
			System.out.print("原类名为" + category.getCategoryName() + "请输入修改后的值:");
			String change = reader.nextLine();
			ps.setString(1, change);
			ps.setString(2, category.getCategoryName());
			ps.execute();
			ps.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public static void deleteCategory(int categoryId) {
		try {
			String url = "jdbc:mysql://localhost:3306/store?user=root&password=root";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url);
			PreparedStatement ps = con.prepareStatement("delete from category where id = ?");
			ps.setInt(1, categoryId);
			ps.execute();
			ps.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public static Category getCategory(int categoryId) {
		Category c = new Category();
		try {
			String url = "jdbc:mysql://localhost:3306/store?user=root&password=root";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url);
			PreparedStatement ps = con.prepareStatement("select * from category where id = ?");
			ps.setInt(1, categoryId);
			ResultSet rs = ps.executeQuery();
			c = (Category) rs;
			ps.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return c;

	}

	public static List<Category> getAllCategory() {
		List<Category> l = new ArrayList<Category>();
		try {
			String url = "jdbc:mysql://localhost:3306/store?user=root&password=root";
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url);
			PreparedStatement ps = con.prepareStatement("select * from category");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				l.add((Category) rs);
			}
			ps.close();
			con.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return l;

	}

}
