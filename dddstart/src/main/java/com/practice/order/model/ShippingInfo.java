package com.practice.order.model;

import lombok.Data;

/**
 * Created by kangminjeong on 2018. 4. 8..
 */
@Data
public class ShippingInfo {
    private String receiverName;
    private String receiverPhoneNumber;
    private String shippingAddress1;
    private String shippingAddress2;
    private String shippingZipcode;
}
