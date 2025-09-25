package com.app.order.service;

import com.app.costumer.api.CostumerService;
import com.app.order.api.OrderService;
import com.app.order.domain.Order;
import com.app.product.api.ProductService;
import lombok.AllArgsConstructor;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@ToString
public class OrderServiceImpl implements OrderService {
    private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    private final CostumerService costumerService;
    private final ProductService productService;

    public Order placeOrder(OrderRequest orderRequest) {
        var order = new Order();
        order.setCostumer(costumerService.findById(orderRequest.customerId()).orElseThrow());
        order.setProduct(productService.getById(orderRequest.productId()));
        order.setQuantity(orderRequest.quantity());

        log.info("Order placed: {}", order);
        return order;
    }
}
