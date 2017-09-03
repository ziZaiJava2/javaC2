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

//标记为springmvc的Controller对象，使用 @Controller 定义一个 Controller 控制器
@Controller
//表示当请求/user 的时候访问的是UserController的addUser或加id访问getUserById方法，使用 @RequestMapping 来映射 Request 请求与处理器
@RequestMapping(value = "/user")
public class UserController {
	@Autowired//@PathVariable是用来获得请求url中的动态参数的
	private UserService userService;

//	@RequestMapping(value = "/{id}", method = RequestMethod.GET)//method 参数限制了以GET方法请求/user的时候才能访问到该Controller 的getUserById 方法
//	@ResponseBody//可以将如下类型的数据做成json
//	public User getUserById(@PathVariable int id) {//@PathVariable是用来获得请求url中的动态参数的
//		User user = new User();
//		user.setId(id);
//		user.setUserName("wei");
//		user.setAge(22);
//		return user;
//	}

	@RequestMapping(value = "", method = RequestMethod.POST)//method 参数限制了以GET方法请求/user的时候才能访问到该Controller 的addUser 方法
	@ResponseBody//@RequestBody接收的是一个Json对象
	public String addUser(@RequestBody User user) {//@PathVariable是用来获得请求url中的动态参数的
		if(userService.addUser(user)) {
			return "add successfully";
		}else{
			return "add fail";
		}
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST) // method 参数限制了以GET方法请求/user的时候才能访问到该Controller 的deleteUser 方法
	@ResponseBody // 可以将如下类型的数据做成json
	public String deleteUser(@PathVariable int id) {//@PathVariable是用来获得请求url中的动态参数的
		if (userService.deleteUserById(id)) {
			return "delete successfully";
		} else {
			return "delete fail";
		}
	}
	
//	@RequestMapping(value = "/{id}", method = RequestMethod.POST) // method 参数限制了以GET方法请求/user的时候才能访问到该Controller 的updateUser 方法
//	@ResponseBody // 可以将如下类型的数据做成json
//	public String updateUser(@PathVariable int id) {
//		if (userService.updateUserById(id)) {
//			return "update successfully";
//		} else {
//			return "update fail";
//		}
//	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET) // method 参数限制了以GET方法请求/user的时候才能访问到该Controller 的selectUser 方法
	@ResponseBody // 可以将如下类型的数据做成json
	public String selectUser(@PathVariable int id) {
		if (userService.selectUserById(id)!=null) {
			User u = userService.selectUserById(id);
			return "select successfully"+"   id:"+u.getId()+",name:"+u.getUserName()+",password:"+u.getPassword()+",age:"+u.getAge() ;
		} else {
			return "select fail";
		}
	}
	
}
