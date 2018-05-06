package com.practice.order.application.service;

/**
 * Created by kangminjeong on 2018. 5. 6..
 */
public class OrderIdService {

    public OrderId createId (UserId userId) {
        if (userId == null) {
            throw new IllegalArgumentException("invalid userid: " + userId);
        }
        return new OrderId (userId.toString() + "-" + timestamp());
    }

    private String timestamp() {
        return Long.toString(System.currentTimeMillis());
    }
}
