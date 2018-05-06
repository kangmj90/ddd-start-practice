package com.practice.order.application.service;

import com.practice.order.model.Money;
import com.practice.order.model.OrderLine;

/**
 * Created by kangminjeong on 2018. 4. 15..
 */
public class CalculateDiscountService {
    private RuleDiscounter ruleDiscounter;
    private CustomerRepository customerRepository;

    public CalculateDiscountService(RuleDiscounter ruleDiscounter, CustomerRepository customerRepository) {
        this.ruleDiscounter = ruleDiscounter;
        this.customerRepository = customerRepository;
    }

    public Money calculateDiscount(OrderLine orderLines, String customerId) {
        Customer customer = findCustomer(customerId);
        return ruleDiscounter.applyRules(customer, orderLines);
    }

    private Customer findCustomer(String customerId) {
        Customer customer = customerRepository.findById(customerId);
        if (customer == null) throw new NoCustomerException();
        return customer;
    }
}
