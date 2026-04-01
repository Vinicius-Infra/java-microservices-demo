package com.demo.microservices.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.demo.microservices.model.User;
import com.demo.microservices.repository.UserRepository;

@DataJpaTest
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    void testSaveAndFindUser() {
        User user = new User(null, "Vinicius", "vinicius@email.com");
        User saved = repository.save(user);

        assertTrue(repository.findById(saved.getId()).isPresent());
        assertEquals("Vinicius", saved.getName());
    }
}
