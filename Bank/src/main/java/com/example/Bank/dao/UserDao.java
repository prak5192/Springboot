package com.example.Bank.dao;

import java.util.List;

import com.example.Bank.entity.User;

public interface UserDao {
	
	public void saveUserDetailsToDao(User user);
	public List<User> getUserExtraDetails();

}
