package com.app.customer.controller;

import com.app.customer.domain.Customer;
import com.app.customer.api.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    private final CustomerService customerApi;

    public CustomerController(CustomerService customerApi) {
        this.customerApi = customerApi;
    }

    @GetMapping("/customers/{id}")
    public Customer find(@PathVariable Long id) {
        return customerApi.findById(id).orElseThrow();
    }
}
