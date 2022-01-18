package com.ghassan.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;


//Antoher controller
@Controller
@RequestMapping("/home")
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
		
		//Define a new version of readWrireFromModel with using @RequestParam
		//It reads the param from the request and bind it with String name
		@RequestMapping("/processFormVersionThree")
		public String readParamAddToModel(@RequestParam("studentName") String name, Model model) {
			//convert data to all caps
			name = name.toUpperCase();

			//create the message
			String result = "Hello from @RequestParam "+ name;
					
			//add the message to the Model
			model.addAttribute("message", result);
			return "helloworld";
		}

	}
