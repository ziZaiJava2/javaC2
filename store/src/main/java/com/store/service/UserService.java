package com.store.service;

import com.store.model.User;

public interface UserService {
	
	public User selectUser(String name,String password);
	
	public void createUser(String name,String password,String sex);
}
