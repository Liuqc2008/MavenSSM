package com.how2java.aspect;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.how2java.util.annotation.*;
 
@Aspect
@Component("LogAspect")
public class LogAspect {
	
	// 配置织入点
    @Pointcut("@annotation(com.how2java.util.annotation.Log)")
    public void logPointCut() {
    	
    }

    /**
     * 前置通知 用于拦截操作，在方法返回后执行
     * @param joinPoint 切点
     */
    @AfterReturning(pointcut = "logPointCut()")
    public void doBefore(JoinPoint joinPoint) {
    	handleLog(joinPoint, null);
    }
 
    /**
     * 拦截异常操作，有异常时执行
     * 
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(value = "logPointCut()", throwing = "e")
    public void doAfter(JoinPoint joinPoint, Exception e) {
    	handleLog(joinPoint, e);
    }
 
    private void handleLog(JoinPoint joinPoint, Exception e) {
		try {
		    //获取注解方法
		    Log controllerLog = getAnnotationLog(joinPoint);
		    //if (controllerLog == null) {
		    //	return;
		    //}
		    
		    // 获得方法名称
		    String className = joinPoint.getTarget().getClass().getName();
		    String methodName = joinPoint.getSignature().getName();
		    String action = controllerLog.action();
		    String title = controllerLog.title();
		    
		    //打印日志，如有需要还可以存入数据库
		    System.out.println(">>>>>>>>>>>>>模块名称：" + title);
		    System.out.println(">>>>>>>>>>>>>操作名称：" +action);
		    System.out.println(">>>>>>>>>>>>>类名：" +className);
		    System.out.println(">>>>>>>>>>>>>方法名：" +methodName);
		    System.out.println("" +JSONObject.toJSONString(joinPoint.getArgs()));
		} catch (Exception exp) {
		    // 记录本地异常日志
			System.out.println("==前置通知异常==");
			System.out.println("异常信息:{}" +exp.getMessage());
		    exp.printStackTrace();
		}
    }
 
    /**
     * 是否存在注解，如果存在就获取
     */
    private static Log getAnnotationLog(JoinPoint joinPoint) throws Exception {
    	
		Signature signature = joinPoint.getSignature();
		MethodSignature methodSignature = (MethodSignature) signature;
		Method method = methodSignature.getMethod();
		if (method != null) {
		    return method.getAnnotation(Log.class);
		}
		return null;
	    
	}

}
