package com.demo.microservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.microservices.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
