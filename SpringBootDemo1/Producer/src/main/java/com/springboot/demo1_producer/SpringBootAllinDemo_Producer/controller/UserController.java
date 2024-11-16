package com.springboot.demo1_producer.SpringBootAllinDemo_Producer.controller;

import com.springboot.demo1_producer.SpringBootAllinDemo_Producer.model.User;
import com.springboot.demo1_producer.SpringBootAllinDemo_Producer.service.CustomUserDetailsService;
import com.springboot.demo1_producer.SpringBootAllinDemo_Producer.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showUserRegister(){
        return "register";
    }



    @PostMapping("/api/register")
    public ResponseEntity<?> addUser(@RequestBody User user){
//        User user = new User();
//        user.setUsername(username);
//        user.setPassword(password);
        System.out.println("registering user via api: " + user.getUsername());
        User temp = userService.createUser(user);
        System.out.println("registered user via api: " + user.getUsername());
        return ResponseEntity.status(HttpStatus.CREATED).body(temp);
    }

}
