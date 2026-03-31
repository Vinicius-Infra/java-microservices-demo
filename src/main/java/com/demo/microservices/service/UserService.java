package com.demo.microservices.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.demo.microservices.model.User;
import com.demo.microservices.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAll() {
        return repository.findAll();
    }
    
    public User findById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuário não encontrado com id " + id));
    }

    public User save(User user) {
        return repository.save(user);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

}