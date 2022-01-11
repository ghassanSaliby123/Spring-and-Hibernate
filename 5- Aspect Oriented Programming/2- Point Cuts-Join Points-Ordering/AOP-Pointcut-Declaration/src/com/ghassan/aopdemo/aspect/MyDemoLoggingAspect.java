package com.ghassan.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyDemoLoggingAspect {
	
	@Before("com.ghassan.aopdemo.aspect.AopPointcutExp.forDaoPackageNoGetterSetter() ")
	private void beforeAddAccountAdvice() {
	
		System.out.println("\n-------->> Executing @Before advice on addAccount()");
	}
}
