package com.ghassan.springboot.cruddemo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ghassan.springboot.cruddemo.dao.EmployeeRepository;
import com.ghassan.springboot.cruddemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public List<Employee> findAll() {
		
		return employeeRepository.findAll() ;
	}

	@Override
	public Employee findById(int theId) {
		
		Optional<Employee> result = employeeRepository.findById(theId);
		
		Employee theEplEmployee = null;
		if (result.isPresent()) {
			theEplEmployee = result.get();
		}
		return theEplEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		
		employeeRepository.save(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		
		employeeRepository.deleteById(theId);
	}

}
