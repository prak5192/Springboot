package com.example.Bank.controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Bank.entity.Customer;

@RestController
public class CustomerController {
	
	List<Customer> custList = new ArrayList<>();
	
	
	@GetMapping("/getCustomerList")
	public List<Customer> getCustomerDetails(){
		System.out.println("Fetching Customer List ");
		Customer cust = new Customer();
		cust.setName("Prakash");
		cust.setAge(30); 
		cust.setAddress("QtNo-22010");
		cust.setAtmNo("7777");
		cust.setPinCode(1899L);
		cust.setBal(10000L);
		cust.setDob("10/11/1987");
		cust.setPanNo("AUMPR42990");
		//custList.add(new Customer("Archana",29,"QtNo-2209","1234",2345L,7000L,"01/10/1988","CKVPS3258M"));
		//custList.add(cust);
		return custList;
	}
	
	@PostMapping("/createCustomer")
	public Integer createCustomerDetails(@RequestBody Customer customer) {
		System.out.println("Creating Customer Details : " +customer.toString());
		custList.add(customer);
		return 1;
	}
	
	
	/*
	 * 
	 [
{"name":"Archana","age":29,"address":"QtNo-2209","atmNo":"1234","pinCode":2345,"bal":7000,"dob":"01/10/1988","panNo":"1234a"},
{"name":"Prakash","age":30,"address":"QtNo-22010","atmNo":"7777","pinCode":1899,"bal":10000,"dob":"10/11/1987","panNo":"1234b"},
{"name":"Rosy","age":29,"address":"QtNo-2209","atmNo":"1234","pinCode":2345,"bal":7000,"dob":"01/10/1988","panNo":"1234c"},
{"name":"Sonu","age":30,"address":"QtNo-22010","atmNo":"7777","pinCode":1899,"bal":10000,"dob":"10/11/1987","panNo":"1234d"},
{"name":"Dolly","age":29,"address":"QtNo-2209","atmNo":"1234","pinCode":2345,"bal":7000,"dob":"01/10/1988","panNo":"1234e"},
{"name":"Vikash","age":30,"address":"QtNo-22010","atmNo":"7777","pinCode":1899,"bal":10000,"dob":"10/11/1987","panNo":"1234f"}
	]
	 */
	
	@PostMapping("/createCustomerList")
	public Integer createCustomerDetailsList(@RequestBody List<Customer> customerList) {
		System.out.println("Creating Customer Details : " +customerList.toString());
		custList.addAll(customerList);
		return 1;
	}
	
	@DeleteMapping("/deleteCustomer/{panNo}")
	public Integer deleteCustomer(@PathVariable String panNo) {
		System.out.println("Deleting Customer Detail for given panNo : " + panNo);
		boolean flag = false;
		/*
		 * for(Customer temp : custList) { if(temp.getPanNo().equalsIgnoreCase(panNo)){
		 * System.out.println("Found Customer Detail for given panNo : " + panNo);
		 * custList.remove(temp); //return 0; } }
		 */
		// return -1;
		Iterator<Customer> itr = custList.iterator();
		while (itr.hasNext()) {
			Customer cust = (Customer) itr.next();
			if (cust.getPanNo().equalsIgnoreCase(panNo)) {
				itr.remove();// we should not return
				//custList.remove(Cust); if we are no using iterator remove() it will throw concurrentModification exception.
				flag = true;
			}
		}
		if (flag) {
			return 0;
		} else {
			return -1;
		}
	}

}
