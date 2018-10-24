package com.how2java.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;


import com.how2java.service.AliyunService;

@Controller
@RequestMapping("Aliyun")
public class AliyunController {
	
	@Autowired
	AliyunService aliyunService;
	
	@RequestMapping(value="SendMessage")
	public String AccountList() throws Exception{
		
		return "jsp/Aliyun/SendMessage";
	}
	
	@RequestMapping(value="doSendMessage", method= RequestMethod.POST)
	@ResponseBody
	public void AccountList(String phone) throws Exception {
		
		aliyunService.sendMessage(phone);
	}
	
	
}
