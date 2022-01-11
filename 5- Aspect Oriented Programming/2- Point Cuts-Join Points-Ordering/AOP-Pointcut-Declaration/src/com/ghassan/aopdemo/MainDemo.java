package com.ghassan.aopdemo;

import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ghassan.aopdemo.dao.AccountDAO;
import com.ghassan.aopdemo.dao.MembershipDAO;

public class MainDemo {

	//Ordering Aspects
	//- If we have several advises and we care about the order of executing them 
	//1- We should separate these advises into several Aspects
	//2- Annotate each Aspect with @Order to define the order of the execution 
	// The priority for low value to high value and accept negative values 
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
