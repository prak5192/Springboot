package com.example.Bank.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.Bank.entity.Customer;
import com.example.Bank.entity.Transaction;

public interface CustomerAtmDao {
	
	public Customer fetchCustomerBypanNo( String panNo);
	public void saveCustomerDetails(Customer customer);
	public void saveAllCustomerList(List<Customer> customerList);
	public List<Customer> getCustomerDetails();
	public void deleteCustomer(String panNo);
	public void saveTransactionDetails(Transaction transaction);
	public List<com.example.Bank.entity.Transaction> getMiniStatementForGivenUser(String panNo);

}
