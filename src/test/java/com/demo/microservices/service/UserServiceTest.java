package com.demo.microservices.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

import java.util.List;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.demo.microservices.model.User;
import com.demo.microservices.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

	@Mock
	private UserRepository repository;

	@InjectMocks
	private UserService service;

	@Test
	void shouldReturnAllUsers() {
		List<User> users = List.of(new User(1L, "Vinicius", "email@test.com"));
		when(repository.findAll()).thenReturn(users);

		List<User> result = service.findAll();

		assertEquals(1, result.size());
		assertEquals("Vinicius", result.get(0).getName());
	}

	@Test
	void shouldDeleteUserById() {
		service.delete(1L);
		verify(repository, times(1)).deleteById(1L);
	}
	
	@Test
	void shouldFindUserById() {
	    User user = new User(1L, "Vinicius", "vinicius@email.com");
	    when(repository.findById(1L)).thenReturn(java.util.Optional.of(user));

	    User result = service.findById(1L);

	    assertEquals("Vinicius", result.getName());
	}

	@Test
	void shouldSaveUser() {
	    User user = new User(null, "Maria", "maria@email.com");
	    when(repository.save(user)).thenReturn(new User(1L, "Maria", "maria@email.com"));

	    User saved = service.save(user);

	    assertEquals(1L, saved.getId());
	    assertEquals("Maria", saved.getName());
	}

}
