package com.app.order.service;

import com.app.costumer.api.CostumerService;
import com.app.costumer.domain.Costumer;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final CostumerService customerApi;

    public OrderService(CostumerService customerApi) {
        this.customerApi = customerApi;
    }

    public String createOrderForCustomer(Long customerId) {
        Costumer c = customerApi.findById(customerId).orElseThrow();
        return "Order created for " + c.getName();
    }
}
