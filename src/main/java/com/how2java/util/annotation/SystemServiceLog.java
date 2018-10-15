package com.how2java.util.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
 
 
 /**
 * ClassName: SystemServiceLog <br/>
 * Function: AOP日志记录，自定义注解 <br/>
 * date: 2016年6月7日 上午9:29:01 <br/>
 * @author lcma
 * @version 
 * @since JDK 1.7
 */
@Target({ElementType.PARAMETER, ElementType.METHOD})    
@Retention(RetentionPolicy.RUNTIME)    
@Documented  
public @interface SystemServiceLog {
	/**
	* 日志描述
	*/
	String description()  default ""; 
	 
	/**
	* 操作表类型
	*/
	int tableType() default 0;
}