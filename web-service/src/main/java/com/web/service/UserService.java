package com.web.service;


import com.web.model.User;


public interface UserService {		
	public void addUser(User user);
	public void deleteUserById(int id);
	public void updataUserById(int id);
	public void selectUserById(int id);
}
