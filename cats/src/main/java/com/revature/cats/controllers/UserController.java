package com.revature.cats.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.revature.cats.exceptions.UserNotFoundException;
import com.revature.cats.models.User;
import com.revature.cats.services.UserService;

@RequestMapping(path = "/users")
@RestController
public class UserController {
	
	
	@Autowired
	UserService userService;
	
	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAll();
	}
	
	@GetMapping("/{id}")
	public User getUserByid(@PathVariable Integer id) {
		try {
			return userService.getById(id);
		}catch(UserNotFoundException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping
	public User createNewUser(@RequestBody User user) {
		return userService.ceate(user);
	}
	
	@PutMapping("/{id}")
	public User createOrUpdateUserWithId(@RequestBody User user, @PathVariable Integer id) {
		user.setUserId(id);
		return userService.createOrUpdate(user); 
	}
}
