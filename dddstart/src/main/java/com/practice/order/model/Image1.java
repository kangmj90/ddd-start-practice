package com.practice.order.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Created by kangminjeong on 2018. 5. 6..
 */

//Hibernate 에서 Embeddable 타입은 clear 메서드를 호출할 때 한번의 delete query 로 삭제 처리한다
@Embeddable
public class Image1 {

    @Column(name = "image_type")
    private String imageType;

    @Column(name = "image_path")
    private String path;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "upload_time")
    private Date uploadTime;

    public boolean hasThumbnail() {
        if (imageType.equals("II")) {
            return true;
        } else {
            return false;
        }
    }

}
