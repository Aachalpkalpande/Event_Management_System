package com.service;

import com.model.Role;
import com.model.User;

public interface UserService {

	String registerUser(User user);
	User loginUser(String email, String password);
	User Signup(String name, String email, String password);
	User Signup(int id, String name, String email, String password, Role role);
}