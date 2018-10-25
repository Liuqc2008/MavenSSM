package com.how2java.controller;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import apiclient.sdk.weixin.api.JsSDKApi;
import apiclient.sdk.weixin.api.WeixinOauth2Api;
import infrastructure.web.WebUtil;


@Controller
@RequestMapping("Weixin")
public class WeixinController extends BaseController{

	/*
	 * 授权页面	http://313624981.tunnel.qydev.com/MavenSSM/Weixin/Login
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
	public String Oauth(Model model, HttpServletRequest request) throws Exception{
		Map<String,String> param = WebUtil.GetParameterMap(request.getQueryString());
		Map<String, Object>  userinfo = WeixinOauth2Api.GetUserInfoByCode(param.get("code").toString());
		
		model.addAttribute("country", userinfo.get("country"));
		model.addAttribute("province", userinfo.get("province"));
		model.addAttribute("city", userinfo.get("city"));
		model.addAttribute("sex", userinfo.get("sex"));
		model.addAttribute("nickname", userinfo.get("nickname"));
		model.addAttribute("headimgurl", userinfo.get("headimgurl"));
		model.addAttribute("language", userinfo.get("language"));
		model.addAttribute("openid", userinfo.get("openid"));
		model.addAttribute("privilege", userinfo.get("privilege"));
		
		return "jsp/Weixin/oauth";
	}
	
	/*
	 * http://313624981.tunnel.qydev.com/MavenSSM/Weixin/jssdk
	 * */
	@RequestMapping("jssdk")
	public String jssdk(Model model) throws Exception{
		Map<String, String> map = JsSDKApi.GetSign("http://313624981.tunnel.qydev.com/MavenSSM/Weixin/jssdk");
		model.addAttribute("sign", map);

		return "jsp/Weixin/jssdk";
	}
}
