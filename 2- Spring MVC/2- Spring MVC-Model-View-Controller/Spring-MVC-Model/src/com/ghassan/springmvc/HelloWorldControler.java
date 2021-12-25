package com.ghassan.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.support.AbstractMultipartHttpServletRequest;

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
	
	//Define a new Controller method to read form data
	//and add data to the Model
	@RequestMapping("/processFormVersion2")
	public String readWriteFromModel(HttpServletRequest request, Model model) {
//		
	//read the request parameter from the Html form
		String name = request.getParameter("studentName");

		//convert data to all caps
		name = name.toUpperCase();

		//create the message
	String result = "Hello "+ name;
		
	//add the message to the Model
	model.addAttribute("message", result);
	return "helloworld";
	}
}



















