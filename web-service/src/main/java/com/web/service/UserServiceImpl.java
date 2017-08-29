package com.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.model.User;
import com.web.repository.UserRepositoryImpl;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepositoryImpl userRepositoryImpl;
	
	public void addUser(User user) {	
		System.out.println("User name :"+user.getUserName());
		System.out.println("User age :"+user.getAge());
		System.out.println("User password :"+user.getPassword());		
		//insert into db
		userRepositoryImpl.addUser(user);
	}

	public void deleteUserById(int id) {
		// TODO Auto-generated method stub
		
	}

	public void updataUserById(int id) {
		// TODO Auto-generated method stub
		
	}

	public void selectUserById(int id) {
		// TODO Auto-generated method stub
		
	}

}
