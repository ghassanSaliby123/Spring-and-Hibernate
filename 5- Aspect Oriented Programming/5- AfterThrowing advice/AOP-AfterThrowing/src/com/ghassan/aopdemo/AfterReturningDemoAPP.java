package com.ghassan.aopdemo;

import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ghassan.aopdemo.dao.AccountDAO;
import com.ghassan.aopdemo.dao.MembershipDAO;

public class AfterReturningDemoAPP {

	//AfterReturning:
	//- This type of advice is called after the success execution of the method
	// 	@AfterReturning(pointcut, returning="result")-->the result which is returned by the method
	//	void afterReturningMethod(JoinPoint, List result)
	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the beans from the spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		//call the method to find accounts
		List<Account> theAccounts  = theAccountDAO.findAccounts();

		System.out.println("\nMain Program : AfterReturingDemoAPP");
		System.out.println("-------");
		System.out.println(theAccounts);
		//close the context
		context.close();

	}

}
