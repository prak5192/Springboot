package com.example.Bank.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Bank.dto.UserDto;
import com.example.Bank.entity.User;

@Service
public interface UserService {
	
	public String saveUserDetails(User user);
	public List<UserDto> getUserExtraDetailService();
	
}
