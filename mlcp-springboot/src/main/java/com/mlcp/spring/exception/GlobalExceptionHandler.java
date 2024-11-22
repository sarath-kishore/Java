package com.mlcp.spring.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BadCommandException.class)
//    public String handleBadCommandException(BadCommandException ex, Model model) {
        public ResponseEntity<String> handleBadCommandException(BadCommandException ex) {
        // Returning custom error message when OrderException is thrown
        System.out.println("BadCommandException, custom exception thrown, handled by global exception handler");
//        model.addAttribute("errorMessage", ex.getMessage());
//        return "error";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }

    @ExceptionHandler(SpotFullException.class)
//    public String handleSpotFullException(SpotFullException ex, Model model) {
        public ResponseEntity<String> handleSpotFullException(SpotFullException ex) {
        // Returning custom error message when OrderException is thrown
        System.out.println("SpotFullException, custom exception thrown, handled by global exception handler");
//        model.addAttribute("errorMessage", ex.getMessage());
//        return "error";
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(ex.getMessage());
    }
}
