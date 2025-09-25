package com.app.order.controller;

import com.app.order.api.OrderService;
import com.app.order.domain.Order;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
@AllArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping()
    public Order placeOrder(@RequestBody OrderService.OrderRequest orderRequest) {
        return orderService.placeOrder(orderRequest);
    }
}
