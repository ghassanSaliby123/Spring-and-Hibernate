package com.luv2code.springdemo.dao;

import java.util.List;

import javax.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//Need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;//This autoWired with the bean registered in XML file

	@Override
	public List<Customer> getCustomers() {
		// get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		//create a query....sort by the last name
		Query<Customer> theQuery = currentSession.createQuery("from Customer order by lastName", Customer.class);
				
		//get the result from executing the query
		List<Customer> customers = theQuery.getResultList();
				
		//return the results
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCsutomer) {
		// get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		//create a query
		currentSession.saveOrUpdate(theCsutomer);
		
	}
	
	@Override
	public Customer getCustomers(int theId) {
		// get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
						
		//create a query
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}

	@Override
	public void deleteCustomer(int theId) {
		// get the current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query to delete the customer
		Query theQuery = currentSession.createQuery("delete from Customer where id=:customerId");
		
		theQuery.setParameter("customerId", theId);
		
		theQuery.executeUpdate();
		
		
		
	}
}
