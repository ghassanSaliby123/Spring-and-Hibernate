package com.luv2code.springdemo.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class CRMLoggingAspect {
	
	//setup logger
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	//setup pointcut declarations
	//for controller
	@Pointcut("execution(* com.luv2code.springdemo.controller.*.*(..))")
	private void forControllerPackage() {}
	
	//for service
	@Pointcut("execution(* com.luv2code.springdemo.service.*.*(..))")
	private void forServicePackage() {}
	
	//for dao
	@Pointcut("execution(* com.luv2code.springdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	@Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
	private void forAppFlow() {}
	
	//add @Before advice
	@Before("forAppFlow()")
	public void before(JoinPoint theJoinPoint) {
		
		//Display method we are calling
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("--------->> in @Before: calling method: "+method);
		
		//Display the arguments to the method
		
		//get the args
		Object[] args = theJoinPoint.getArgs();
		
		//display args
		for(Object arg : args) {
			myLogger.info(arg.toString());
		}
	}
	
	//Add @AfterReturning advice
	@AfterReturning(
			pointcut="forAppFlow()",
			returning="theResult")
	public void afterReturning(JoinPoint theJoinPoint, Object theResult) {
		
		//Display method we are calling
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("--------->> in @AfterReturning: from method: "+method);
		
		//display the data returned
		myLogger.info("--------->> result: " + theResult);
	}
	
	
	
	
	//add @AfterReturning advice
}
