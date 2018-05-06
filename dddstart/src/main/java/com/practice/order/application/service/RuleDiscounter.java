package com.practice.order.application.service;

import com.practice.order.model.Money;
import com.practice.order.model.OrderLine;

import java.util.List;

/**
 * Created by kangminjeong on 2018. 4. 15..
 */
public interface RuleDiscounter {
    public Money applyRules(Customer customer, List<OrderLine> orderLines);
}
