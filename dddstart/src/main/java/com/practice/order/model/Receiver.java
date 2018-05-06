package com.practice.order.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by kangminjeong on 2018. 4. 15..
 */
@Getter
@AllArgsConstructor
public class Receiver {
    private String name;
    private String phoneNumber;

//    JPA를 적용하기 위해 기본 생성자 추가
//    JPA 프로바이더가 객체 생성할 떄만 사용하기 떄문에 다른 코드에서 생성자를 사용하지 못하도록 protected
    protected Receiver() {}

    public boolean equals (Object other) {
        if (other == null) return false;
        if (this == other) return true;
        if (!(other instanceof Receiver)) return false;
        Receiver that = (Receiver) other;
        return this.name.equals(that.name) &&
                this.phoneNumber.equals(that.phoneNumber);
    }
}
