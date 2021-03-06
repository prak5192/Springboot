package com.example.Bank.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Bank.dao.CustomerAtmDao;
import com.example.Bank.dao.CustomerRepository;
import com.example.Bank.dao.UserDao;
import com.example.Bank.dto.UserDto;
import com.example.Bank.entity.Resturant;
import com.example.Bank.entity.User;

@Service
public class UserSeviceImpl implements UserService{
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private UserDao userDao;
	
	public String saveUserDetails(User user) {
		System.out.println("[UserSeviceImpl]:[saveUserDetails]: Input: " + user.toString());
		List<Resturant> listRestuarant = user.getResturant();
		for(Resturant temp : listRestuarant ) {
			temp.setUser(user);
		}
		
		userDao.saveUserDetailsToDao(user);
		return "SUCCESS";
		
	}
	
	public List<UserDto> getUserExtraDetailService(){
		System.out.println("[UserSeviceImpl]:[getUserExtraDetailService]: Input: " );
		List<User> userList = userDao.getUserExtraDetails();
		List<UserDto> userDto = new ArrayList<UserDto>();
		for(User temp : userList ) {
			UserDto userObj = new UserDto ();
			userObj.setName(temp.getName());
			userObj.setDob(temp.getDob());
			userObj.setPhone(temp.getPhone());
			userObj.setCity("BANGALORE");
			userObj.setCollege("SIT");
			userObj.setMovie("GOOD");
			userDto.add(userObj);
		}
		return userDto;
	}

}
