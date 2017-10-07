package com.store.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jdk.nashorn.internal.runtime.GlobalConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.store.service.GoodsService;
import com.store.service.UserService;

import java.io.IOException;

@Controller
@RequestMapping(value = "/mystore")
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private GoodsService goodsService;
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(ModelMap model) {
		return "login";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String getRegisterPage(ModelMap model, HttpServletRequest req,HttpServletResponse resp) {
		return "register";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String name,@RequestParam String password,ModelMap model,HttpServletRequest req,HttpServletResponse resp) throws IOException {
		if(userService.selectUser(name, password) != null){
			model.addAttribute("goods", goodsService.selectAllGoods());
			req.getSession().setAttribute("name",name);
			req.getSession().setAttribute("password",password);
			String userName = (String) req.getSession().getAttribute("name");
			String userPassword = (String) req.getSession().getAttribute("password");
			model.addAttribute("user", userService.selectUser(userName,userPassword));
			return "index";
		}else{
			req.setAttribute("error", "用户名或密码错误！");
			return "login";
		}
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(HttpServletRequest req,ModelMap model) {
		return "redirect:goods";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(@RequestParam String name,@RequestParam String password,@RequestParam String sex){
		userService.createUser(name, password, sex);
		return "redirect:login";		
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user(HttpServletRequest req, HttpServletResponse resp,ModelMap model){
		String name = (String) req.getSession().getAttribute("name");
		String password = (String) req.getSession().getAttribute("password");
		if(name != null && password !=null){
			model.addAttribute("user",userService.selectUser(name,password));
			return "user";
		}else{
			return "redirect:login";
		}
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public String user(HttpServletRequest req, HttpServletResponse resp){
		Cookie cookie = new Cookie("JSESSIONID",null);
		cookie.setPath("/");
		cookie.setMaxAge(0);
		resp.addCookie(cookie);
		req.setAttribute("name",null);
		req.getSession().invalidate();
		return "redirect:login";
	}
}
