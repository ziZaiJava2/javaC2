package com.djbc.mall;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ProductionDAO {
	
	public static ProductionDAO getProductionDAO(){
		ProductionDAO productionDAO = new ProductionDAO();
		return productionDAO;
	}
	 
	// addProduction(Production production) 无返回值 当调用这个方法时， 会把Production
	// 对象里的数据存到数据库中
	private static Map<Integer,Production> productionMap = new HashMap<Integer,Production>();
	public void addProduction(Production production) throws ClassNotFoundException, SQLException{
		String url = ProductionDJBC.getUrl(); // 调用url和与加载驱动的方法
		Connection conn = null;
		PreparedStatement stat = null;
		PreparedStatement stmt = null;
		ResultSet rs = null; // 将查找的数据临时保存在rs内

		try {
			String sql = "insert into student(name,description,original_price,price)" + "values(?,?,?,?)";
			conn = DriverManager.getConnection(url);   //获取数据库链接
			stat = conn.prepareStatement(sql);
			
			//放入数据库
			stat.setString(1, production.getName());
			stat.setString(2, production.getDescription());
			stat.setDouble(3, production.getOriginal_price());
			stat.setDouble(4, production.getPrice());
			boolean A = stat.execute(sql);
			if(A){
				System.out.println("数据存储。。。成功！");
			}else{
				System.out.println("数据存储。。。失败！");
			}	
			
			//取出production的相应的id，放入production.setStuId里
			String querySql = "select id from production where name = ?";			
			stmt = conn.prepareStatement(querySql);
			rs = stmt.executeQuery(querySql);
			stmt.setString(1, production.getName()); // 用productionId条件			
			production.setStuId(rs.getInt("id"));
			productionMap.put(production.getStuId(), production);
					
		} catch (SQLException e) {
			e.printStackTrace(); // 显示出异常的路径
		} finally {
			stat.close(); // 关闭资源
			stmt.close();
			conn.close();
			rs.close();
		}
	}

	// deleteProduction(int productionId) 无返回值 当调用这个方法时， 根据productionId
	// 删除对应数据库中数据
	public void deleteProduction(int productionId) throws ClassNotFoundException, SQLException {
		String url = ProductionDJBC.getUrl(); // 调用url和与加载驱动的方法
		Connection conn = null;
		PreparedStatement stat = null;

		try {
			String sql = "delete from production where id = ？";
			conn = DriverManager.getConnection(url);
			stat = conn.prepareStatement(sql);	
			
			stat.setInt(1, productionId); // 用productionId条件
			boolean A = stat.execute(sql);
			int count = stat.getUpdateCount();
			if(A){
				System.out.println(count+"条数据删除。。。成功！");
			}else{
				System.out.println(count+"条数据删除。。。失败！");
			}
			
		} catch (SQLException e) {
			e.printStackTrace(); // 显示出异常的路径
		} finally {
			stat.close(); // 关闭资源
			conn.close();
		}

	}

	// updateProduction(Production production) 无返回值 当调用这个方法时，根据productionId 更改
	// production对象里的数据到对应的数据库中
	public void updateProduction(int productionId) throws ClassNotFoundException, SQLException {
		List<String> natureList = new ArrayList<String>(); // 生成一个临时保存更改的对象属性链表
		Scanner in = new Scanner(System.in);
		String url = ProductionDJBC.getUrl(); // 调用url和与加载驱动的方法
		Connection conn = DriverManager.getConnection(url); // 打开Connection资源
		PreparedStatement stat;
		
		System.out.println("请输入你要更改的商品属性：");
		int m = 5;
		int i = 0;
		int n = 1;
		while (i < m) {
			System.out.println(n + ":");
			String nature = in.next();
			natureList.add(nature);
			System.out.println("是否结束属性填写！（是、否）");
			if (in.next().equals("是")) {
				break;
			}
			i++;
			n++;
		}
		try {
			
			if (natureList.contains("name")) {
				System.out.println("请输入新的name：");
				String sql = "update production set name=? where id=?";
				stat = conn.prepareStatement(sql);				
				stat.setString(1, in.next()); // 将production的name数据重新添加到数据库
				stat.setInt(2, productionId); // 用productionId条件
				boolean A = stat.execute(sql);
				if(A){
					System.out.println("修改name成功！");
				}else{
					System.out.println("修改name失败！");
				}
				stat.close(); // 关闭Statement的资源
			}
			
			if (natureList.contains("description")) {
				System.out.println("请输入新的description：");
				String sql = "update production set description=? where id=?";
				stat = conn.prepareStatement(sql);
				stat.setString(1, in.next()); // 将production的description数据重新添加到数据库
				stat.setInt(2, productionId); // 用productionId条件
				boolean A = stat.execute(sql);
				if(A){
					System.out.println("修改description成功！");
				}else{
					System.out.println("修改description失败！");
				}
				stat.close();
			}
			
			if (natureList.contains("original_price")) {
				System.out.println("请输入新的original_price：");
				String sql = "update production set original_price=? where id=?";
				stat = conn.prepareStatement(sql);
				stat.setDouble(1, in.nextDouble()); // 将production的original_price数据重新添加到数据库
				stat.setInt(2, productionId); // 用productionId条件
				boolean A = stat.execute(sql);
				if(A){
					System.out.println("修改original_price成功！");
				}else{
					System.out.println("修改original_price失败！");
				}
				stat.close();
			}
			
			if (natureList.contains("price")) {
				System.out.println("请输入新的price：");
				String sql = "update production set price=? where id=?";
				stat = conn.prepareStatement(sql);
				stat.setDouble(1, in.nextDouble()); // 将production的price数据重新添加到数据库
				stat.setInt(2, productionId); // 用productionId条件
				boolean A = stat.execute(sql);
				if(A){
					System.out.println("修改price成功！");
				}else{
					System.out.println("修改price失败！");
				}
				stat.close();
			}
		} catch (SQLException e) {
			e.printStackTrace(); // 显示出异常的路径
		} finally {
			conn.close(); // 关闭Connection的资源
			in.close();
		}
	}

	
	// getProduction(int productionId) 通过给定的产品id 去数据库查找对应数据， 返回值是一个Production对象	
	public Production getProduction(int productionId) throws ClassNotFoundException, SQLException {
		Production production = new Production();
		String url = ProductionDJBC.getUrl(); // 调用url和与加载驱动的方法
		Connection conn = null;
		PreparedStatement stat = null;
		ResultSet rs = null; // 将查找的数据临时保存在rs内

		try {
			String querySql = "select * from production where id = ?";
			conn = DriverManager.getConnection(url);
			stat = conn.prepareStatement(querySql);
			rs = stat.executeQuery(querySql);
			stat.setInt(1, productionId); // 用productionId条件

			production.setStuId(rs.getInt("id"));
			production.setName(rs.getString("name"));
			production.setDescription(rs.getString("description"));
			production.setOriginal_price(rs.getInt("original_price"));
			production.setPrice(rs.getInt("price"));

		} catch (SQLException e) {
			e.printStackTrace(); // 显示出异常的路径
		} finally {
			rs.close(); // 关闭资源
			stat.close();
			conn.close();
		}

		return production;
	}

	// getAllProduction() 查找所有的商品， 方法返回值是一个 list。
	public List<Production> getAllProduction() throws ClassNotFoundException, SQLException {
		List<Production> productionList = new ArrayList<Production>(); // 创建一个保存对象的链表
		String url = ProductionDJBC.getUrl(); // 调用url和与加载驱动的方法
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null; // 将查找的数据临时保存在rs内

		try {
			String querySql = "select * from production"; // 可以在这里设置条件
			conn = DriverManager.getConnection(url);
			stat = conn.createStatement();
			rs = stat.executeQuery(querySql);

			while (rs.next()) {
				Production production = new Production(); // 创建一个临时对象
				production.setStuId(rs.getInt("id"));
				production.setName(rs.getString("name"));
				production.setDescription(rs.getString("description"));
				production.setOriginal_price(rs.getInt("original_price"));
				production.setPrice(rs.getInt("price"));

				productionList.add(production); // 将对象保存到链表中
			}
		} catch (SQLException e) {
			e.printStackTrace(); // 显示出异常的路径
		} finally {
			rs.close(); // 关闭资源
			stat.close();
			conn.close();
		}

		return productionList;
	}

}
