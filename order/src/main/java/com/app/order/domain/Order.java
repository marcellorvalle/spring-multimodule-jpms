package com.app.order.domain;

import com.app.costumer.domain.Costumer;
import com.app.product.domain.Product;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
public class Order {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "costumerId", nullable = false)
    private Costumer costumer;

    @ManyToOne
    @JoinColumn(name = "productId", nullable = false)
    private Product product;

    private int quantity;

    private boolean billed = false;

    public BigDecimal getTotal() {
        return product.getPrice().multiply(new BigDecimal(quantity));
    }
}
