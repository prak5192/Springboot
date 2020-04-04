package com.example.Bank.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Bank.entity.Customer;

@Service
public interface CustomerService {
	
	public void display();
	
	public String createCustomerDetailsService(Customer customer);
	
	public String createCustomerDetailsListService(List<Customer> customerList);
	
	public List<Customer> getCustomerDetailsService();
	
	public String deleteCustomerService(String panNo);
	
	public String updateCustomerService(String panNo,String name);
	
	public String addBalanceAmountForSpecifiedCustomer(String panNo,Long  pinCode,Long bal );
	
	
	

}
