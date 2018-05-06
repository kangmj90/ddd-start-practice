package com.practice.order.application.service;

import com.practice.order.model.Product;
import com.practice.order.model.Store;

/**
 * Created by kangminjeong on 2018. 4. 15..
 */
public class RegisterProductService {

    public ProductId registerNewProduct(NewProductRequest req) {
        Store account = accountRepository.findStoreById(req.getStoreId());
        checkNull(account);

        ProductId id = productRepository.nextId();
        Product product = new Product(id, account.getId(), ...);
        productRepository.save(product);
        return id;
    }
}
