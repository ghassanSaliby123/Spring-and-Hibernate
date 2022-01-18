package com.ghassan.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {
	//- The Inversion of Control is a way to invert the program flow of control as compared to traditional control flow
	//It basically means out-sourcing the construction and the management of the objects to be done by the framework
	//- This example illustrates the IoC in Spring by XML configuration
	//1- We define the beans within the applicationContext.xml file through <bean id= '' class= ''> tag to allow the Spring framework
	//	to managing the construction of the beans(Objects)
	//	For EX:  <bean id="baseballCoach"
	//				class="com.ghassan.springdemo.BaseballCoach">
    //			 </bean>
	//2- In the main app we load the spring config file which is our application context and sometimes it is referred as a Spring Container
	//	we do that through the context = ClassPathXmlApplicationContext(the xml file name)
	//3- We retrieve the beans from the container through context.getBean(theBeanId, interface.class)
	//4- We call methods from the bean 
	//5- We close the context through the close method 
//The application context is mostly referred as Spring container
	public static void main(String[] args) {
		

		//load the spring configuration file
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext.xml");
		
		//retrieve beans from spring container
		Coach baseballCoach = context.getBean("baseballCoach", Coach.class);
		Coach trackCoach = context.getBean("trackCoach", Coach.class);
		Coach basketballCoach = context.getBean("basketballCoach", Coach.class);
		
		//call methods on the bean
		System.out.println(baseballCoach.getDailyWorkOut());
		System.out.println(trackCoach.getDailyWorkOut());
		System.out.println(basketballCoach.getDailyWorkOut());

		
		//close the context
		context.close();
	}

}
