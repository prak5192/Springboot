package com.example.Bank.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Bank.entity.Customer;
import com.example.Bank.service.CustomerServiceImpl;

@RestController
public class CustomerController {
	@Autowired(required = true)
	private CustomerServiceImpl customerServiceImpl;

	public CustomerServiceImpl getCustomerServiceImpl() {
		return customerServiceImpl;
	}

	public void setCustomerServiceImpl(CustomerServiceImpl customerServiceImpl) {
		this.customerServiceImpl = customerServiceImpl;
	}

	// List<Customer> custList = new ArrayList<>();

	@GetMapping("/getCustomerList")
	public List<Customer> getCustomerDetails() {
		System.out.println("Fetching Customer List ");
		return customerServiceImpl.getCustomerDetailsService();
	}

	/*
	 * 
	 * [ {"name":"Archana","age":29,"address":"QtNo-2209","atmNo":"1234","pinCode":
	 * 2345,"bal":7000,"dob":"01/10/1988","panNo":"1234a"},
	 * {"name":"Prakash","age":30,"address":"QtNo-22010","atmNo":"7777","pinCode":
	 * 1899,"bal":10000,"dob":"10/11/1987","panNo":"1234b"},
	 * {"name":"Rosy","age":29,"address":"QtNo-2209","atmNo":"1234","pinCode":2345,
	 * "bal":7000,"dob":"01/10/1988","panNo":"1234c"},
	 * {"name":"Sonu","age":30,"address":"QtNo-22010","atmNo":"7777","pinCode":1899,
	 * "bal":10000,"dob":"10/11/1987","panNo":"1234d"},
	 * {"name":"Dolly","age":29,"address":"QtNo-2209","atmNo":"1234","pinCode":2345,
	 * "bal":7000,"dob":"01/10/1988","panNo":"1234e"},
	 * {"name":"Vikash","age":30,"address":"QtNo-22010","atmNo":"7777","pinCode":
	 * 1899,"bal":10000,"dob":"10/11/1987","panNo":"1234f"} ]
	 */

	@PostMapping("/createCustomerList")
	public String createCustomerDetailsList(@RequestBody List<Customer> customerList) {
		System.out.println("Creating Customer Details : " + customerList.toString());
		String res = customerServiceImpl.createCustomerDetailsListService(customerList);
		return res;
	}

	@PostMapping("/createCustomer")
	public String createCustomerDetails(@RequestBody Customer customer) {
		System.out.println("Creating Customer Details : " + customer.toString());
		String res = customerServiceImpl.createCustomerDetailsService(customer);
		return res;
	}

	@DeleteMapping("/deleteCustomer/{panNo}")
	public String deleteCustomer(@PathVariable String panNo) {
		System.out.println("Deleting Customer Detail for given panNo : " + panNo);
		return  customerServiceImpl.deleteCustomerService(panNo);
	
	}
	 

	@PutMapping("/UpdateCustomer/{panNo}")
	public String updateCustomer(@PathVariable String panNo, @RequestBody String name) {
		System.out.println("Upadating Customer Name for given panNo : " + panNo);
		return customerServiceImpl.updateCustomerService(panNo, name);

	}

}
