package com.luv2code.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.dao.CustomerDAO;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	//Inject the customerService to Controller
	@Autowired
	private CustomerService customerService;
	
	//Only accept Get request
	@GetMapping("/list")
	private String listCustomers(Model theModel) {

		//get the customers from the DAO
		List<Customer> theCustomers = customerService.getCustomers();
		
		//add the customers to the Model
		theModel.addAttribute("customers", theCustomers);
		
		//return the Jsp page name
		return "list-customers";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		//Create model attribute to bind from data
		Customer theCustomer = new Customer();
		theModel.addAttribute("customer", theCustomer);
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		//save the customer through Service
		customerService.saveCustomer(theCustomer);
		return "redirect:/customer/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("customerId") int theId, Model theModel) {
		
		//get the customer from the database
		Customer customer = customerService.getCustomers(theId);
		
		//set customer as a model attribute to pre-populate the form
		
		theModel.addAttribute("customer", customer);
		
		//send over to our form
		return "customer-form";
	}
	
	@GetMapping("/delete")
	public String deletCustomer(@RequestParam("customerId") int theId) {
		//delete the customer
		
		customerService.deleteCustomer(theId);
		
		return "redirect:/customer/list";
	}
}
