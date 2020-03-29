package com.example.Bank.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Bank.dao.CustomerRepository;
import com.example.Bank.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired(required = true)
	private CustomerRepository customerRepository;
	
	List<Customer> custList = new ArrayList<>();
	Customer cust = new Customer();
	
	public void display() {
		System.out.println("Hi there this is working");
	}
	
	public String createCustomerDetailsService(Customer customer) {
		System.out.println("[CustomerServiceImpl]:[createCustomerDetailsService]: Input: " + customer.toString());
		//custList.add(customer);//saving in cache.
		customerRepository.save(customer);
		return "SUCCESS";
	}
	
	
	public String createCustomerDetailsListService(List<Customer> customerList) {
		System.out.println("[CustomerServiceImpl]:[createCustomerDetailsListService]: Input: " + customerList.toString());
		//custList.addAll(customerList);
		customerRepository.saveAll(customerList);
		return "SUCCESS";
		
		
	}
	public List<Customer> getCustomerDetailsService(){
		System.out.println("[CustomerServiceImpl]:[getCustomerDetailsService]: Input: ");
		List<Customer> list = (List<Customer>)customerRepository.findAll();
		return list;
	}
	
	public String deleteCustomerService(String panNo) {
		System.out.println("[CustomerServiceImpl]:[deleteCustomerService]: Input: " + panNo);
		Iterator<Customer> itr = custList.iterator();
		boolean flag = false;
		while(itr.hasNext()) {
			Customer cust = (Customer)itr.next();
			if(cust.getPanNo().equalsIgnoreCase(panNo)) {
				itr.remove();
				flag =true;
			}
		}
		if(flag) {
			return "SUCCESS";
		}else {
			return "FAILURE";
		}
	}
	
	
	public String updateCustomerService(String panNo,String name) {
		System.out.println("[CustomerServiceImpl]:[updateCustomer]: Input: " + panNo + "" + name);
		for(Customer temp : custList) {
			if(temp.getPanNo().equalsIgnoreCase(panNo)) {
				temp.setName(name);
				return "SUCCESS";
			}
		}
		return "FAILURE";
	}

}
