package com.how2java.aspect;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import com.how2java.mapper.SystemLogMapper;
import com.how2java.pojo.SystemLog;

import infrastructure.exception.AlertException;

public class CustomExceptionHandlerResolver implements HandlerExceptionResolver {
	
	@Autowired
	private SystemLogMapper systemLogMapper;
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
							Object handler, Exception exception) {
	 
		AlertException ex = null;
		if(exception instanceof AlertException){
			ex = (AlertException)exception;
		}else {
			ex = new AlertException("系统错误：" + exception.getMessage() +"");
		}
		
		ModelAndView  mv = new ModelAndView();

		if(request.getMethod().equals("POST")){
			FastJsonJsonView json = new FastJsonJsonView();
			
			Map<String, Object> attributes = new HashMap<String, Object>();
	        attributes.put("Tag", "-999");
	        attributes.put("Message", ex.getMessage());
	        json.setAttributesMap(attributes);
	        mv.setView(json); 
		}else{
			mv.addObject("message", ex.getMessage());
			mv.setViewName("jsp/Exception");
		}
	
		SystemLog systemLog = new SystemLog();
		systemLog.setName(exception instanceof AlertException ? "Alert ": "System");
		systemLog.setDetail(ex.getMessage());
		systemLogMapper.add(systemLog);
		
		return mv;
	}
}