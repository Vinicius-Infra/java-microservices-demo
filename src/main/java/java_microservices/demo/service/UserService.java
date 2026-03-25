package java_microservices.demo.service;



import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import java_microservices.demo.model.User;

@Service
public class UserService {
	
	private final List<User> users = new ArrayList<>();

    public List<User> getAllUsers() {
        return users;
    }

    public User addUser(User user) {
        users.add(user);
        return user;
    }
}
