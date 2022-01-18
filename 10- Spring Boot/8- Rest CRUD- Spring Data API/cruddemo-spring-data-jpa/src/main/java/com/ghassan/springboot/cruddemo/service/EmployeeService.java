package com.ghassan.springboot.cruddemo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ghassan.springboot.cruddemo.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();
	
	public Employee findById(int theId);
	
	public void save(Employee theEmployee);
	
	public void deleteById(int theId);
}
