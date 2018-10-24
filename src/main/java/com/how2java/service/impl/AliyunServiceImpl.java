package com.how2java.service.impl;


import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.how2java.service.AliyunService;

import apiclient.aliyun.message.MessageApi;

@Service
public class AliyunServiceImpl implements AliyunService{
	
	public void sendMessage(String phone) throws Exception{
		
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("code", "18259480903");
		
		SendSmsResponse result = MessageApi.sendMessage(phone, JSONObject.toJSONString(param), "好房子", "SMS_139226475");
		System.out.println(JSONObject.toJSONString(result));
	}

}
