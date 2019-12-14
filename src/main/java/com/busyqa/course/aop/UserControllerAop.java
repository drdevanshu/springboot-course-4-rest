package com.busyqa.course.aop;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserControllerAop {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    HttpServletRequest request;
    
    @Around("execution(* com.busyqa.course.controller.UserController.*(..))")
    public Object logAroundAllMethods(ProceedingJoinPoint joinPoint) throws Throwable {
    	
    	Map<String,String[]> map =request.getParameterMap();
    	
    	logger.debug("Controller Executing : " + joinPoint.getSignature());
    	
    	if (!map.isEmpty()) {
    		logger.debug("Parameters Received:");
    		map.forEach((k,v) -> logger.debug("{}-> {}",k,v));
    	}
    	Object value = null;
        try {
            value = joinPoint.proceed();
        } finally {
            //Do Something useful, If you have
        }
        logger.debug("Controller Ended Execution : " + joinPoint.getSignature());
        
        return value;
    }
    
}
