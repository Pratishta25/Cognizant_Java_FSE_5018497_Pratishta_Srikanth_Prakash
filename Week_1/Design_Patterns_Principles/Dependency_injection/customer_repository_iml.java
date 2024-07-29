package com.example.dependencyinjection;

public class CustomerRepositoryImpl implements CustomerRepository {

    @Override
    public Customer findCustomerById(String id) {
        // In a real application, this would fetch data from a database
        return new Customer(id, "John Doe");
    }
}
