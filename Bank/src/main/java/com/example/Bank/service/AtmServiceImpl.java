package com.example.Bank.service;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.Bank.dao.CustomerAtmDao;
import com.example.Bank.entity.Customer;

public class AtmServiceImpl {
	
	@Autowired(required = true)
	private CustomerAtmDao customerAtmDao;
	
	public CustomerAtmDao getCustomerAtmDao() {
		return customerAtmDao;
	}
	public void setCustomerAtmDao(CustomerAtmDao customerAtmDao) {
		this.customerAtmDao = customerAtmDao;
	}


	

}
