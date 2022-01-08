package com.pranshu.crm.springdemo.rest;

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

import com.pranshu.crm.springdemo.entity.Customer;
import com.pranshu.crm.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getCustomers()
	{
		List<Customer> theCustomers = customerService.getCustomers();
		return theCustomers;
	}
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomer(@PathVariable int customerId) {
		Customer theCustomer = customerService.getCustomer(customerId);
		
		if(theCustomer == null)
		{
			throw new CustomerNotFoundException("Customer with {"+ customerId + "} NOT FOUND");
		}
		return theCustomer;
	}
	
	@PostMapping("/customers")
	public Customer saveCustomer(@RequestBody Customer theCustomer)
	{
		theCustomer.setId(0);
		System.out.println("Saving -> "+ theCustomer);
		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer theCustomer)
	{
		System.out.println("Updating -> "+ theCustomer);
		customerService.saveCustomer(theCustomer);
		return theCustomer;
	}
	
	@DeleteMapping("/customers/{customerId}")
	public Customer deleteCustomer(@PathVariable int customerId)
	{
		Customer theCustomer = customerService.getCustomer(customerId);
		if(theCustomer == null)
		{
			throw new CustomerNotFoundException("Customer {" + customerId +"} already deleted or doesn't exist");
		}
		customerService.deleteCustomer(customerId);
		return theCustomer;
	}
	
}
