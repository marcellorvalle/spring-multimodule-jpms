package com.app.customer.service;

import com.app.customer.api.CustomerService;
import com.app.customer.domain.Customer;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {


    @Override
    public Optional<Customer> findById(Long id) {
        return Optional.of(new Customer(id, "Costumer " + id));
    }
}
