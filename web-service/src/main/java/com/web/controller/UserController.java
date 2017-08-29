package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.web.model.User;
import com.web.service.UserService;
import com.web.service.UserServiceImpl;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public User getUserById(@PathVariable int id) {
		User user = new User();
		user.setId(id);
		user.setUserName("wei");
		user.setAge(22);
		return user;
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public String addUser(@RequestBody User user) {
		userService.addUser(user);
		return "add successfully";
	}
	
	
}
