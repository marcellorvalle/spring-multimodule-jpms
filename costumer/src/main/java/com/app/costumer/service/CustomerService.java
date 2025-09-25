package com.app.costumer.service;

import com.app.costumer.api.CustomerApi;
import com.app.costumer.domain.Customer;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CustomerService implements CustomerApi {
    @Override
    public Optional<Customer> findById(Long id) {
        return Optional.of(new Customer(id, "Cliente " + id));
    }
}
