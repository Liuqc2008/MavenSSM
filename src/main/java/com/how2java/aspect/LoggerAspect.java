package com.how2java.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;

import org.springframework.stereotype.Component;


import java.lang.reflect.Field;
import java.util.Objects;
import java.util.stream.Stream;


@Aspect
@Component
public class LoggerAspect {
	
	
	//@Around(value = "execution(* com.how2java.service.AccountService.*(..))")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("start log:" + joinPoint.getSignature().getName());
        Object object = joinPoint.proceed();
        
        System.out.println("end log:" + joinPoint.getSignature().getName());
        Object j = joinPoint.getThis();
        Object getTarget = joinPoint.getTarget();
        System.out.println(j);
        return object;
    }
	
	
	
}
