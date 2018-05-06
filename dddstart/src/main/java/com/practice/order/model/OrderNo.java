package com.practice.order.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by kangminjeong on 2018. 5. 6..
 */
@Embeddable
public class OrderNo implements Serializable{
    @Column(name = "order_number")
    private String number;

    public boolean is2ndGeneration() {
        return number.startsWith("N");
    }
}
