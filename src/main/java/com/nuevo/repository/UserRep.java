package com.nuevo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nuevo.entity.UserDetails;

@Repository
public interface UserRep extends JpaRepository<UserDetails, Long> {

//User findByEmail(String email);
	 public UserDetails findByUsernameAndPassword(String username, String password);
	 UserDetails findByEmail(String email);
	 UserDetails save(UserDetails user);
}
