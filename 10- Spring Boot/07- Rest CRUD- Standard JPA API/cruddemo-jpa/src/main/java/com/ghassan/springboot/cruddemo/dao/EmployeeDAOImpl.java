package com.ghassan.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.ghassan.springboot.cruddemo.entity.Employee;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

	//define EntityManage( it is the same of sessionFacotry, it wraps the session object)
	//When we want to get the session we just unwrap it
	//EntityManager depends on dataSource object<< both of them are created and registered by spring boot
	
	@Autowired
	EntityManager entityManager;
	
	@Override
	public List<Employee> findAll() {
		
		//create a Query from javax.persist
		Query theQuery = 
				entityManager.createQuery("from Employee ");
		
		//execute query and get result list
		List<Employee> employees = theQuery.getResultList();
		
		//return the results
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		
		//get employee by id
		Employee theEmployee = entityManager.find(Employee.class, theId);
	
		//return the results
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
			
		//save employee (if id = 0 it is insert, else it is update)
		Employee dbEmployee= entityManager.merge(theEmployee);
		
		//set the returning generated id
		theEmployee.setId(dbEmployee.getId());
	}

	@Override
	public void deleteById(int theId) {
		
		//create a Query
		Query theQuery = 
				entityManager.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
		
		//delete employee by id
		theQuery.executeUpdate();	
	}

}
