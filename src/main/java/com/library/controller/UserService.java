package com.library.controller;

import com.library.book.domain.User;

public interface UserService {
	
	public String registerUserDetails(User user);
	public User getUserDetails(String fName);
}
