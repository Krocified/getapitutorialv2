package com.example.getapitutorialv2.repository;

import java.util.List;

import com.example.getapitutorialv2.model.Customer;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepo extends MongoRepository<Customer, String>{
    public Customer findByName(String name);
    public List<Customer> findByRole(String role);
}
