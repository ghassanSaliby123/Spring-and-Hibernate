package com.ghassan.aopdemo;

import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ghassan.aopdemo.dao.AccountDAO;
import com.ghassan.aopdemo.dao.MembershipDAO;

public class MainDemo {

	//Pointcut declaration
	//- We can declare a point cut expression and reuse it through several methods advises
	//	@Pointcut("execution(* com.ghassan.aopdemo.dao.*.*(..))")
	//	public void forDaoPackage(){}
	//- In the method advice we type
	// 	@Before("forDaoPackage()")
	//- We can combine pointcuts with && || ! 
	// @Before("exp1() && exp2()")
	// @Before("exp1() || exp2()")
	// @Before("exp1() && !exp2()")
	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the beans from the spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
		MembershipDAO themebershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		//call the AccountDAO getter/setter
		theAccountDAO.setName("foorbar");
		theAccountDAO.setServiceCode("silver");
		
		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();
		
		//call the business method
		Account account = new Account();
		theAccountDAO.addAccount(account,true);
		theAccountDAO.doWork();
		
		themebershipDAO.addAccount();
		themebershipDAO.goToSleep();
		
		//close the context
		context.close();

	}

}
