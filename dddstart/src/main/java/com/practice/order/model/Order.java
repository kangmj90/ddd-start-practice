package com.practice.order.model;

import lombok.Data;

import java.util.List;

/**
 * Created by kangminjeong on 2018. 4. 8..
 */

@Data
public class Order {

    private List<OrderLine> orderLines;
    private int totalAmounts;

    private OrderState state;
    private ShippingInfo shippingInfo;

    public Order(List<OrderLine> orderLines, ShippingInfo shippingInfo) {
        setOrderLines(orderLines);
        setShippingInfo(shippingInfo);
    }

    private void setOrderLines(List<OrderLine> orderLines) {
        verifyAtLeastOneOrMoreOrderLines(orderLines);
        this.orderLines = orderLines;
        calculateTotalAmounts();
    }

    private void setShippingInfo(ShippingInfo shippingInfo) {
        if (shippingInfo == null)
            throw new IllegalArgumentException("no ShippingInfo");
        this.shippingInfo = shippingInfo;
    }

    private void verifyAtLeastOneOrMoreOrderLines(List<OrderLine> orderLines) {
        if (orderLines == null || orderLines.isEmpty()) {
            throw new IllegalArgumentException("no OrderLine");
        }
    }

    private void calculateTotalAmounts() {
        this.totalAmounts = new Money(orderLines.stream().mapToInt(x -> x.getAmounts().getValue()).sum());
    }

    public void changeShippingInfo (ShippingInfo newShippingInfo) {
//       verifyNotYetShipped 로 변경 > 도메인에 대하여 더 상세하게 파악했기 때문 . 배송지 변경/주문 취소는 "출고 전"에 가능
//        if (!state.isShippingChangeable()) { > 배송지 변경 가능 확인 여부
//            throw new IllegalStateException("can't change shipping in " + state);
//        }
        verifyNotYetShipped();
        this.shippingInfo = newShippingInfo;
    }

    public void cancel() {
        verifyNotYetShipped();
        this.state = OrderState.CANCELED;
    }

    private void verifyNotYetShipped() {
        if (state != OrderState.PAYMENT_WAITING && state != OrderState.PREPARING)
            throw new IllegalArgumentException("already shipped");
    }


    private boolean isShippingChangeable() {
        return state == OrderState.PAYMENT_WAITING || state == Orderstate.PREPARING;
    }

    public void changeShipped() {
        this.state = OrderState.SHIPPED;
    }

    public void completePayment() {}
}
