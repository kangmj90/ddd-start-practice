package com.practice.order.convert;

import com.practice.order.model.EmailSet;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Created by kangminjeong on 2018. 5. 6..
 */
@Converter
public class EmailSetConverter implements AttributeConverter<EmailSet, String> {

    @Override
    public String convertToDatabaseColumn(EmailSet attribute) {
        if (attribute == null)
            return null;

        return attribute.getEmails().stream().map(Email::toString).collect(Collectors.joining(","));
    }

    @Override
    public EmailSet convertToEntityAttribute(String dbData) {
        if (dbData == null)
            return null;

        String[] emails = dbData.split(",");
        Set<Email> emailSet = Arrays.stream(emails).map(value -> new Email(value)).collect(toSet());

        return new EmailSet(emailSet);
    }
}
