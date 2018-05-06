package com.practice.order.application.service;

import com.practice.order.model.Article;

/**
 * Created by kangminjeong on 2018. 5. 6..
 */
public class WriteArticleService {
    private ArticleRepository articleRepository;

    public Long write(NewArticleRequest req) {
        Article article = new Article("제목", new ArticleContent("content", "type"));
        articleRepository.save(article);

        return article.getId();
    }
}
