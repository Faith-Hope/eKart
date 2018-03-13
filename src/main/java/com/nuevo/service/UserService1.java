package com.nuevo.service;

import org.springframework.stereotype.Service;

import com.nuevo.entity.User;
import com.nuevo.repository.UserRep;

@Service 
public class UserService1 {

	private UserRep userRep;
	
	public void saveUser(User user) {
		userRep.save(user);
	}
	 
	
}
