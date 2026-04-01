package com.demo.microservices.service;

import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.microservices.model.User;
import com.demo.microservices.repository.UserRepository;
import com.demo.microservices.service.UserService;

@SpringBootTest
public class UserServiceTest {
	
	@Autowired
    private UserService service;

    @MockBean
    private UserRepository repository;

    @Test
    void testFindById() {
        User user = new User(1L, "Vinicius", "vinicius@email.com");
        when(repository.findById(1L)).thenReturn(Optional.of(user));

        User result = service.findById(1L);
        assertEquals("Vinicius", result.getName());
        assertEquals("vinicius@email.com", result.getEmail());
    }

    @Test
    void testSaveUser() {
        User user = new User(null, "Novo", "novo@email.com");
        User saved = new User(2L, "Novo", "novo@email.com");

        when(repository.save(user)).thenReturn(saved);

        User result = service.save(user);
        assertEquals(2L, result.getId());
    }

}
