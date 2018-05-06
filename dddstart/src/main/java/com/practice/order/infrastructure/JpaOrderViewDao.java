package com.practice.order.infrastructure;

import com.practice.order.application.dto.OrderView;
import com.practice.order.model.Order;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by kangminjeong on 2018. 4. 15..
 */
@Repository
public class JpaOrderViewDao implements OrderViewDao{
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<OrderView> selectByOrderer(String ordererId) {
        String selectQuery =
                "select new com.practice.order.application.dto.OrderView(o, m, p)" +
                        "from Order o join o.orderLines ol, Member m, Product p" +
                        "where o.orderer.memberId.id = :ordererId" +
                        "and o.orderer.memberId = m.id" +
                        "and index(ol) = 0" +
                        "and ol.productId = p.id" +
                        "order by o.number.number desc";
        TypedQuery<Order> query =
                em.createQuery(selectQuery, OrderView.class);
        query.setParameter("ordererId", ordererId);
        return query.getResultList();
    }
}
