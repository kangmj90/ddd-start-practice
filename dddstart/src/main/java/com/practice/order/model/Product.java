package com.practice.order.model;

import com.practice.order.convert.MoneyConverter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kangminjeong on 2018. 4. 15..
 */
@Entity
@Table(name = "product")
public class Product {
    @EmbeddedId
    private ProductId id;

    private String name;

    @Convert(converter = MoneyConverter.class)
    private Money price;

    private String detail;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    @OrderColumn(name = "list_idx")
    private List<Image> images = new ArrayList<>();

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "product_option", joinColumns = @JoinColumn(name = "product_id"))
    @OrderColumn(name = "list_idx")
    private List<Option> options = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "product_category",
            joinColumns = @JoinColumn(name = "product_id"))
    private Set<CategoryId> categoryIds;

    private CategoryId category;

    @Column(name = "WIDTH")
    private String width;

    public Length getWidth() {
        return new Width();
    }

    void setWidth(Length width) {
        this.width = width.toString();
    }

    public void changeImages(List<Image> newImages) {

//        삭제된 갯수만큼의 delete query 를 실행하게 된다
        images.clear();
        images.addAll(newImages);
    }

    public void removeOption(int optIdx) {
        this.options.remove(optIdx);
    }
}
