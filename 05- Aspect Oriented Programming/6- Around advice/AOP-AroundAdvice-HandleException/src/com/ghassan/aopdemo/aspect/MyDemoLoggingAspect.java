package com.ghassan.aopdemo.aspect;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.ghassan.aopdemo.Account;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
	private Logger myLogger = Logger.getLogger(getClass().getName());
	
	@Around("execution(* com.ghassan.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint)throws Throwable{
		
		//print out method we are advising on 
		String method = theProceedingJoinPoint.getSignature().toShortString();
		myLogger.info("\n------->> Executing @Around on method: "+method);
		
		//get begin timestamp
		long begin = System.currentTimeMillis();
		
		//execute the method
		Object result = null;
		try {
			result = theProceedingJoinPoint.proceed();
		} catch (Exception e) {
			//log the exception
			myLogger.warning(e.getMessage());
			//give the user a custom messsage
			result = "Major accident! But no wories";
		}
		
		//get the time stamp
		long end = System.currentTimeMillis();
		long duration = end - begin;
		myLogger.info("\n------->> Duration: "+duration/1000.00 + " seconds");
		
		return result;
	}
	
	
	//add a new advice @After on findAccount method..this will run on success or failure 
	@After("execution(* com.ghassan.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterAdviceFindAccount(JoinPoint theJoinPoint) {
		//print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n------->> Executing @After on method: "+method);
	}
	
	//add a new advice @AfterThrowing on findAccount method
	@AfterThrowing(
			pointcut="execution(* com.ghassan.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing = "theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		//print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n------->> Executing @AfterThrowing on method: "+method);
		
		//log the exception
		myLogger.info("\n------->> The exception: "+theExc);
	}
	
	//add a new advice @AfterReturning on the findAccount method
	@AfterReturning(
			pointcut="execution(* com.ghassan.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		//proint out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		myLogger.info("\n------->> Executing @AfterReturing on method: "+method);
		
		//print the results of the method call
		myLogger.info("\n------->> result is: "+method);
		
		//Post process data...modify it before send it to the caller
		//convert the account name to uppercase
		converAccountNamestoUpperCase(result);
		
		myLogger.info("\n------->> result is: "+method);
	}
	
	private void converAccountNamestoUpperCase(List<Account> result) {
		//foreach account make name uppercase
		for(Account account: result) {
			String nameToUpper = account.getName().toUpperCase();
			account.setName(nameToUpper);
		}
		
	}

	@Before("com.ghassan.aopdemo.aspect.AopPointcutExp.forDaoPackageNoGetterSetter() ")
	private void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
	
		myLogger.info("\n-------->> Executing @Before advice on addAccount()");
		
		//Display the method signature
		MethodSignature theSignature = (MethodSignature) theJoinPoint.getSignature();
		myLogger.info("Method: "+theSignature);
		
		//Display the method arguments
		Object[] args = theJoinPoint.getArgs();
		for(Object arg: args) {
			myLogger.info(arg.toString());
			
			if(arg instanceof Account) {
				Account theAccount = (Account)arg;
				myLogger.info("account name: " + theAccount.getName() );
				myLogger.info("account level: " + theAccount.getLevel() );
			}
		}
	}
}
