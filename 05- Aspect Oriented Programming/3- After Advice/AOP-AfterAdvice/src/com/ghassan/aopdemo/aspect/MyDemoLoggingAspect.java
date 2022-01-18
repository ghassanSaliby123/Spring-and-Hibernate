package com.ghassan.aopdemo.aspect;

import java.util.Iterator;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
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
	
	//add a new advice @After on findAccount method..this will run on success or failure 
	@After("execution(* com.ghassan.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterAdviceFindAccount(JoinPoint theJoinPoint) {
		//print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n------->> Executing @After on method: "+method);
	}
	
	//add a new advice @AfterThrowing on findAccount method
	@AfterThrowing(
			pointcut="execution(* com.ghassan.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing = "theExc")
	public void afterThrowingFindAccountsAdvice(JoinPoint theJoinPoint, Throwable theExc) {
		//print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n------->> Executing @AfterThrowing on method: "+method);
		
		//log the exception
		System.out.println("\n------->> The exception: "+theExc);
	}
	
	//add a new advice @AfterReturning on the findAccount method
	@AfterReturning(
			pointcut="execution(* com.ghassan.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning = "result")
	public void afterReturningFindAccountsAdvice(JoinPoint theJoinPoint, List<Account> result) {
		//proint out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n------->> Executing @AfterReturing on method: "+method);
		
		//print the results of the method call
		System.out.println("\n------->> result is: "+method);
		
		//Post process data...modify it before send it to the caller
		//convert the account name to uppercase
		converAccountNamestoUpperCase(result);
		
		System.out.println("\n------->> result is: "+method);
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
	
		System.out.println("\n-------->> Executing @Before advice on addAccount()");
		
		//Display the method signature
		MethodSignature theSignature = (MethodSignature) theJoinPoint.getSignature();
		System.out.println("Method: "+theSignature);
		
		//Display the method arguments
		Object[] args = theJoinPoint.getArgs();
		for(Object arg: args) {
			System.out.println(arg);
			
			if(arg instanceof Account) {
				Account theAccount = (Account)arg;
				System.out.println("account name: " + theAccount.getName() );
				System.out.println("account level: " + theAccount.getLevel() );
			}
		}
	}
}
