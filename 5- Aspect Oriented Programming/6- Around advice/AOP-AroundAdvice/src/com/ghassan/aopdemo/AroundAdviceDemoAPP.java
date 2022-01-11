package com.ghassan.aopdemo;

import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ghassan.aopdemo.dao.AccountDAO;
import com.ghassan.aopdemo.dao.MembershipDAO;
import com.ghassan.aopdemo.service.TrafficFortuneService;

public class AroundAdviceDemoAPP {

	//Around advice @Around:
	//- This type of advice is called before and after the execution of the method 
	//- It can be used for logging, auditing, security
	//- To know how to take the method to be executed
	//- To manage the exception
	//- Proceeding Joinpoint: handle the target method 
	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the beans from the spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService",
				TrafficFortuneService.class);
		
		System.out.println("\nMain Program: AroundAdviceDemoApp");
		System.out.println("Calling getFortune");
		System.out.println(theFortuneService.getFortune());
		//close the context
		context.close();

	}

}
