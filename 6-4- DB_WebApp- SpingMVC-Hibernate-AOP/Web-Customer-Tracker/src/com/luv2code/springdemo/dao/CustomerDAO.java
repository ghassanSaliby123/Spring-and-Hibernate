package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;

//CustomerDAO interface for DI
public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCsutomer);

	public Customer getCustomers(int theId);

	public void deleteCustomer(int theId);
}
