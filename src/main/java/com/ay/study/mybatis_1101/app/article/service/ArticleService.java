package com.ay.study.mybatis_1101.app.article.service;

import com.ay.study.mybatis_1101.app.article.dto.Article;
import com.ay.study.mybatis_1101.app.article.repository.ArticleRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public List<Article> getArticles() {
        return articleRepository.getArticles();
    }

    public long writeArticle(String subject, String content) {
        articleRepository.writeArticle(subject, content);
        return articleRepository.getLastInsertId();
    }
}
