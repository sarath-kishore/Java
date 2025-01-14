package com.springboot.demo1_producer.SpringBootAllinDemo_Producer.repository;

import com.springboot.demo1_producer.SpringBootAllinDemo_Producer.model.Token;
import com.springboot.demo1_producer.SpringBootAllinDemo_Producer.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {
    Optional<Token> findByRefreshToken(String refreshToken);

    void deleteByUsername(String username);
}
