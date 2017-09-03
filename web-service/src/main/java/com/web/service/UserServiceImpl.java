package com.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.model.User;

import com.web.mapper.*;
import org.springframework.transaction.annotation.Transactional;

//标记为springmvc的Service对象，使用 @Service 定义一个 Service 控制器
@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	//当Spring发现@Autowired注解时，将自动在代码上下文中找到和其匹配（默认是类型匹配）的Bean，并自动注入到相应的地方去。
	@Autowired
	private UserMapper userMapper;

	public boolean addUser(User user) {
		com.web.entity.User u = new com.web.entity.User();
		u.setId(user.getId());
		u.setName(user.getUserName());
		u.setPassword(user.getPassword());
		u.setAge(user.getAge());
		int num = userMapper.insertUser(u);
		if(num == 1){
			return true;
		}else{
			return false;
		}
}

	public boolean deleteUserById(int id) {
		int num = userMapper.deleteUser(id);
		if(num == 1){
			return true;
		}else{
			return false;
		}
	}

	public boolean updateUserById(int id) {
		return false;

	}

	public User selectUserById(int id) {
		com.web.entity.User u = userMapper.selectUser(id);
		User user = new User();
		user.setId(u.getId());
		user.setUserName(u.getName());
		user.setPassword(u.getPassword());
		user.setAge(u.getAge());
		return user;
	}
}
