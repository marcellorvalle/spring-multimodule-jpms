package com.app.billing.api;

import com.app.customer.domain.Customer;

import java.math.BigDecimal;

public interface BillingService {
    String tryToBill(Customer customer, BigDecimal amount);
}
