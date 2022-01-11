package com.ghassan.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(7)
public class MyApiAnalyticAspect {

	@Before("com.ghassan.aopdemo.aspect.AopPointcutExp.forDaoPackageNoGetterSetter() ")
	public void performApiAnalytics() {
		System.out.println("\n-------->> Performing API Analysis");
	}
}
