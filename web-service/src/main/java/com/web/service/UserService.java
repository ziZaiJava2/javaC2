package com.web.service;


import com.web.model.User;


public interface UserService {		
	public boolean addUser(User user);
	public boolean deleteUserById(int id);
	public boolean updateUserById(int id);
	public User selectUserById(int id);
}
