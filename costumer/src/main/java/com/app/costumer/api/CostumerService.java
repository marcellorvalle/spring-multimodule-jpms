package com.app.costumer.api;

import com.app.costumer.domain.Costumer;
import java.util.Optional;

public interface CostumerService {
    Optional<Costumer> findById(Long id);
}
