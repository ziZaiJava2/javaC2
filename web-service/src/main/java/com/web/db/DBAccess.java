package com.web.db;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class DBAccess {
	public static SqlSession getSqlSession() throws IOException{
		//��ȡ���ݿ���Ϣ
		Reader reader = Resources.getResourceAsReader("com/web/config/Configuration.xml");
		//����SqlSession�Ĺ���sqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//����SqlSessionʵ��
		SqlSession sqlSession = sqlSessionFactory.openSession();
		return sqlSession;
		
	}
}
