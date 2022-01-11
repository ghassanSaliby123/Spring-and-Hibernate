package com.ghassan.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	//This is where we add our related Advices for logging
	
	//- Match on addAccount in any class
	//  @Before("execution(public void addAccount())")
	//- Match only addAccount in AccountDAO
	//  @Before("execution(public void com.ghassan.aopdemo.dao.AccountDAO.addAccount())")
	//- Match any method starts with add in any class
	//	@Before("execution(public void add*())")
	//- Match add* with any return type with one arg of type Account in any class
	//	@Before("execution(* add*(com.ghassan.aopdemo.Account))")
	//- Match add* with any return type with one arg of type Account AND other args in any class
	//	@Before("execution(* add*(com.ghassan.aopdemo.Account, ..))")
	//- Match add* with any return type with any number of args in any class
	//  @Before("execution(* add*(..))")
	//- Match any method with any return type with any number of args in any class of a specific package
	@Before("execution(* com.ghassan.aopdemo.dao.*.*(..))")
	private void beforeAddAccountAdvice() {
		
		System.out.println("\n-------->> Executing @Before advice on addAccount()");
	}
	
}
