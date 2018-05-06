package com.practice.order.application.service;

import org.junit.Test;

/**
 * Created by kangminjeong on 2018. 4. 15..
 */
public class CalculateDiscountServiceTest {

    @Test(expect = NoCustomerException.class);
    public void noCustomer_thenExceptionShouldBeThrown() {

//        Q. Mock 객체 이용한 대용 객체 생성
        CustomerRepository stubRepo = mock(CustomerRepository.class);
        when(stubRepo.findById("noCustId")).thenReturn(null);

        RuleDiscounter stubRule = (cust, lines) -> null;

        CalculateDiscountService calDisSvc =
                new CalculateDiscountService(stubRepo, stubRule);

        calDisSvc.calculateDiscount(someLines, "noCustId");
    }
}
