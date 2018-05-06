package com.practice.order.model;

import com.practice.order.convert.MoneyConverter;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by kangminjeong on 2018. 4. 8..
 */

@Data

// DIP장점을 해치지 않는 범위에서 의존한다
@Entity
@Table(name = "purchase_order")
@Access(AccessType.FIELD)
public class Order {

//    굳이 필드 구분을 위해 데이터 타입을 계속 변경할 필요가 있을까

//    @Id
//    private String number;

    @EmbeddedId
    private OrderNo number;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "order_line", joinColumns = @JoinColumn(name = "order_number"))
    @OrderColumn(name = "line_idx")
    private List<OrderLine> orderLines;

    @Column(name = "total_amounts")
    @Convert(converter = MoneyConverter.class)
    private Money totalAmounts;

    @Column(name = "state")
    @Enumerated(EnumType.STRING)
    private OrderState state;

    @Embedded
    private ShippingInfo shippingInfo;

    private String orderNumber;

    @Embedded
    private Orderer orderer;

    @Override
    public boolean equals (Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (obj.getClass() != Order.class) return false;
        Order other = (Order) obj;
        if (this.orderNumber == null) return false;
        return this.orderNumber.equals(other.orderNumber);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((orderNumber == null) ? 0 : orderNumber.hashCode());
        return result;
    }

    public Order(List<OrderLine> orderLines, ShippingInfo shippingInfo) {
        setOrderLines(orderLines);
        setShippingInfo(shippingInfo);
    }

    public OrderNo getId() {
        return id;
    }

    private void setOrderer(Orderer orderer) {
        if (orderer == null) throw new IllegalArgumentException("no orderer");
        this.orderer = orderer;
    }

    private void setOrderLines(List<OrderLine> orderLines) {
        verifyAtLeastOneOrMoreOrderLines(orderLines);
        this.orderLines = orderLines;
        calculateTotalAmounts();
    }

    private void verifyAtLeastOneOrMoreOrderLines(List<OrderLine> orderLines) {
        if (orderLines == null || orderLines.isEmpty()) {
            throw new IllegalArgumentException("no OrderLine");
        }
    }

    private void calculateTotalAmounts() {
//        this.totalAmounts = new Money(orderLines.stream().mapToInt(x -> x.getAmounts().getValue()).sum());
//        this.totalAmounts = orderLines.stream().mapToInt(x -> x.getAmounts()).sum();
        int sum = orderLines.stream()
                .mapToInt(ol -> ol.getPrice() * ol.quantity())
                .sum();
        this.totalAmounts = new Money(sum);
    }

    private void setShippingInfo(ShippingInfo newShippingInfo) {
        if (shippingInfo == null)
            throw new IllegalArgumentException("no ShippingInfo");

        this.shippingInfo = newShippingInfo;
    }

    public void changeShippingInfo (ShippingInfo newShippingInfo) {
//       verifyNotYetShipped 로 변경 > 도메인에 대하여 더 상세하게 파악했기 때문 . 배송지 변경/주문 취소는 "출고 전"에 가능
//        if (!state.isShippingChangeable()) { > 배송지 변경 가능 확인 여부
//            throw new IllegalStateException("can't change shipping in " + state);
//        }
        
        checkShippingInfoChangeable();
        
        verifyNotYetShipped();
        setShippingInfo(newShippingInfo);

        this.shippingInfo = newShippingInfo;
    }

    private void checkShippingInfoChangeable() {
    }

    public void setOrderState(OrderState orderState) {

    }

    public void cancel() {
        verifyNotYetShipped();
        this.state = OrderState.CANCELED;
    }

    private void verifyNotYetShipped() {
        ShippingInfo si = orderer.

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

    public void changeOrderLines(List<OrderLine> newLines) {
        orderLines.changeOrderLines(newLines);
        this.totalAmounts = orderLines.getTotalAmounts();
    }
}
