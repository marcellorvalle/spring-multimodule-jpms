package com.app.order.listener;

import com.app.billing.event.BillingCompleted;
import com.app.billing.event.BillingFailed;
import com.app.billing.event.BillingSubmitted;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;

@Component
@Slf4j
public class BillingListener {
    @EventListener
    public void handleSubmission(BillingSubmitted submitted) {
        log.info("Billing submitted: {}", submitted);
    }

    @EventListener
    public void handleFailure(BillingFailed failed) {
        log.info("Billing failed: {}", failed);
    }

    @EventListener
    public void handleCompleted(BillingCompleted completed) {
        log.info("Billing completed: {}", completed);
    }

}
