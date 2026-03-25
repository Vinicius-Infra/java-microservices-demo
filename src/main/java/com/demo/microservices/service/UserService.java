package java_microservices.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import java_microservices.demo.model.User;
import java_microservices.demo.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User save(User user) {
        return repository.save(user);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}