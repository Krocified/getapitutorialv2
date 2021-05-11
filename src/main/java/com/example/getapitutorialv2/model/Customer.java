package com.example.getapitutorialv2.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;

public class Customer {

    @Id
    private String id;
    private String name;
    private String role;

    public Customer() {}

    public Customer(String name, String role){
        this.name = name;
        this.role = role;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o)
        return true;
        if (!(o instanceof Customer))
        return false;
        Customer employee = (Customer) o;
        return Objects.equals(this.id, employee.id) && Objects.equals(this.name, employee.name)
            && Objects.equals(this.role, employee.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id, this.name, this.role);
    }

    @Override
    public String toString() {
        return String.format("Customer[id= "+id+", name='%s', role='%s']",name, role);
    }
}
