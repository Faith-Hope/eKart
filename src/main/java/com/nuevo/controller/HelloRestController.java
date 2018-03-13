package com.nuevo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nuevo.entity.User;
import com.nuevo.service.UserService;
import com.nuevo.utility.Utility;





@RestController
public class HelloRestController {
	@Autowired
	UserService userService;
	@Autowired 
	Utility utility;
	
	@RequestMapping("/login")
	public User getUser(@RequestBody User user )
	{
		String username=user.getUsername();
		String password=user.getPassword();
		String generatedPassword=utility.encryptionPassword(password);
		String message=userService.findbyName(username,generatedPassword);
		return new User(username,message);
	}

	/*@RequestMapping(value="/user/",method=RequestMethod.GET)
	public ResponseEntity<User> getUser(@RequestBody User user)
	{
		User login=userService.findbyName(user);
		if(login.getUsername().equals("raja") && login.getPassword().equals("raja"))
		{
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		return new ResponseEntity<User>(user, HttpStatus.BAD_REQUEST);
		
	}*/
	
	}
