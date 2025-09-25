package com.app.costumer.service;

import com.app.costumer.api.CostumerService;
import com.app.costumer.domain.Costumer;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CostumerServiceImpl implements CostumerService {


    @Override
    public Optional<Costumer> findById(Long id) {
        return Optional.of(new Costumer(id, "Costumer " + id));
    }
}
