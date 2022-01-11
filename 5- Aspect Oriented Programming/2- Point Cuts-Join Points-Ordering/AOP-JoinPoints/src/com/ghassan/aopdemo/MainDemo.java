package com.ghassan.aopdemo;

import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ghassan.aopdemo.dao.AccountDAO;
import com.ghassan.aopdemo.dao.MembershipDAO;

public class MainDemo {

	//Access and display method signature
	//- Through the method advice we can access the joint point method signature 
	//	by adding JoinPoint object to the advice method then we get MethodSignature
	// 	MethodSignature = (MethodSignature) JoinPoint.getSignature();
	//- We can also access the method arguments by the JoinPoint object as well
	//	Object[] args = JoinPoint.getArgs(); it will return the args values
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
		account.setName("Mad");
		account.setLevel("Plat");
		theAccountDAO.addAccount(account,true);
		theAccountDAO.doWork();
		
		themebershipDAO.addAccount();
		themebershipDAO.goToSleep();
		
		//close the context
		context.close();

	}

}
