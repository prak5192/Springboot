package com.example.Bank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Bank.entity.Transaction;
import com.example.Bank.entity.User;
import com.example.Bank.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/saveUserDetails")

	public String saveUserDetails(@RequestBody User user) {
		System.out.println("Saving  User details in the User Table : " + user.toString());
		String res = userService.saveUserDetails(user);
		return res;
	}
	
}
