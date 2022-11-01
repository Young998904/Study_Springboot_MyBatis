package com.ay.study.mybatis_1101;

import com.ay.study.mybatis_1101.app.article.dto.Article;
import com.ay.study.mybatis_1101.app.article.service.ArticleService;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppTest {
    @Autowired
    private ArticleService articleService;
    @Test
    @DisplayName("게시물_리스트_반환")
    void t1() {
        List<Article> articles = articleService.getArticles();
        System.out.println(articles);
        System.out.println(articles.get(1).getSubject());
    }
}
