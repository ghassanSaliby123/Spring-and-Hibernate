package com.ghassan.springmvc;

public class SpringMvcHello {

	//Spring MVC Form Tags are configurable and reusable
	//They support data bindings so they automatically setting/ retrieving data from java objects
	//They generate Html for us
	//from:form -->main form container
	//form:input --> text field
	//form:textarea, form:checkbox, form:radiobutton, form:select
	
	//We use these tags inside the JSP page by adding the Spring namespace at the beginnig of Jsp file
	//<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	
	//With Spring form tags we don't need the @RequestParam 
	//We will directly add the data to the Model through addAttribute() method
	//inside the form:form which is the main container, we define the attribute name through modelAttribute
	//then for each tag we define a path. This path contains the name of the getter method for this attribute
	//For example <form:input path=firstName> Spring will call getFirstName method and it will be added to Model
	//so no need to use @RequestMapping
	//We we hit submit button, Spring will call the setter method. It takes the value from the Model then assign it 
	// to the field firstName
	
	//On the controller side when we want to read the data that is submitted, we retrieve the data from Model
	//through @modelAttribute("AttributName") 
	//To show the retrieved data on JSP we simply call the attributName.field ${attributName.field}
	public static void main(String[] args) {
	
	}

}
