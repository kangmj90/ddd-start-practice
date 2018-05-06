package com.practice.order.model;

import javax.persistence.*;

/**
 * Created by kangminjeong on 2018. 4. 15..
 */
@Embeddable
public class Orderer {

    @Embedded
    @AttributeOverrides(
            @AttributeOverride(name = "id", column = @Column(name = "orderer_id"))
    )
    private MemberId memberId;

    @Column(name = "orderer_name")
    private String name;
    private String email;
}
