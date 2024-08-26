package com.bookstoreapi.controller;

import com.bookstoreapi.model.Customer;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private List<Customer> customers = new ArrayList<>();

    // POST request to create a new customer with JSON request body
    @PostMapping
    public Customer createCustomer(@RequestBody Customer customer) {
        customers.add(customer);
        return customer;
    }

    // POST request to process form data for customer registration
    @PostMapping("/register")
    public String registerCustomer(@RequestParam("name") String name,
                                   @RequestParam("email") String email,
                                   @RequestParam("phone") String phone,
                                   @RequestParam(value = "profilePicture", required = false) MultipartFile profilePicture) {
        Customer customer = new Customer(customers.size() + 1, name, email, phone);
        customers.add(customer);

        if (profilePicture != null) {
            // Handle profile picture upload (e.g., save to server)
            // This is just an example, you can handle the file as per your requirement.
            return "Customer registered successfully with profile picture!";
        }

        return "Customer registered successfully!";
    }

    // GET request to fetch all customers (for testing purposes)
    @GetMapping
    public List<Customer> getAllCustomers() {
        return customers;
    }
}
