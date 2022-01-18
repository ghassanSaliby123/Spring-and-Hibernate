package com.ghassan.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
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
	//  @Before("execution(* com.ghassan.aopdemo.dao.*.*(..))")
	//-------------------------------------------------------------------
	//- Pointcuts:
	//- Declare a pointcut to be used by advises
	//  @Pointcut("execution(* com.ghassan.aopdemo.dao.*.*(..))")
	//	private void forDaoPackage() {}
	
	//- Combine expressions pointcuts
	//- Match all method in package EXCEPT getter and setter
	//1- create a pointcuts for getter and setter
	//2- create a pointcut for the package
	//3- combine the pintcuts in a  new point cut 
	//4- apply the new pointcut to the advice
	
	//1-
	@Pointcut("execution(* com.ghassan.aopdemo.dao.*.get*(..))")
	private void getter() {}
	@Pointcut("execution(* com.ghassan.aopdemo.dao.*.set*(..))")
	private void setter() {}
	//2- 
	@Pointcut("execution(* com.ghassan.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	//3- 
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}
	//4-
	@Before("forDaoPackageNoGetterSetter() ")
	private void beforeAddAccountAdvice() {
		
		System.out.println("\n-------->> Executing @Before advice on addAccount()");
	}
	
	@Before("forDaoPackageNoGetterSetter() ")
	public void performApiAnalytics() {
		System.out.println("\n-------->> Performing API Analysis");
	}
}
