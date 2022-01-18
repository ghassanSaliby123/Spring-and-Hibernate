package com.luv2code.springdemo.rest;

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

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	//inject the customer service
	@Autowired
	private CustomerService customerService;
	
	//add mapping for  GET/customers
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		return customerService.getCustomers();
	}
	
	//add mapping for GET/customers/{customerId}
	@GetMapping("/customers/{customerId}")
	public Customer getCustomers(@PathVariable int customerId){
		Customer theCustomer = customerService.getCustomer(customerId);
		if(theCustomer == null) {
			throw new CustomerNotFoundException("Custoemr with id: "+ customerId + " not found.");
		}
		return theCustomer;
	}
	
	//add mapping for POST/customers add new customer
	//@RequestBody convert JSON data to POJO by jackson
	@PostMapping("/customers")
	public Customer addCustomer (@RequestBody Customer theCustomer) {
		
		//indicate to add a new customer not update
		theCustomer.setId(0);
		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}
	
	//add mapping for PUT/customers
	//@RequestBody convert JSON data to POJO by jackson
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer) {
			
	customerService.saveCustomer(theCustomer);
	return theCustomer;
		}
	
	//add mapping for Delete/customers add new customer
	//@RequestBody convert JSON data to POJO by jackson
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
			
		Customer theCustomer = customerService.getCustomer(customerId);
		if(theCustomer == null) {
			throw new CustomerNotFoundException("Custoemr with id: "+ customerId + " not found.");
		}
		
 	customerService.deleteCustomer(customerId);
	return "Deleted customer id- "+customerId;
		}
	
}
