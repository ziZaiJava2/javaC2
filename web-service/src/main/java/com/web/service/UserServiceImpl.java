package com.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.model.User;
import com.web.mapper.*;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserMapper userMapper;

	public boolean addUser(User user) {
		int num = userMapper.insertUser(user);
		if(num == 1){
			return true;
		}else{
			return false;
		}
}

	public void deleteUserById(int id) {

	}

	public void updataUserById(int id) {

	}

	public void selectUserById(int id) {

	}
}
