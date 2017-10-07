package com.store.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.store.dto.GoodsCategoryDTO;
import com.store.model.Category;

import com.store.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.store.service.GoodsService;
import com.store.controller.UserController;
@Controller
@RequestMapping(value = "/mystore")
public class GoodsController {

	@Autowired
	private GoodsService goodsService;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/goods", method = RequestMethod.GET)
	public String selectAllGoods(HttpServletRequest req,ModelMap model) {
		String name = (String) req.getSession().getAttribute("name");
		String password = (String) req.getSession().getAttribute("password");
		    if(name != null || "".equals(name)){
				model.addAttribute("user",userService.selectUser(name,password));
				model.addAttribute("goods", goodsService.selectAllGoods());
				return "index";
			}else{
		    	return "redirect:login";
			}

	}

	@RequestMapping(value = "/getGoods", method = RequestMethod.POST)
	public String selectGoods(@RequestParam String goodsName, @RequestParam String categoryName, ModelMap model) {
		if (("".equals(goodsName) && "".equals(categoryName))) {
			model.addAttribute("goods", goodsService.selectAllGoods());
			return "index";
		} else if ((goodsName != "" ||goodsName != null)&& ("".equals(categoryName) ||categoryName == null)) {
			categoryName = null;
			model.addAttribute("goods", goodsService.selectGoodsCategory(goodsName));//锟斤拷锟斤拷锟斤拷品
			return "index";
		} else if ((categoryName != "" ||categoryName != null)&& ("".equals(goodsName)||goodsName == null)) {;
			model.addAttribute("goods", goodsService.selectCategoryGoods(categoryName));//锟斤拷锟斤拷品锟斤拷锟窖拷锟斤拷锟接︼拷锟斤拷锟狡�
			return "index";
		} else {
			model.addAttribute("goods", goodsService.selectGoods(goodsName, categoryName));
			return "index";
		}
	}

	@RequestMapping(value = "/newCategory", method = RequestMethod.GET)
	public String createNewCategory(HttpServletRequest req,ModelMap model) {
		String name = (String) req.getSession().getAttribute("name");
		if(name != null){
			return "newCategory";
		}else {
			return "redirect:login";
		}
	}

	@RequestMapping(value = "/newGoods", method = RequestMethod.GET)
	public String createNewGoods(HttpServletRequest req,ModelMap model) {
		String name = (String) req.getSession().getAttribute("name");
		if(name !=null){
			model.addAttribute("category",goodsService.AllCategory());
			return "newGoods";
		}else{
			return "redirect:login";
		}
	}
	
	@RequestMapping(value = "/deleteGoods", method = RequestMethod.GET)
	public String deleteGoods(HttpServletRequest req,ModelMap model) {
		int goodsId = Integer.parseInt( req.getParameter("getI"));
		goodsService.deleteGoods(goodsId);
		return "redirect:goods";
	}

	@RequestMapping(value = "/newCategory", method = RequestMethod.POST)
	public String newCategory(@RequestParam String categoryName) {
		if (categoryName == "") {
			return "redirect:newCategory";
		} else {
			goodsService.createNewCategory(categoryName);
			return "redirect:goods";
		}
	}

	@RequestMapping(value = "/newGoods", method = RequestMethod.POST)
	public String newGoods(@RequestParam String goodsName, @RequestParam String categoryName,
			@RequestParam String date,@RequestParam double price) {
			goodsService.createNewGoods(goodsName, categoryName, date,price);
			return "redirect:goods";
	}
}
