package com.test.bean;

public class UserServiceImpl implements UserService{
	UserDAO userDao;
//	String name;
//	//int age;
//	public UserServiceImpl(String name){
//		this.name = name;
//	}
	
//	public UserServiceImpl(int age,String name){
//		this.name = name;
//		this.age = age;
//	}
	
//	public UserServiceImpl(String agestr,String name){
//		this.name = name;
//
//	}
	
//	public UserServiceImpl(UserDAO userDao){
//		this.userDao = userDao;
//	}
	
	
	public String getUser(){
		userDao.getUserFromDB();
		System.out.println("wei wei");
		return "wei wei";
	}
	
	public void setUserDao(UserDAO userDao){
		this.userDao = userDao;
	}
}
