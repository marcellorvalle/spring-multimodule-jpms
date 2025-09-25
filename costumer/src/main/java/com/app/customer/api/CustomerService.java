package com.app.customer.api;

import com.app.customer.domain.Customer;
import java.util.Optional;

public interface CustomerService {
    Optional<Customer> findById(Long id);
}
