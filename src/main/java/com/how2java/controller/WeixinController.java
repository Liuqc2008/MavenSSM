package com.how2java.controller;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import infrastructure.web.WebUtil;
import weixin.sdk.api.WeixinOauth2Api;

@Controller
@RequestMapping("Weixin")
public class WeixinController extends BaseController{

	/*
	 * 授权页面
	 * */
	@RequestMapping(value="Login")
	public String Login(Model model) throws Exception{

		String returnUrl = URLEncoder.encode("http://313624981.tunnel.qydev.com/MavenSSM/Weixin/Oauth", "UTF-8");
		String url = WeixinOauth2Api.GetUrl(returnUrl, "snsapi_userinfo");
		
		model.addAttribute("url", url);
		return "jsp/Weixin/login";
	}
	
	/*
	 * 微信授权回调页面
	 */
	@RequestMapping("Oauth")
	public ModelAndView Oauth() throws Exception{
		HttpServletRequest request = WebUtil.getHttpServletRequest();
		
		ModelAndView mav = new ModelAndView();
		HashMap<String,String> param = WebUtil.GetRequestParam(request.getQueryString());
		String code = 	param.get("code").toString();
		
		Map<String, Object>  userinfo = WeixinOauth2Api.GetUserInfoByCode(code);
		
		mav.addObject("country", userinfo.get("country"));
		mav.addObject("province", userinfo.get("province"));
		mav.addObject("city", userinfo.get("city"));
		mav.addObject("sex", userinfo.get("sex"));
		mav.addObject("nickname", userinfo.get("nickname"));
		mav.addObject("headimgurl", userinfo.get("headimgurl"));
		mav.addObject("language", userinfo.get("language"));
		mav.addObject("openid", userinfo.get("openid"));
		mav.addObject("privilege", userinfo.get("privilege"));
		mav.setViewName("jsp/Weixin/oauth");
		return mav;
	}
}
