package com.practice.order.model;

import lombok.Getter;

import javax.persistence.*;

/**
 * Created by kangminjeong on 2018. 5. 6..
 */
@Entity
@Table(name = "article")

//SecondaryTable 을 사용하면 Article 만 조회할 때도 Content 정보가 같이 조회된다
@SecondaryTable(
        name = "article_content",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "id")
)
@Getter
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;

    @AttributeOverrides({
            @AttributeOverride(name = "content", column = @Column(table = "article_content")),
            @AttributeOverride(name = "conetntType", column = @Column(table = "article_cotent"))
    })
    private ArticleContent content;
}
