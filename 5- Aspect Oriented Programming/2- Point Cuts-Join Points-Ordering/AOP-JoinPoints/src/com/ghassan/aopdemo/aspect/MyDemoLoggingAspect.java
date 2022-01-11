package com.ghassan.aopdemo.aspect;

import java.util.Iterator;

import org.aspectj.lang.JoinPoint;
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
