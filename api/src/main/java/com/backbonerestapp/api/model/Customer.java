package com.backbonerestapp.api.model;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(
        name="findAllEmployeesByFirstName",
        query="SELECT OBJECT(emp) FROM Employee emp WHERE emp.firstName = 'John'"
)
public class Customer {
    int id;
    String name;

    public Customer(int id, String name) {
        this.id = id;
        this.name = name;
    }

    //public Customer findCustomerById(Long id)

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
