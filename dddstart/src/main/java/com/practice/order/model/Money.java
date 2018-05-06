package com.practice.order.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by kangminjeong on 2018. 4. 15..
 */
@Getter
@AllArgsConstructor
public class Money {
    private int value;

    public int getValue() {
        return this.value;
    }

    public Money add (Money money) {
        return new Money(this.value + money.value);
    }

    public Money multiply(int multiplier) {
        return new Money(value * multiplier);
    }
}
