package com.practice.order.infrastructure;

import com.practice.order.model.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by kangminjeong on 2018. 4. 15..
 */
@Repository
public class JpaProductRepository implements ProductRepository{
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findByCategoryId(CategoryId categoryId, int page, int size) {
        TypedQuery<Product> query = entityManager.createQuery(
                "select p from p" +
                        "where :catId member of p.categoryIds order by p.id.id desc",
                Product.class
        );
        query.setParameter("catId", categoryId);
        query.setFirstResult((page -1) * size);
        query.setMaxResults(size);
        return query.getResultList();
    }
}
