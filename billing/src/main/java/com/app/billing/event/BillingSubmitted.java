package com.app.billing.event;

import com.app.customer.domain.Customer;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record BillingSubmitted (
    String billingId,
    Customer customer,
    BigDecimal amount,
    LocalDateTime localDateTime
) {
    public BillingSubmitted(String billingId, Customer customer, BigDecimal amount) {
        this(billingId, customer, amount, LocalDateTime.now());
    }
}
