package com.ghassan.springmvc;

public class SpringMvcHello {

	//Spring MVC Form Validation 
	//Spring can apply validation on the HTMl form with libraries from Hibernate validator
	//@NOTNULL, @Min, @Max,@Size, @Furture, @Past,@Patern and so on...Custom validation
	
	//Depending on the validation, the request goes to the controller, If the condition has been violated
	//The controller will send an error message back to the user.
	//If the input is accepted the controller will save the data in the Model and send confirmation
	//message back to the user
	//Ex: make a field required 
	//1- @NotNull(message="if the condition is broke")
	//@Size(min=1, message ="if the condition is broke")
	//private String fieldName
	//2- Then in the Jsp file we add entry for showing error message and its path is the same of the field name
	//<form:errors path="fieldName" cssClass="error"/>
	//3- Then we perform the validation in the controller class
	//We add @Valid to show that we want to validate the object then we add BindingResult to have the results of the
	//validation
	//@Valid should directly before @ModelAttribute, and BindingResult should be the second argument after the model
	//otherwise the validation will not work probably 
	//Depending on the results BindingResult.hasErrors() we return to the confirmation page or the user form 
	//If everything is OK we return the data to the confirmation page to show them there
	
	//We can use @InitBinder for methods to pre-process all the request before it goes to the controller method
	
	//In this example we make custom annotation to check custom validation ...Check validation sub-package
	//@CourseCode
	public static void main(String[] args) {
	
	}

}
