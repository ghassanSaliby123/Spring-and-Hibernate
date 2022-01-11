package com.ghassan.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopPointcutExp {

	@Pointcut("execution(* com.ghassan.aopdemo.dao.*.get*(..))")
	public void getter() {}
	@Pointcut("execution(* com.ghassan.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	@Pointcut("execution(* com.ghassan.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {}
	
}
