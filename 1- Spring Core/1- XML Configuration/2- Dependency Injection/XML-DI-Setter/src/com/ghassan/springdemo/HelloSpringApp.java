package com.ghassan.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
	//- The Dependency Injection is a  technique in which an object receives other 
	//  objects that it depends on, called dependencies 
	//  For example creating a Car depends on creating an engine. When we add this dependency to 
	// 	our configuration, the framework will create an engine for us hen we want to create a Car
	
	//1- This example illustrates the DI in Spring by Setter Injection
	//A- Define the dependency interface and class 
	//	In our case FortuneSerive is the interface the HappyFortunService implements it
	//B- Then we create a setter method in the class that I want to inject the FortunService
	//	interface to it. We will make the CricketCoach depends on the FortunService 
	//	We inject this interface into the CricketCoach setter for FortunService then we call the FortunService
	//	methods 
	//C- We add a bean to XML for the Class that implement the interface which is
	//	HappyFortuneService :  <bean id="happyFortuneService"
	//									class= "com.ghassan.springdemo.HappyFortuneService">
	//D- Then we add the DI to XML file inside the CricketCoach as a property
	//	<bean id="cricketCoach"
	//			class="com.ghassan.springdemo.CricketCoach">
	//			 			<!-- Set up Setter injection -->
	//			 <property name = "The setter method name without _set_"  ref="happyFortuneService"> </property
	//	</bean>
	//E-  We should provide a no args constructor for CricketCoach
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
		Coach cricketCoach = context.getBean("cricketCoach", Coach.class);//DI through setter
		
		//call methods on the bean
//		System.out.println(baseballCoach.getDailyWorkOut());
//		System.out.println(trackCoach.getDailyWorkOut());
		System.out.println(cricketCoach.getDailyWorkOut());
		
		//Call the method from the injected interface
//		System.out.println(baseballCoach.getDailyFortune());
//		System.out.println(trackCoach.getDailyFortune());
		System.out.println(cricketCoach.getDailyFortune());
		
		//close the context
		context.close();
	}

}
