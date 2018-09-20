package com.how2java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class AccountController {

	@RequestMapping(value="AccountList")
	public String listCategory(){

		return "jsp/AccountList";
	}

}
