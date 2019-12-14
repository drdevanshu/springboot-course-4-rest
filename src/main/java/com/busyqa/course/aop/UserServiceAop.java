package com.busyqa.course.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class UserServiceAop {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Before(value = "execution(* com.busyqa.course.service.UserService.*(..)) and args(idUser)")
	public void beforeAdviceOneParam(JoinPoint joinPoint, int idUser) {
		
		logger.debug("Before method:" + joinPoint.getSignature());
		logger.debug("Looking for User with Id: {}", idUser);
		
	}

	@After(value = "execution(* com.busyqa.course.service.UserService.*(..)) and args(idUser)")
	public void afterAdviceOneParam(JoinPoint joinPoint, int idUser) {
		
		logger.debug("After method:" + joinPoint.getSignature());
		logger.debug("Successfully looked for User with Id: {}", idUser);
	}

	
	@Before(value = "execution(* com.busyqa.course.service.UserService.createUser(..))")
	public void beforeAdviceMethodName(JoinPoint joinPoint) {
		
		logger.debug("Before method:" + joinPoint.getSignature());
		logger.debug("Creating User.");		
	}
	
	@After(value = "execution(* com.busyqa.course.service.UserService.createUser(..))")
	public void afterAdviceMethodName(JoinPoint joinPoint) {
		
		logger.debug("After method:" + joinPoint.getSignature());
		logger.debug("Successfully created User.");
	}
}
