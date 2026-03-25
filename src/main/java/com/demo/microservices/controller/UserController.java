package java_microservices.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java_microservices.demo.model.User;
import java_microservices.demo.service.UserService;

@RestController
@RequestMapping
public class UserController {
	
	private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public List<String> getUsers() {
        return List.of("Vinicius", "Maria", "João");
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return service.addUser(user);
    }
}
