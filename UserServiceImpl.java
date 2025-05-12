package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserRepository;
import com.model.Role;
import com.model.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	@Override
	public String registerUser(User user) {
		if (userRepository.findByEmail(user.getEmail()) != null) {
            return "Email already registered";
        }
        userRepository.save(user);
        return "User registered successfully";
	}

	@Override
	public User loginUser(String email, String password) {
		User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

	

	

		    


	@Override
	public User Signup(int id, String name, String email, String password, Role role) {
		
		User newUser= new User();
		newUser.setId(null);
		newUser.setName(name);
		newUser.setEmail(email);
		newUser.setPassword(password);
		newUser.setRole(role);
		
		return userRepository.save(newUser);
	}

	@Override
	public User Signup(String name, String email, String password) {
		User newUser= new User();
		newUser.setName(name);
		newUser.setEmail(email);
		newUser.setPassword(password);
		return userRepository.save(newUser);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
