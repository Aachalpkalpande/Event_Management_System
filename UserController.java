package com.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.User;
import com.service.UserService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins="http://localhost:3000")  



public class UserController {

	@Autowired
	private UserService userService;
	
	@PostMapping("/signup")
	public ResponseEntity<String> signup(@RequestBody User user) {
		String response = userService.registerUser(user);
		if(response.equals("Email already registered")) {
			return ResponseEntity.badRequest().body(response);		
		}
		return ResponseEntity.ok(response);
	}
	


	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody User user) {
		User loggedIn = userService.loginUser(user.getEmail(), user.getPassword());
			if(loggedIn!= null) {
				return ResponseEntity.ok(loggedIn);
			} else {
				return ResponseEntity.status(401).body("Invalid credentials");
			}
	}
	
	
	

	
	
	
}

