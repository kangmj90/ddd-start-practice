package com.practice.order.model;

import java.util.List;
import java.util.Set;

/**
 * Created by kangminjeong on 2018. 4. 15..
 */
public class Category {
    private Set<Product> products;

    public List<Product> getProducts(int page, int size) {
        List<Product> sortedProducts = sortById(products);
        return sortedProducts.subList((page - 1) * size, page * size);
    }
}
