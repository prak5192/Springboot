package com.example.Bank.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Bank.dto.ATMDto;
import com.example.Bank.entity.Customer;
import com.example.Bank.entity.Transaction;
import com.example.Bank.service.AtmService;
import com.example.Bank.service.CustomerService;

@RestController
public class AtmController {
	@Autowired
	private CustomerService customerService;

	@PostMapping("/addBalToGivenCustomer")

	public String addBalanceAmountForSpecifiedCustomer(@RequestBody ATMDto atmDto) {
		System.out.println("Adding Balance to Given  Customer  : " + atmDto.toString());
		String res = customerService.addBalanceAmountForSpecifiedCustomer(atmDto.getPanNo(), atmDto.getPinCode(),
				atmDto.getBal());
		return res;
	}

	@PostMapping("/withdrawdBalForGivenCustomer")

	public String withdrawBalanceAmountForSpecifiedCustomer(@RequestBody ATMDto atmDto) {
		System.out.println("Adding Balance to Given  Customer  : " + atmDto.toString());
		String res = customerService.withdrawBalance(atmDto.getPanNo(), atmDto.getPinCode(), atmDto.getBal());
		return res;
	}

	@GetMapping("/getCurrentBalanceForGivenCustomer")

	public Long getCurrentBalanceAmountForSpecifiedCustomer(@RequestBody ATMDto atmDto) {
		System.out.println("Fetching  Balance to Given  Customer  : " + atmDto.toString());
		return customerService.getCurrentBalance(atmDto.getPanNo(), atmDto.getPinCode());
	}
	
	@PostMapping("/getMiniStatementForGivenCustomer")
	@ResponseBody
	//public String getMiniStatementForGivenCustomer(@RequestParam String panNo, @RequestParam Long pinCode) {
	public String getMiniStatementForGivenCustomer(@RequestBody ATMDto atmDto) {
		System.out.println("Fetching  Mini Statement for Given  Customer  : " + atmDto.toString());
		return customerService.fetchMiniStatement(atmDto.getPanNo(), atmDto.getPinCode());
	}
	
	
}
