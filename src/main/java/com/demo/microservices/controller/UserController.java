package com.demo.microservices.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.microservices.model.User;
import com.demo.microservices.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private final UserService service;

	public UserController(UserService service) {
		this.service = service;
	}

	@GetMapping
	public List<User> getUsers() {
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public User getUserById(@PathVariable Long id) {
	    return service.findById(id); 
	}

	@PostMapping
	public User createUser(@RequestBody User user) {
		return service.save(user);
	}

	@PutMapping("/{id}")
	public User updateUser(@PathVariable Long id, @RequestBody User userDetails) {
	    User user = service.findById(id);
	    user.setName(userDetails.getName());
	    user.setEmail(userDetails.getEmail());
	    return service.save(user);
	}
        

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Long id) {
		service.delete(id);
	}
}
