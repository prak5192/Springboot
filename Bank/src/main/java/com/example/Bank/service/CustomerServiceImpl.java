package com.example.Bank.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Bank.dao.CustomerAtmDao;
import com.example.Bank.dao.CustomerRepository;
import com.example.Bank.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private CustomerAtmDao customerAtmDao;
	
	List<Customer> custList = new ArrayList<>();
	Customer cust = new Customer();
	
	public void display() {
		System.out.println("Hi there this is working");
	}
	
	public String createCustomerDetailsService(Customer customer) {
		System.out.println("[CustomerServiceImpl]:[createCustomerDetailsService]: Input: " + customer.toString());
		//custList.add(customer);//saving in cache.
		customerAtmDao.saveCustomerDetails(customer);
		
		return "SUCCESS";
	}
	
	
	public String createCustomerDetailsListService(List<Customer> customerList) {
		System.out.println("[CustomerServiceImpl]:[createCustomerDetailsListService]: Input: " + customerList.toString());
		//custList.addAll(customerList);
		customerAtmDao.saveAllCustomerList(customerList);
		return "SUCCESS";
		
		
	}
	public List<Customer> getCustomerDetailsService(){
		System.out.println("[CustomerServiceImpl]:[getCustomerDetailsService]: Input: ");
		List<Customer> list = (List<Customer>)customerAtmDao.getCustomerDetails();
		return list;
	}
	
	public String deleteCustomerService(String panNo) {
		System.out.println("[CustomerServiceImpl]:[deleteCustomerService]: Input: " + panNo);
		customerAtmDao.deleteCustomer(panNo);
		return "SUCCESS";
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
	
	public String addBalanceAmountForSpecifiedCustomer(String panNo,Long  pinCode,Long bal ) {
		System.out.println("[CustomerServiceImpl]:[addBalanceAmountForSpecifiedCustomer]: Input: " + panNo );
		Customer cust = customerAtmDao.fetchCustomerBypanNo(panNo);
		if(cust != null) {
			Long balance = cust.getBal() + bal;
			cust.setBal(balance);
			customerAtmDao.saveCustomerDetails(cust);
			return "SUCCESS";
		} else {
			return "FAILURE";
		}
	}
	
}
