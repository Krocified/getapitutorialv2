package com.example.getapitutorialv2.controller;

import java.util.List;

import com.example.getapitutorialv2.exception.CustomerNotFoundException;
import com.example.getapitutorialv2.model.Customer;
import com.example.getapitutorialv2.repository.CustomerRepo;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {
    private final CustomerRepo repo;

    CustomerController(CustomerRepo repo){
        this.repo = repo;
    }

    @GetMapping("/customers")
    List<Customer> all() {
        return repo.findAll();
    }

    @PostMapping("/customers")
    Customer newCustomer(@RequestBody Customer newCustomer) {
        return repo.save(newCustomer);
    }

    @GetMapping("/customers/{id}")
    Customer one(@PathVariable String id) {
        
        return repo.findById(id)
        .orElseThrow(() -> new CustomerNotFoundException(id));
    }

    @PutMapping("/customers/{id}")
    Customer replaceCustomer(@RequestBody Customer newCustomer, @PathVariable String id) {
        
        return repo.findById(id)
        .map(customer -> {
            customer.setName(customer.getName());
            customer.setRole(customer.getRole());
            return repo.save(customer);
        })
        .orElseGet(() -> {
            newCustomer.setId(id);
            return repo.save(newCustomer);
        });
    }

    @DeleteMapping("/customers/{id}")
    void deleteCustomer(@PathVariable String id) {
        repo.deleteById(id);
    }

    @DeleteMapping("/nukeemall")
    void deleteAll() {
        repo.deleteAll();
    }
}
