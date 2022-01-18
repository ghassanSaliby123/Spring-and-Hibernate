package com.ghassan.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	//Jackson  project for databind
	//- We use the ObjectMapper to bind JSON to POJO and POJO to JSON
	//	through the mapper object we read JSON values from file and map it to Student object
	//- In the Student side we should provide getters and setters
	//- On the Class that mapped to JSON (Student) we can ignore fields for mapping
	//	by annotating the class with @JsonIgnoreProperties(ignoreUnkown = true)
	
	public static void main(String[] args) {

		try {
			//create object mapper
			ObjectMapper objectMapper = new ObjectMapper();
			
			//read json file and map to java pojo
			Student theStudent = objectMapper.readValue(new File("data/sample-full.json"), Student.class);
			
			//print the first name and last name
			System.out.println("Student name: "+theStudent.getFirstName() +" "+ theStudent.getLastName());
			System.out.println("Student address: "+ theStudent.getAddress());
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
