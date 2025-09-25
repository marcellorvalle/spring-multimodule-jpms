package com.app.product.api;

import com.app.product.domain.Product;

public interface ProductService {
    Product getById(long id);
}
