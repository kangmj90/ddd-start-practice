package com.practice.other;

import com.practice.order.model.Money;
import com.practice.order.model.OrderLine;
import org.springframework.jdbc.support.CustomSQLErrorCodesTranslation;

import java.util.Arrays;
import java.util.List;

/**
 * Created by kangminjeong on 2018. 4. 15..
 */
public class CalculateDiscountService {
    private DroolsRuleEngine ruleEngine;

    public CalculateDiscountService() {
        ruleEngine = new DroolsRuleEngine();
    }

    public Money calculateDiscount(OrderLine orderLine, String customerId) {
        Customer customer = findCustomer(customerId);

        MutableMoney money = new MutableMoney(0);
        List<?> facts = Arrays.asList(customer, money);

        facts.addAll(orderLine);
        ruleEngine.evaluate("discountCalculation", facts);
        return money.toImmutableMoney();

//        서비스 - 인프라스트럭처 직접 연관 (의존)은 서비스만 테스트 하기와 기능 확장이 어렵다
    }
}
