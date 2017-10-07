package com.store.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.store.mapper.UserMapper;
import com.store.model.User;
import com.store.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper userMapper;
	
	public User selectUser(String name ,String password) {	
		return userMapper.selectUser(name, password);
	}

	public void createUser(String name, String password, String sex) {
		userMapper.createUser(name, sex, password);
	}

}
