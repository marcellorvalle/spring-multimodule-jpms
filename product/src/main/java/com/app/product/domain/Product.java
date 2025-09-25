package com.app.product.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    private Long id;
    private String name;
    private BigDecimal price;

    public BigDecimal getPrice() {
        return price.setScale(2, RoundingMode.HALF_UP);
    }
}
