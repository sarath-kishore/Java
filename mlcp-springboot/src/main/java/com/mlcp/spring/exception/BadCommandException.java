package com.mlcp.spring.exception;

public class BadCommandException  extends Exception{
    public BadCommandException(String message) {
        super(message);
    }
}
