package com.ghassan.aopdemo;

import java.util.List;
import java.util.logging.Logger;

import javax.xml.xpath.XPathConstants;

import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ghassan.aopdemo.dao.AccountDAO;
import com.ghassan.aopdemo.dao.MembershipDAO;
import com.ghassan.aopdemo.service.TrafficFortuneService;


public class AroundHandleExcptionDemoAPP {

	//Around advice @Around:
	//-we can handle the exception (throw it/sallow / stop it)
	
	//set up a logger
	private static Logger myLogger = 
			Logger.getLogger(AroundHandleExcptionDemoAPP.class.getName());
	public static void main(String[] args) {
		
		//read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the beans from the spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService",
				TrafficFortuneService.class);
		
		myLogger.info("\nMain Program: AroundAdviceDemoApp");
		myLogger.info("Calling getFortune");
		boolean tripWire = true;
		String data = theFortuneService.getFortune(tripWire); 
		
		myLogger.info(data);
		myLogger.info("Finished");
		//close the context
		context.close();

	}

}
