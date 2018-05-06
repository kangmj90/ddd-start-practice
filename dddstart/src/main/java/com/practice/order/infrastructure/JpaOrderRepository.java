package com.practice.order.infrastructure;

import com.practice.order.model.Order;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by kangminjeong on 2018. 5. 1..
 */
@Repository
public class JpaOrderRepository implements OrderRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Order findById(OrderNo id) {
        return entityManager.find(Order.class, id);
    }

    @Override
    public void save(Order order) {
        entityManager.persist(order);
    }

    @Override
    public List<Order> findByOrdererId(String ordererId, int startRow, int fetchSize) {
        TypedQuery<Order> query = entityManager.createQuery(
          "select o from Order o" +
                  "where o.orderer.memberId.id = :ordererId" +
                  "order by o.number.number desc",
                Order.class
        );
        query.setParameter("ordererId", ordererId);
        query.setFirstResult(startRow);
        query.setMaxResults(fetchSize);

        return query.getResultList();
    }

    @Override
    public void remove (Order order) {
        entityManager.remove(order);
    }
}
