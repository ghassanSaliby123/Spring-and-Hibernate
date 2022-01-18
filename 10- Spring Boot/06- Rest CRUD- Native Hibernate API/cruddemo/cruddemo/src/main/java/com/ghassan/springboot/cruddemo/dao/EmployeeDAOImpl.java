package com.ghassan.springboot.cruddemo.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
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
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//create a Query
		Query<Employee> theQuery = 
				currentSession.createQuery("from Employee ",Employee.class);
		
		//execute query and get result list
		List<Employee> employees = theQuery.getResultList();
		
		//return the results
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//get employee by id
		Employee theEmployee = currentSession.get(Employee.class, theId);
	
		//return the results
		return theEmployee;
	}

	@Override
	public void save(Employee theEmployee) {
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//save employee (if id = 0 it is insert, else it is update)
		currentSession.saveOrUpdate(theEmployee);
	
	}

	@Override
	public void deleteById(int theId) {
		//get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//create a Query
		Query<Employee> theQuery = 
				currentSession.createQuery("delete from Employee where id=:employeeId",Employee.class);
		theQuery.setParameter("employeeId", theId);
		//delete employee by id
		theQuery.executeUpdate();	
	}

}
