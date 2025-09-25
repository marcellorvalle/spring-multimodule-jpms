package com.app.order.service;

import com.app.costumer.api.CustomerApi;
import com.app.costumer.domain.Customer;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final CustomerApi customerApi;

    public OrderService(CustomerApi customerApi) {
        this.customerApi = customerApi;
    }

    public String createOrderForCustomer(Long customerId) {
        Customer c = customerApi.findById(customerId).orElseThrow();
        return "Order created for " + c.getName();
    }
}
