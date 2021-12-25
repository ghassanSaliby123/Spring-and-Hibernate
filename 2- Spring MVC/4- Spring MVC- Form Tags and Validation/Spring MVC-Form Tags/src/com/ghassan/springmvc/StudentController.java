package com.ghassan.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

	
	//This method will get the student info through Spring Form tag and store it in the Model
	@RequestMapping("/showForm")
	private String showForm(Model theModel) {
		//Create a student object
		Student student = new Student();
		
		// add student object to the model
		theModel.addAttribute("student",student);
		
		return "student-form";
	}
	
	//This method will retrieve the stored student from the model
	@RequestMapping("/processForm")
	public String processForm(@ModelAttribute("student") Student student) {
		
		System.out.println("Student "+ student.getFirstName()+ " "+ student.getLastName()+
				" has been registered.");
		return "student-confirmation";
	}
}













