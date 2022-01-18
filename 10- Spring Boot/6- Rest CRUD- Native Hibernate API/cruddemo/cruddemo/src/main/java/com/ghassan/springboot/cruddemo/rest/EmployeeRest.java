package com.ghassan.springboot.cruddemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ghassan.springboot.cruddemo.entity.Employee;
import com.ghassan.springboot.cruddemo.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRest {

	//inject the service
	@Autowired 
	EmployeeService employeeService;
	
	//Define endpoints to get all employees 
	@GetMapping("/employees")
	public List<Employee> findAll(){
		return employeeService.findAll();
	}
	
	//Define endpoints to get employee by Id 
	@GetMapping("/employees/{employeeId}")
	public Employee findEmployee(@PathVariable int  employeeId){
		return employeeService.findById(employeeId);
	}
	
	//Define endpoints to add employee
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee theEmployee){
		//set the id to 0 to insert the new employees
		theEmployee.setId(0);
		employeeService.save(theEmployee);
		return theEmployee;
	}
	
	//Define endpoints to update employee
	@PutMapping("/employees")
	public Employee updateEmployee(@RequestBody Employee theEmployee){
		employeeService.save(theEmployee);
		return theEmployee;
	}
	
	//Define endpoints to delete employee by Id
	@DeleteMapping("/employees/{employeeId}")
	public String  deleteEmployee(@PathVariable int employeeId){
		Employee temEmployee= employeeService.findById(employeeId);
		if (temEmployee == null) {
			throw new RuntimeException("Employee not found");
		}
		employeeService.deleteById(employeeId);
		return "Employee is deleted";
	}
}
