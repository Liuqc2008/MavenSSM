package com.how2java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.how2java.util.exception.AlertException;

@Controller
public class ExceptionController {
	
	//测试抛出自定义异常  
	@RequestMapping("/throwCustomException")
	public ModelAndView  throwCustomException() throws Exception{
		throw new AlertException("一个自定义异常发生了!");
		
	}
	 
	//测试抛出系统异常
	@RequestMapping("/throwUnknownException")
	public ModelAndView throwUnknownException() throws Exception{
		//String a = null;
		//System.out.println(a.length());
		
		return null;
	}
}
