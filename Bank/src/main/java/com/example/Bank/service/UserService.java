package com.example.Bank.service;

import org.springframework.stereotype.Service;

import com.example.Bank.entity.User;

@Service
public interface UserService {
	
	public String saveUserDetails(User user);
	
}
