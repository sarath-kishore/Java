package com.springboot.demo1_producer.SpringBootAllinDemo_Producer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(OrderException.class)
    public String handleOrderException(OrderException ex, Model model) {
//        public ResponseEntity<String> handleOrderException(OrderException ex) {
        // Returning custom error message when OrderException is thrown
        System.out.println("orderexception, custom exception thrown, handled by global exception handler");
        model.addAttribute("errorMessage", ex.getMessage());
        return "error";
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(BadCredentialsException.class)
    public String handleException(BadCredentialsException ex, Model model) {
//        public ResponseEntity<String> handleException(BadCredentialsException ex) {
        // Returning custom error message when OrderException is thrown
        System.out.println("BadCredentialsException, custom exception thrown, handled by global exception handler");

        model.addAttribute("errorMessage", ex.getMessage());
        return "login";
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}