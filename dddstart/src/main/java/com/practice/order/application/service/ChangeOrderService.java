package com.practice.order.application.service;

import com.practice.order.model.Order;
import com.practice.order.model.ShippingInfo;

import javax.transaction.Transactional;

/**
 * Created by kangminjeong on 2018. 4. 15..
 */
public class ChangeOrderService {
    @Transactional
    public void changeShippingInfo(OrderNo no, ShippingInfo newShippingInfo, boolean useNewShippingAddrAsMemberAddr) {
        Order order = orderRepository.findById(no);
        if (order == null) throw new OrderNotFoundException();
        order.changeShippingInfo(newShippingInfo);

        order.shipTo(newShippingInfo);
        if (useNewShippingAddrAsMemberAddr) {
//            order.getOrderer()
//                    .getCustomer().changeAddress(newShippingInfo.getAddress());
            Customer customer = customerRepository.findById(
                    order.getOrderer().getCustomerId()
            );
            customer.changeAddress(newShippingInfo.getAddress());
        }
    }
}
