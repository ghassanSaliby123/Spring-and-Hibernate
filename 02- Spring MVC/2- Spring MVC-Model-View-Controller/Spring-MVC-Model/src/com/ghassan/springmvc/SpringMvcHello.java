package com.ghassan.springmvc;

public class SpringMvcHello {

//As illustrated, model is the data container in Spring MVC
//We can read and write any type of data to the model
//In the Controller we can put anything in the Model (String, Object, info from Database...)
//The Jsp pages can access data from the Model as well
//This example contains a Controller that read data from request->convert to uppercase-->add it to the model
//then the jsp page read this data from the model
//@Requestmaping
//	String showForm(HttpServletRequest request, Model model){
//	name= request.getParameter(parameter name)
//	name.toUpperCase;
//  model.addAttribute("Attribute name", Attribute value(name))
//	return jsp page name;}

//On the jsp side we just write ${attribute name}
	public static void main(String[] args) {
	
	}

}
