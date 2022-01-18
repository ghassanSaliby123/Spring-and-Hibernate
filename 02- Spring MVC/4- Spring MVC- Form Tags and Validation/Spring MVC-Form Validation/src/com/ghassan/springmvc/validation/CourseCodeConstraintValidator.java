package com.ghassan.springmvc.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator implements ConstraintValidator<CourseCode, String>{

	//WE validate against prefix
	private String coursePrefix;
	
	//initialize with the value
	@Override
	public void initialize(CourseCode theCourseCode) {
		coursePrefix = theCourseCode.value();
	}

	//validation logic
	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {
		boolean result;
		if(theCode != null) {
			 result = theCode.startsWith(coursePrefix);
		}else {
			result = false;
		}
		return result;
	}
}
