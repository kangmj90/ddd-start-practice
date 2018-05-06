package com.practice.order.model;

/**
 * Created by kangminjeong on 2018. 4. 15..
 */
public class Store extends Member{

    public Product createProduct(ProductId newProductId, ...) {
        if (isBlocked()) throw new StoreBlockedException();
        return new Product(newProductId, getId(), ...);
    }
}
