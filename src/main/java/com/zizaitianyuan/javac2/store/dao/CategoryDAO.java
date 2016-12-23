package com.zizaitianyuan.javac2.store.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zizaitianyuan.javac2.store.dto.Category;

public class CategoryDAO implements TAG {
	
	private static final String URL = "jdbc:mysql://localhost:3306/store?user=root&password=root";
	
	private PreparedStatement preState = null;

	/**
	 * 向类别表中添加数据
	 */
	public void addCategory(Category category) {
	
		String sql = "insert into category (name)values(?);";
		
		try {
		
			preState = PrepareUtils.prepare(URL, sql);
			
			preState.setString(1, category.getName());
			
			preState.executeUpdate();
		
		} catch (Exception e) {
		
			tellError(e);
		
		} finally {
		
			try {
			
				preState.close();
				
				PrepareUtils.close();
			
			} catch (Exception e) {
			
				e.printStackTrace();
			
			}
		
		}
	
	}

	/**
	 * 删除类别表
	 */
	public void deleteCategory(String name) {
	
		String sql = "delete from category where name='" + name + "'";
		
		try {
		
			preState = PrepareUtils.prepare(URL, sql);
			
			preState.executeUpdate();
		
		} catch (Exception e) {

			tellError(e);
		
		} finally {
		
			try {
			
				preState.close();
				
				PrepareUtils.close();
			
			} catch (Exception e) {
			
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
	
		String sql = "update category set name=? where name=?";
		
		try {
		
			preState = PrepareUtils.prepare(URL, sql);
			
			preState.setString(1, change);
			
			preState.setString(2, name);
			
			preState.executeUpdate();
		
		} catch (Exception e) {
		
			tellError(e);
		
		} finally {
		
			try {
			
				preState.close();
				
				PrepareUtils.close();
			
			} catch (Exception e) {
			
				e.printStackTrace();
			
			}
		
		}
	
	}

	/**
	 * 获得指定用户对象
	 * 
	 * @param usersId
	 * @return
	 */
	public Category getCategory(int categoryId) {
	
		Category selectCategory = new Category();
		
		String sql = "select name from category where id=?";
		
		try {
		
			preState = PrepareUtils.prepare(URL, sql);
			
			preState.setInt(1, categoryId);
			
			ResultSet res = preState.executeQuery();
			
			while (res.next()) {
			
				selectCategory.setName(res.getString("name"));
			
			}
		
		} catch (Exception e) {
		
			tellError(e);
		
		} finally {
		
			try {
			
				preState.close();
				
				PrepareUtils.close();
			
			} catch (Exception e) {
				
				e.printStackTrace();
				
			}
		
		}
		
		return selectCategory;
	
	}

	/**
	 * 获得用户表所有用户名
	 * 
	 * @return
	 */
	public List<String> getAllCategory() {
	
		String sql = "select name from category";
		
		List<String> nameList = new ArrayList<>();
		
		try {
		
			preState = PrepareUtils.prepare(URL, sql);
			
			ResultSet res = preState.executeQuery();
			
			while (res.next()) {
			
				nameList.add(res.getString("name"));
			
			}
		
		} catch (Exception e) {
		
			tellError(e);
		
		} finally {
		
			try {
			
				preState.close();
				
				PrepareUtils.close();
			
			} catch (Exception e) {
			
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
