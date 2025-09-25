package com.app.costumer.api;

import com.app.costumer.domain.Customer;
import java.util.Optional;

public interface CustomerApi {
    Optional<Customer> findById(Long id);
}
