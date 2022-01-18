package com.ghassan.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
	//Bean Scope and Lifecycle refers to :
	//-How long does Bean live
	//-How many instance are created
	//-How is the bean shared
	
	//There are 5 Scopes for bean: Singleton, Prototype, Request, Session, Global-Session
	
	//By default the bean scope is Singleton which means 
	// - Spring container creates one instance if the bean
	// - it is cached in memory 
	// - all request for the bean will return a Shared instance to the same bean
	//We define the bean scope in the XML through <bean id=""  class="" scope="singleton">
	
	//As for the prototype scope 
	//- a new object will created for each request
	//We define the bean scope in the XML through <bean id=""  class="" scope="prototype">
	public static void main(String[] args) {
		

		//load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve beans from spring container
//		Coach trackCoach1 = context.getBean("trackCoach", Coach.class);//Scope=singleton
//		Coach trackCoach2 = context.getBean("trackCoach", Coach.class);//Scope=singleton
		
		Coach trackCoach1 = context.getBean("trackCoach", Coach.class);//Scope=prototype
		Coach trackCoach2 = context.getBean("trackCoach", Coach.class);//Scope=prototype
		
		//check if they are the same
		if (trackCoach1 == trackCoach2) {
			System.out.println("They are pointing to the same object");
		}else {
			System.out.println("They are pointing to different objects");
		}
		System.out.println("There memory location are : \n" + trackCoach1 + "\n"+trackCoach2);
		
		
		//close the context
		context.close();
	}

}