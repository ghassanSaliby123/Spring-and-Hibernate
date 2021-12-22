package com.ghassan.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
	//Bean Scope and Lifecycle refers to :
	//-How long does Bean live
	//-How many instance are created
	//-How is the bean shared
	
	//Bean Lifecycle:
	//Container started --> Bean Instantiated --> Dependencies Injected --> Internal Spring Process
	//-->Our custom INIT METHODS-->Bean is ready
	//When context.close() --> container is shutdown and call our DESTROY METHODS
	
	//We define the init and destroy methods in our class then 
	//Through XML config we add attribute to bean
	// 	<bean id="" class="" init-method="method name for init"
	//							destroy-method= "method name for destroy">
	
	
	//Init and destroy methods can have: any access modifier, any return type commonly void,
	//any name , but should not accept arguments
	public static void main(String[] args) {
		

		//load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve beans from spring container
		Coach trackCoach = context.getBean("trackCoach", Coach.class);//init and destroy
		
		//check the init and destroy methods
	
		
		//close the context
		context.close();
	}

}