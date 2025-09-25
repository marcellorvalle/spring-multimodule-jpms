package com.app.order.service;

import com.app.billing.api.BillingService;
import com.app.customer.api.CustomerService;
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

    private final CustomerService customerService;
    private final ProductService productService;
    private final BillingService billingService;

    public Order placeOrder(OrderRequest orderRequest) {
        var order = new Order();
        order.setCustomer(customerService.findById(orderRequest.customerId()).orElseThrow());
        order.setProduct(productService.getById(orderRequest.productId()));
        order.setQuantity(orderRequest.quantity());

        var billId = billingService.tryToBill(order.getCustomer(), order.getTotal());
        order.setBillId(billId);

        log.info("Order placed: {}", order);
        return order;
    }
}
