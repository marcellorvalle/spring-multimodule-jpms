package com.app.billing.service;

import com.app.billing.api.BillingService;
import com.app.customer.domain.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
public class BillingServiceImpl implements BillingService {
    private final Random rand = new Random();

    @Override
    public String tryToBill(Customer customer, BigDecimal amount) {
        var billId = UUID.randomUUID().toString();
        log.info("Trying to bill {} with amount {}. Id: {}", customer.getName(), amount, billId);
        simulateBilling().thenAccept(result -> log.info("Bill ID {} result: {}", billId, result) );

        return billId;
    }

    private CompletableFuture<Boolean> simulateBilling() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(rand.nextInt(10) * 1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return rand.nextBoolean();
        });
    }
}
