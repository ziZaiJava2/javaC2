package com.web.repository;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.web.db.DBAccess;
import com.web.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository {

	public void addUser(User user) {
		SqlSession sqlSesssion = null;
		try {
			sqlSesssion = DBAccess.getSqlSession();
			sqlSesssion.insert("User.insert", user);
			sqlSesssion.commit();
			sqlSesssion.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sqlSesssion != null) {
				sqlSesssion.close();
			}
		}

	}

}
