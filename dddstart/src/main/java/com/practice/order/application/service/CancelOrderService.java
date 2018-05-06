package com.practice.order.application.service;

import com.practice.order.model.Order;
import com.practice.order.infrastructure.OrderRepository;

import javax.transaction.Transactional;

/**
 * Created by kangminjeong on 2018. 4. 15..
 */
public class CancelOrderService {

    private OrderRepository orderRepository;

    public void cancel(OrderNumber number) {
        Order order = orderRepository.findByNumber(number);
        if (order == null) throw new NoOrderException(number);
        order.cancel();
    }

//    로직 직접 수행 -> 도메인 모델에 로직 수행을 위임
    @Transactional
    public void cancelOrder(String orderId) {
        Order order = findOrderById(orderId);
        if (order == null) throw new OrderNotFoundException(orderId);
        order.cancel();
    }
}
