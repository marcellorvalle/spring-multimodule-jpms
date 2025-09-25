package com.app.product.service;

import com.app.product.api.ProductService;
import com.app.product.domain.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public Product getById(long id) {
        return Product.builder()
                .id(id)
                .name("Product " + id)
                .price(BigDecimal.valueOf(id * 13 + id))
                .build();
    }
}
