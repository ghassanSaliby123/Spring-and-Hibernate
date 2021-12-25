package com.ghassan.springmvc;

public class SpringMvcConfiguration {

//	Spring MVC Configuration:
//	Web browser --> 
//		Front controller(Dispatcher servlet) which handle the requests 
//		and direct them the proper controller
//	-->(model) Controller which contains the business logic it takes
//		data from the model and send it to view template
//		here the new data might stored in the model as well
//	--> view template that takes the data from model and render it 
//---------------------Add Configuration XML files--------------------------------------------------
//	- Add configurations to file : WEB-INF/web.xml
//1- configure the spring-mvc dispatcher servlet (the front controller)
//	a- We add entry for a servlet 
//		<servlet>
//			<servlet-name> dispatcher 
//			<servlet-class> this comes with spring mvc
//		</servlet>
//	b- then we add initialization parameters to tell where the spring 
//		configuration file is located
//		<init-param>
//			<param-name>contextConfiguration
//			<param-value>location of the file
//		</init-param>
	
//	2- set up URL mapping to spring mvc-dispatcher servlet
//	   Then we set up the URL mapping to the servlet dispatcher
//  	Here we say that all the request should come first to the servlet
//		dispatcher (the Front Controller)
// 		and then the latter will direct them the proper controller
//		<servlet-mapping>
//			<servlet-name>dispatcher
//			<url-pattern>/
//		</servlet-mapping>
//----------------------------------------------------------------
//	- Add configurations to file : WEB-INF/spring-mvc-demo-servlet.xml
//	3- Add support for component scanning 
//		add the context:component-scan to scan and register all the beans
	
//	4- Add support for conversion, formating and validation
//	<mvc:annotation-driven>
	
//	5- Configure spring mvc view resolver
//	we add a bean for the spring mvc view resolver
//	it describes where to store the pages and how to name them
	public static void main(String[] args) {
	
	}

}
