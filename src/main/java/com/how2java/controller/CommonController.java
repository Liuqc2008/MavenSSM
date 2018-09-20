package com.how2java.controller;

import java.net.URLDecoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.how2java.pojo.Account;
import com.how2java.pojo.Category;
import com.how2java.pojo.PageData;
import com.how2java.service.AccountService;
import com.how2java.service.CategoryService;

@Controller
@RequestMapping("Common")
public class CommonController {
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	AccountService accountService;

	@RequestMapping("/CategoryList")
	@ResponseBody
	public Object peopleSelect() {
		PageData pageData = new PageData();
		List<Category> cs= categoryService.list();
		
		pageData.setData(cs);
		pageData.setCount(cs.size());
		
		return pageData;
	}
	
	@RequestMapping(value="/AccountList", method= RequestMethod.GET)
	@ResponseBody
	public Object AccountList(int page, int limit, HttpServletRequest request) throws Exception {
		//http://localhost/MavenSSM/Common/AccountList?page=1&limit=10&key%5Bname%5D=X&key%5Bpassword%5D=
		//http://localhost/MavenSSM/Common/AccountList?page=1&limit=10&key[name]=x&key[password]=
		String urlParam = request.getQueryString();
		
		PageData pageData = new PageData();
		Map<String, Object> requestParam = urlParamToMap(URLDecoder.decode(urlParam, "UTF-8"));	
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("name", requestParam.get("name"));
		map.put("password", requestParam.get("password"));
		map.put("startTime", requestParam.get("startTime"));
		map.put("endTime", requestParam.get("endTime"));
		
		List<Account> account= accountService.list(map);
		
		pageData.setData(account);
		pageData.setCount(account.size());
		
		return pageData;
	}
	
	public Map<String, Object> urlParamToMap(String urlParam){
		Map<String, Object> hashMap = new HashMap<String,Object>();
		String[] param =  urlParam.split("&");
		
		for(String keyvalue : param){
			String[] pair = keyvalue.split("=");
			
		    if(pair.length == 2){
		    	if(pair[0].indexOf("key") >=0)
		    		pair[0] = pair[0].replace("key[", "").replace("]", "");
		    	
		    	hashMap.put(pair[0], pair[1]);
		    }
		}
		
		return hashMap;
	}
}
