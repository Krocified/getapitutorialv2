package com.example.getapitutorialv2.exception;

public class CustomerNotFoundException extends RuntimeException{
    public CustomerNotFoundException(String id){
        super("Could not find customer "+id);
    }
}
