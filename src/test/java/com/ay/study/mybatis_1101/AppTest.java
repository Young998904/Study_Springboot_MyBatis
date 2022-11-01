package com.ay.study.mybatis_1101;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import com.ay.study.mybatis_1101.app.article.dto.Article;
import com.ay.study.mybatis_1101.app.article.service.ArticleService;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional // 테스트 내용 DB 에 반영되지 않도록
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

    @Test
    @DisplayName("게시물_작성")
    void t2() {
        String subject = "제목3";
        String content = "내용3";
        long id = articleService.writeArticle(subject, content);
        assertThat(id).isGreaterThan(2);
    }
}
