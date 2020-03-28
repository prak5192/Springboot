package com.example.Bank.service;

import java.util.List;

import com.example.Bank.entity.Customer;

public interface CustomerService {
	
	public void display();
	
	public String createCustomerDetailsService(Customer customer);
	
	public String createCustomerDetailsListService(List<Customer> customerList);
	
	public List<Customer> getCustomerDetailsService();
	
	public String deleteCustomerService(String panNo);
	
	public String updateCustomerService(String panNo,String name);
	
	
	

}
