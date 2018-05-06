package com.practice.order.model;

import java.util.List;

/**
 * Created by kangminjeong on 2018. 4. 15..
 */
public class OrderLines {
    private List<OrderLine> lines;

    public int getTotalAmounts() {

    }

    public void changeOrderLines(List<OrderLine> newLines) {
        this.lines = newLines;
    }
}
