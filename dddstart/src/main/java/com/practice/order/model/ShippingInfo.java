package com.practice.order.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by kangminjeong on 2018. 4. 8..
 */
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class ShippingInfo {
//    private String receiverName;
//    private String receiverPhoneNumber;
//    private String shippingAddress1;
//    private String shippingAddress2;
//    private String shippingZipcode;

    @Embedded
    private Receiver receiver;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "zipcode", column = @Column(name = "shipping_zipcode")),
            @AttributeOverride(name = "address1", column = @Column(name = "shipping_addr1")),
            @AttributeOverride(name = "address2", column = @Column(name = "shipping_addr2"))
    })
    private Address address;

    @Column(name = "shipping_message")
    private String message;
}
