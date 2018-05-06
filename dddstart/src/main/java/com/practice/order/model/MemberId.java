package com.practice.order.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Created by kangminjeong on 2018. 5. 1..
 */
@Embeddable
public class MemberId implements Serializable{
    @Column(name = "member_id")
    private String id;
}
