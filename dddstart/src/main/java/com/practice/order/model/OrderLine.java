package com.practice.order.model;

import lombok.Data;

/**
 * Created by kangminjeong on 2018. 4. 8..
 */
@Data
public class OrderLine {
    private Product product;
    private int price;
    private int quantity;
    private int amount;

    public OrderLine (Product product, int price, int quantity, int amount) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
        this.amount = calculateAmounts();
    }

    private int calculateAmounts() {
        return price * quantity;
    }

    public int getAmounts() {

    }
}
