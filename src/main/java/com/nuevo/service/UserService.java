package com.nuevo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nuevo.entity.UserDetails;
import com.nuevo.repository.UserRep;

@Service 
public class UserService {
	@Autowired
	private UserRep userRep;
	
	public String findbyName(String username, String password) {

		UserDetails user = userRep.findByUsernameAndPassword(username, password);
		if (user != null) { 
			return "welcome to ekart ";
		} else {
			return "Incorrect password please try again";
		}
	}
	
	
	public UserDetails saveUser(UserDetails user) {
		return userRep.save(user);
	}
	
	public UserDetails findUser(String email) {
		return userRep.findByEmail(email);
	}
	 	
}
 