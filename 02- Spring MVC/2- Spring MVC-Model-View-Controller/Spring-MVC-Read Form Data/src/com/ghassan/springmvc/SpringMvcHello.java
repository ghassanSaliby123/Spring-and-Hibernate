package com.ghassan.springmvc;

public class SpringMvcHello {

//1- Create Controller class
//		define a class and annotated with @Controller which inherits 
//		from @Componenet which means when spring scan for beans it will
//		register the Controller class
//		@Controller
//		class HomeController{}
//2- Define controller methods
//		String viewMyPage(){}
//3- add request mapping to Controller method
//		We do that by annotating the method with @RequestMapping("url")
//		this means the request for URL will go this method
//		@RequestMapping("/")
//		String viewMyPage(){}
//4- Return a View name
//		return the view name inside the controller method
//		String viewMyPage(){return webPageName;}
//5- Develop View page
//		Build html or jsp page
	public static void main(String[] args) {
	
	}

}
