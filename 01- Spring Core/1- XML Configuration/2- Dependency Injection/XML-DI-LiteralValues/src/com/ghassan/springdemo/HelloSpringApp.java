package com.ghassan.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
	//- The Dependency Injection is a  technique in which an object receives other 
	//  objects that it depends on, called dependencies 
	//  For example creating a Car depends on creating an engine. When we add this dependency to 
	// 	our configuration, the framework will create an engine for us hen we want to create a Car
	
	//1- This example illustrates the DI for literal values in Spring by Setter Injection
	//A- Define Setter methods in the class for injections we use the basktballCoach class
	//B- Then we add the DI to XML file inside the CricketCoach as a property
	//	<bean id="basketballCoach"
	//			class="com.ghassan.springdemo.basketballCoach">
	//			 			<!-- Set up Setter injection -->
	//			 <property name = "The setter method name without _set_"  value="happyFortuneService"> </property
	//	</bean>
	//
	//2- In the main app we load the spring config file which is our application context and sometimes it is referred as a Spring Container
	//	we do that through the context = ClassPathXmlApplicationContext(the xml file name)
	//3- We retrieve the beans from the container through context.getBean(theBeanId, interface.class)
	//	here we call the baseballCoach bean which we inject the dependency to it
	//4- We call methods from the bean 
	//5- We close the context through the close method 
//The application context is mostly referred as Spring container
	public static void main(String[] args) {
		

		//load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve beans from spring container
//		Coach baseballCoach = context.getBean("baseballCoach", Coach.class);//DI through constructor
//		Coach trackCoach = context.getBean("trackCoach", Coach.class);//DI through constructor
//		Coach cricketCoach = context.getBean("cricketCoach", Coach.class);//DI through setter
		BasketballCoach basketballCoach = context.getBean("basketballCoach", BasketballCoach.class);//Setter DI for literals 
		
		
		//call methods on the bean
//		System.out.println(baseballCoach.getDailyWorkOut());
//		System.out.println(trackCoach.getDailyWorkOut());
//		System.out.println(cricketCoach.getDailyWorkOut());
		System.out.println("Team name : "+ basketballCoach.getTeam()+", Team email :"+
		basketballCoach.getEmailAddress());
		
		
		//Call the method from the injected interface
//		System.out.println(baseballCoach.getDailyFortune());
//		System.out.println(trackCoach.getDailyFortune());
//		System.out.println(cricketCoach.getDailyFortune());
		
		//close the context
		context.close();
	}

}