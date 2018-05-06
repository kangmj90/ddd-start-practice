package com.practice.order.convert;

import com.practice.order.model.Money;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Created by kangminjeong on 2018. 5. 6..
 */
@Converter(autoApply = true)
public class MoneyConverter implements AttributeConverter<Money, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Money money) {
        if (money == null)
            return null;
        else
            return money.getValue();
    }

    @Override
    public Money convertToEntityAttribute(Integer value) {
        if (value == null)
            return null;
        else
            return new Money(value);
    }
}
