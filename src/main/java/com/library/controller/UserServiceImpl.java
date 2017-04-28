package com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.book.domain.User;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepo;

	@Override
	public String registerUserDetails(User user) {
		userRepo.save(user);
		return "SUCCESS";
	}

	@Override
	public User getUserDetails(String fName) {
		
		return userRepo.findByfname(fName);
		
	}


}
