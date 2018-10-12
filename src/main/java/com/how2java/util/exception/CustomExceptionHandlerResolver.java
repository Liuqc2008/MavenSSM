package com.how2java.util.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;


public class CustomExceptionHandlerResolver implements HandlerExceptionResolver {
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
							Object handler, Exception exception) {
	 
		CustomException ex = null;
	
		if(exception instanceof CustomException){
			ex = (CustomException)exception;
		}else {
			ex = new CustomException("系统错误{" + exception.getMessage() +"}");
		}
	
		ModelAndView  mv = new ModelAndView();
	
		mv.addObject("message", ex.getMessage());
		mv.setViewName("jsp/Exception");
		return mv;
	}
}