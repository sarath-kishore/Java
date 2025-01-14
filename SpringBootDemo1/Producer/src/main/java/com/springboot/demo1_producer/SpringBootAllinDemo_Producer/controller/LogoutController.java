package com.springboot.demo1_producer.SpringBootAllinDemo_Producer.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

//    @GetMapping("/logout")
//    public String logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
//        // Check if the user is authenticated
//        if (authentication != null) {
//            // Programmatically log out the user
//            new SecurityContextLogoutHandler().logout(request, response, authentication);
//        }
//
//        // Redirect to the login page after logout
//        return "redirect:/login";
//    }


}