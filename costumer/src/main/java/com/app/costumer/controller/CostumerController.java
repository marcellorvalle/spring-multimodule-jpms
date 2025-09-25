package com.app.costumer.controller;

import com.app.costumer.domain.Costumer;
import com.app.costumer.api.CostumerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CostumerController {

    private final CostumerService customerApi;

    public CostumerController(CostumerService customerApi) {
        this.customerApi = customerApi;
    }

    @GetMapping("/costumers/{id}")
    public Costumer find(@PathVariable Long id) {
        return customerApi.findById(id).orElseThrow();
    }
}
