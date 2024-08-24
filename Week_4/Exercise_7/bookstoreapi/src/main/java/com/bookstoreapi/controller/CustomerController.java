package com.bookstoreapi.controller;

import com.bookstoreapi.dto.CustomerDTO;
import com.bookstoreapi.mapper.CustomerMapper;
import com.bookstoreapi.model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerMapper customerMapper;
    private List<Customer> customers = new ArrayList<>();

    public CustomerController(CustomerMapper customerMapper) {
        this.customerMapper = customerMapper;
    }

    @PostMapping
    public CustomerDTO registerCustomer(@RequestBody CustomerDTO customerDTO) {
        Customer customer = customerMapper.toCustomer(customerDTO);
        customers.add(customer);
        return customerMapper.toCustomerDTO(customer);
    }
    // GET request to fetch all customers (for testing purposes)
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customers;
    }
}
