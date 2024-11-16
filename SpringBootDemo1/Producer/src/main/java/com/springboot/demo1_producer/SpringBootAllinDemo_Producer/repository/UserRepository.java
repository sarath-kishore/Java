package com.springboot.demo1_producer.SpringBootAllinDemo_Producer.repository;

import com.springboot.demo1_producer.SpringBootAllinDemo_Producer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
