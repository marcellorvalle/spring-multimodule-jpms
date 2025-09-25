package com.app.order.api;

import com.app.order.domain.Order;

public interface OrderService {
    Order placeOrder(OrderRequest orderRequest);

    record OrderRequest(
            long customerId,
            long productId,
            int quantity
    ) {}
}
