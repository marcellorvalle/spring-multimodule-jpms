package com.app.costumer.controller;

import com.app.costumer.domain.Customer;
import com.app.costumer.api.CustomerApi;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

    private final CustomerApi customerApi;

    public CustomerController(CustomerApi customerApi) {
        this.customerApi = customerApi;
    }

    @GetMapping("/customers/{id}")
    public Customer find(@PathVariable Long id) {
        return customerApi.findById(id).orElseThrow();
    }
}
