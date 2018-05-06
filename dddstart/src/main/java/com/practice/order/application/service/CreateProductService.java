package com.practice.order.application.service;

import com.practice.order.model.Product;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;

/**
 * Created by kangminjeong on 2018. 5. 6..
 */
public class CreateProductService {
    @Autowired
    private ProductIdService idService;

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public ProductId createProduct(ProductCreationCommand cmd) {
        ProductId id = idService.nextId();
        Product product = new Product(id, cmd.getDetail(), cmd.getPrice(), ...);
        productRepository.save(product);

        return id;
    }
}
