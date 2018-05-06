package com.practice.order.model;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

/**
 * Created by kangminjeong on 2018. 4. 8..
 */
@Getter
@Embeddable
public class OrderLine {

    @Embedded
    private Product product;
//    private int price;
    @Column(name = "price")
    private Money price;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "amounts")
    private Money amounts;

    public OrderLine (Product product, Money price, int quantity) {
        this.product = product;
//        this.price = price;
//        Money 의 데이터가 변경될 수 없도록
        this.price = new Money(price.getValue());
        this.quantity = quantity;
        this.amounts = calculateAmounts();
    }

    private Money calculateAmounts() {

//        return price * quantity;
        return price.multiply(quantity);
    }

    public int getAmounts() {

    }
}
