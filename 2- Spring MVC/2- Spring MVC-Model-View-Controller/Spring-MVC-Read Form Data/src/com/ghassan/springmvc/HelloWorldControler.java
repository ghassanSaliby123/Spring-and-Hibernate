package com.ghassan.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//Antoher controller
@Controller
public class HelloWorldControler {

	//Define a controller method to show the initial html form
	@RequestMapping("/showForm")
	public String showForm() {
		//return the page name. it will turn to /WEB-INF/view/helloworld.jsp
		return "helloworld-form";
	}
	
	////Define a controller method to process the html form
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
}
