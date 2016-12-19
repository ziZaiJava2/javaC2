package com.zizaitianyuan.javac2.store.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.zizaitianyuan.javac2.store.dto.Users;

public class UsersDAO implements TAG {
	private static final String URL = "jdbc:mysql://localhost:3306/store?user=root&password=root";
	private PreparedStatement preState = null;

	/**
	 * 向用户表中添加数据 @throws
	 */
	public void addUsers(Users users) {
		String sql = "insert into users (name,nickName,mailbox,address,balance)values(?,?,?,?,?);";
		try {
			preState = PrepareUtils.prepare(URL, sql);
			preState.setString(1, users.getName());
			preState.setString(2, users.getNickName());
			preState.setString(3, users.getMailbox());
			preState.setString(4, users.getAddress());
			preState.setInt(5, users.getBalance());
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
	 * 删除用户表
	 */
	public void deleteUsers(String name) {
		String sql = "delete from users where name='" + name + "'";
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
	 * @param change
	 */
	@Override
	public void update(String change, String name) {
		String sql = "update users set nickname=? where name=?";
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
	 * 获得指定用户对象
	 * 
	 * @param usersId
	 * @return
	 */
	public Users getUsers(String usersName) {
		Users selectUsers = new Users();
		String sql = "select name,nickName,mailbox,address,balance from users where name=?";
		try {
			preState = PrepareUtils.prepare(URL, sql);
			preState.setString(1, usersName);
			ResultSet res = preState.executeQuery();
			while (res.next()) {
				selectUsers.setName(res.getString("name"));
				selectUsers.setNickName(res.getString("nickName"));
				selectUsers.setMailbox(res.getString("mailbox"));
				selectUsers.setAddress(res.getString("address"));
				selectUsers.setBalance(res.getInt("balance"));
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
		return selectUsers;
	}

	/**
	 * 获得用户表所有用户名
	 * 
	 * @return
	 */
	public List<String> getAllUsers() {
		String sql = "select name from users";
		List<String> nameList = new ArrayList<>();
		try {
			preState = PrepareUtils.prepare(URL, sql);
			ResultSet res = preState.executeQuery();
			while (res.next()) {
				nameList.add(res.getString("name"));
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
