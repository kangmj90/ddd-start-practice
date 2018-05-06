package com.practice.order.application.service;

import com.practice.order.model.Category;
import com.practice.order.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by kangminjeong on 2018. 4. 15..
 */
public class ProductListService {

    public Page<Product> getProductOfCategory(Long categoryId, int page, int size) {
        Category category = categoryRepository.findById(categoryId);
        checkCategory(category);
        List<Product> products =
                productRepository.findByCategoryId(category.getId(), page, size);
        int totalCount = productRepository.countByCategoryId(category.getId());
        return new Page(page, size, totalCount, products);
    }
}
