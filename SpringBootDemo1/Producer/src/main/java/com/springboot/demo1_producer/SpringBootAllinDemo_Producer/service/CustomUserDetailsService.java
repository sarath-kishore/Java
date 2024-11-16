package com.springboot.demo1_producer.SpringBootAllinDemo_Producer.service;

import com.springboot.demo1_producer.SpringBootAllinDemo_Producer.CustomUserDetails;
import com.springboot.demo1_producer.SpringBootAllinDemo_Producer.model.User;
import com.springboot.demo1_producer.SpringBootAllinDemo_Producer.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = userRepository.findByUsername(username);
        System.out.println("fetched users cuds: " + u);
        if(u == null) {
            System.out.println("User not found cuds");
            throw new UsernameNotFoundException("User not found exception cuds!");
//            return null;
        }
        System.out.println("User is found cuds");
        return new CustomUserDetails(u);
    }
}
