package com.web.db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBAccess {
	public static SqlSession getSqlSession() throws IOException{
		//获取数据库信息
		Reader reader = Resources.getResourceAsReader("com/web/config/Configuration.xml");
		//创建SqlSession的工厂sqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//创建SqlSession实例
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession;
		
	}
}
