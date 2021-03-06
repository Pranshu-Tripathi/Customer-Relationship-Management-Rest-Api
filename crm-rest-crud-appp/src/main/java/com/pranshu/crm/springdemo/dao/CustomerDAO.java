package com.pranshu.crm.springdemo.dao;

import java.util.List;

import com.pranshu.crm.springdemo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();
	
	public Customer getCustomer(int theId);
	
	public void saveCustomer(Customer theCustomer);
	
	public void deleteCustomer(int theId);
	
}
