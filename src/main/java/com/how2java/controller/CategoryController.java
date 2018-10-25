package com.how2java.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.how2java.pojo.Category;
import com.how2java.service.CategoryService;

// 告诉spring mvc这是一个控制器类
@Controller
@RequestMapping("")
public class CategoryController {
	@Autowired
	CategoryService categoryService;

	@RequestMapping("listCategory")
	public String listCategory(Model model){
		List<Category> cs= categoryService.list();

		model.addAttribute("cs", cs);
		return "jsp/listCategory";
	}

	@RequestMapping("form")
	public String form(){

		return "jsp/form";
	}
	
	@RequestMapping("layui")
	public String layui(){

		return "jsp/layui";
	}
}
