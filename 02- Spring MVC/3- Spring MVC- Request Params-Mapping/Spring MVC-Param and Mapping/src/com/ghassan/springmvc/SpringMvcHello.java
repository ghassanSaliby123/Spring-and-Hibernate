package com.ghassan.springmvc;

public class SpringMvcHello {

//As we've seen that we can get a parameter from the request through HtttpServletRequest.getParameter("name")
//Then we store it in the Model.addAttribute("Attribute name", value)
	//Spring uses another annotation which is @RequestParam("parameter name") which gets the parameter from the request
	
	//We can group all requests to the controller by adding @RequestMapping to the Controller class
	//For example we can add @RequestMapping("/controller")
	//Then for all the controller methods the URL will be /controller/showForm  Or /controller/processForm
	//This technique helps if other methods in other controller have the same requestMapping 
	//This helps to distinguish between these methods
	public static void main(String[] args) {
	
	}

}
