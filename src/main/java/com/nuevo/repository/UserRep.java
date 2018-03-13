package com.nuevo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.nuevo.entity.User;

public interface UserRep extends JpaRepository<User, Long> {

	//User findByEmail(String email);
}
