package com.ghassan.springmvc.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

	//define default course code
	public String value() default "JAVA";

	//define default error message
	public String message() default "must start with JAVA";
	
	//define default groups. Groups can group related constraints
	public Class<?>[] groups() default {};
	
	//define default payloads. Provide custom details about validation failure(severity level, error code ...)
	public Class<? extends Payload>[] payload() default {};

	

}
