package com.practice.order.infrastructure;

import com.practice.order.model.Order;

import java.util.List;

/**
 * Created by kangminjeong on 2018. 4. 15..
 */
public interface OrderRepository {
    public Order findByNumber(OrderNo number);
    public void save(Order order);
    public void delete(Order order);

    public List<Order> findByOrderId(String ordererId, int startRow, int size);
}
