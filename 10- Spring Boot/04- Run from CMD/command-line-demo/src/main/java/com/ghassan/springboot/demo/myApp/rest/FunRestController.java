package com.ghassan.springboot.demo.myApp.rest;

import java.time.LocalDate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

	
	@GetMapping("/")
	public String sayHello() {
		return "Hello World! Time on server is:  "+ LocalDate.now();
	}
	
	@GetMapping("/workout")
	public String getDailyWorkout() {
		return "Run hard 5k";
	}
	
	@GetMapping("/fortune")
	public String getDailyfortune() {
		return "Today is your lucky day";
	}
}
