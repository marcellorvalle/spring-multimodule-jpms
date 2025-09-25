package com.app.billing.service;

import com.app.billing.api.BillingService;
import com.app.billing.event.BillingCompleted;
import com.app.billing.event.BillingFailed;
import com.app.billing.event.BillingSubmitted;
import com.app.customer.domain.Customer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
@Slf4j
@RequiredArgsConstructor
public class BillingServiceImpl implements BillingService {

    private static final int MAX_DELAY_SECONDS = 10;
    private static final int MILLIS_PER_SECOND = 1000;

    private final Random random = new Random();
    private final ApplicationEventPublisher eventPublisher;

    @Override
    public String tryToBill(Customer customer, BigDecimal amount) {
        String billId = generateBillId();

        log.info("Iniciando cobrança para cliente: {} | Valor: {} | ID: {}",
                customer.getName(), amount, billId);

        processAsyncBilling(billId, customer, amount);

        return billId;
    }

    private String generateBillId() {
        return UUID.randomUUID().toString();
    }

    private void processAsyncBilling(String billId, Customer customer, BigDecimal amount) {
        publishBillingSubmitted(billId, customer, amount);

        CompletableFuture
                .supplyAsync(this::simulatePaymentProcessing)
                .thenAccept(isSuccessful -> publishBillingResult(isSuccessful, billId, customer, amount));
    }

    private void publishBillingSubmitted(String billId, Customer customer, BigDecimal amount) {
        eventPublisher.publishEvent(new BillingSubmitted(billId, customer, amount));
    }

    private boolean simulatePaymentProcessing() {
        try {
            int delayInMillis = random.nextInt(MAX_DELAY_SECONDS) * MILLIS_PER_SECOND;
            Thread.sleep(delayInMillis);
            return random.nextBoolean();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Processamento de pagamento interrompido", e);
        }
    }

    private void publishBillingResult(boolean isSuccessful, String billId, Customer customer, BigDecimal amount) {
        if (isSuccessful) {
            eventPublisher.publishEvent(new BillingCompleted(billId, customer, amount));
        } else {
            eventPublisher.publishEvent(new BillingFailed(billId, customer, amount));
        }
    }
}
