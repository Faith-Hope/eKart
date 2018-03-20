package com.nuevo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nuevo.entity.UserDetails;
import com.nuevo.repository.UserRep;
import com.nuevo.service.UserService;
import com.nuevo.utility.Utility;

@RestController
public class HelloRestController {
	@Autowired
	UserService userService;
	@Autowired
	Utility utility;
	@Autowired
	UserRep userRep;

	@RequestMapping("/userLogin")
	public UserDetails getUser(@RequestBody UserDetails user) {
		String username = user.getUsername();
		String password = user.getPassword();
		String generatedPassword = utility.encryptionPassword(password);
		String message = userService.findbyName(username, generatedPassword);
		return new UserDetails(username, message);
	}

	/*
	 * @RequestMapping(value="/user/",method=RequestMethod.GET) public
	 * ResponseEntity<User> getUser(@RequestBody User user) { User
	 * login=userService.findbyName(user); if(login.getUsername().equals("raja") &&
	 * login.getPassword().equals("raja")) { return new ResponseEntity<User>(user,
	 * HttpStatus.OK); } return new ResponseEntity<User>(user,
	 * HttpStatus.BAD_REQUEST);
	 * 
	 * }
	 */

	/**
	 * @param user
	 * @return
	 */
	@RequestMapping("/register")
	public UserDetails registerUser(@RequestBody UserDetails user) {
		String username = user.getUsername();
		String password = user.getPassword();
		String email = user.getEmail();
		String generatedPassword = utility.encryptionPassword(password);
		user.setPassword(generatedPassword);
		UserDetails currentUser = userRep.findByEmail(email);
		if(currentUser!=null) {
			userRep.save(currentUser);
		}
		return currentUser;
	}

}
