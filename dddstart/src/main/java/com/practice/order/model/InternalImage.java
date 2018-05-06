package com.practice.order.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * Created by kangminjeong on 2018. 5. 6..
 */
@Entity
@DiscriminatorValue("II")
public class InternalImage extends Image{
}
