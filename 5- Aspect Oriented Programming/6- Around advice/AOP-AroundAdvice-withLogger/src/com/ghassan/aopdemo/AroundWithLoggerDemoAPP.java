package com.ghassan.aopdemo;

import java.util.List;
import java.util.logging.Logger;

import javax.xml.xpath.XPathConstants;

import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ghassan.aopdemo.dao.AccountDAO;
import com.ghassan.aopdemo.dao.MembershipDAO;
import com.ghassan.aopdemo.service.TrafficFortuneService;


public class AroundWithLoggerDemoAPP {

	//Around advice @Around:
	//-Use logger to sync all the messages 
	
	//set up a logger
	private static Logger myLogger = 
			Logger.getLogger(AroundWithLoggerDemoAPP.class.getName());
	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the beans from the spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService",
				TrafficFortuneService.class);
		
		myLogger.info("\nMain Program: AroundAdviceDemoApp");
		myLogger.info("Calling getFortune");
		myLogger.info(theFortuneService.getFortune());
		//close the context
		context.close();

	}

}
