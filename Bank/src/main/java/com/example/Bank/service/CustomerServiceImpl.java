package com.example.Bank.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Bank.dao.CustomerAtmDao;
import com.example.Bank.dao.CustomerRepository;
import com.example.Bank.entity.Customer;
import com.example.Bank.entity.Transaction;

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
		if(cust != null && cust.getPinCode().equals(pinCode)) {
			Long balance = cust.getBal() + bal;
			cust.setBal(balance);
			customerAtmDao.saveCustomerDetails(cust);
			Transaction transaction = new com.example.Bank.entity.Transaction();
			transaction.setPanNo(panNo);
			transaction.setTransDate(new Date());
			transaction.setTransHistory(bal);
			customerAtmDao.saveTransactionDetails(transaction);
			return "SUCCESS";
		} else {
			return "FAILURE";
		}
	}
	
	public String withdrawBalance(String panNo, Long pinCode, Long bal) {
		System.out.println("[CustomerServiceImpl]:[withdrawBalance]: Input: " + panNo);
		Customer cust = customerAtmDao.fetchCustomerBypanNo(panNo);
		if ((cust != null)) {
			if (cust.getPinCode().equals(pinCode)) {
				if ((cust.getBal() >= bal)) {
					Long removeBalance = cust.getBal() - bal;
					cust.setBal(removeBalance);
					customerAtmDao.saveCustomerDetails(cust);
					Transaction transaction = new com.example.Bank.entity.Transaction();
					transaction.setPanNo(panNo);
					transaction.setTransDate(new Date());
					transaction.setTransHistory(0-bal);
					customerAtmDao.saveTransactionDetails(transaction);
					return "SUCCESS";
				} else {
					System.out.println("[CustomerServiceImpl]:[withdrawBalance]: Insufficient balance");
					return "FAILURE";
				}
			} else {
				System.out.println("[CustomerServiceImpl]:[withdrawBalance]: Incorrect pincode");
				return "FAILURE";
			}
		} else {
			System.out.println("[CustomerServiceImpl]:[withdrawBalance]: Incorrect panNo");
			return "FAILURE";
		}
		
	}
	
	public Long getCurrentBalance(String panNo, Long pinCode) {
		System.out.println("[CustomerServiceImpl]:[getCurrentBalance]: Input: " + panNo);
		Customer cust = customerAtmDao.fetchCustomerBypanNo(panNo);
		if ((cust != null)) {
			if (cust.getPinCode().equals(pinCode)) {
				Long currBalance = cust.getBal();
				return currBalance;
			} else {
				System.out.println("[CustomerServiceImpl]:[getCurrentBalance]: Incorrect pincode");
				return -1L;
			}
		} else {
			System.out.println("[CustomerServiceImpl]:[getCurrentBalance]: Incorrect panNo");
			return -1L;
		}
	}
	
	public String fetchMiniStatement(String panNo,Long  pinCode) {
		System.out.println("[CustomerServiceImpl]:[fetchMiniStatement]: Input: " + panNo);
		Customer cust = customerAtmDao.fetchCustomerBypanNo(panNo);
		if ((cust != null)) {
			if (cust.getPinCode().equals(pinCode)) {
				List<com.example.Bank.entity.Transaction> trans = customerAtmDao.getMiniStatementForGivenUser(panNo);
				return trans.toString();
			}else {
				System.out.println("[CustomerServiceImpl]:[fetchMiniStatement]: Incorrect pincode");
				return "FAILURE";
			}
			
		}else {
			System.out.println("[CustomerServiceImpl]:[fetchMiniStatement]: Incorrect panNo");
			return "FAILURE";
		}
		
	}
}
