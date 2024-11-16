package com.springboot.demo1_producer.SpringBootAllinDemo_Producer.service;

import com.springboot.demo1_producer.SpringBootAllinDemo_Producer.model.User;
import com.springboot.demo1_producer.SpringBootAllinDemo_Producer.repository.UserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthenticationManager authenticationManager;

//    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.authenticationManager = authenticationManager;
    }

    public User createUser(User user){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        System.out.println("adding user: " + user.getUsername() + ", " + user.getPassword());

        var temp = userRepository.save(user);
        System.out.println(temp);

        return temp;
    }


    public User loginUser(User user) throws UsernameNotFoundException{
//        User u = userRepository.findByUsername(user.getUsername());
//        System.out.println("fetched users: " + u);


        System.out.println("Logging user in US");

        Authentication authenticate = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));

        if(!authenticate.isAuthenticated()) {
            System.out.println("User not found us");
            throw new UsernameNotFoundException("");
        }
        return user;
    }


}
