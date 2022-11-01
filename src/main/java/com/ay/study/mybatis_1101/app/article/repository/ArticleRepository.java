package com.ay.study.mybatis_1101.app.article.repository;

import com.ay.study.mybatis_1101.app.article.dto.Article;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ArticleRepository {
    @Select("""
        <script>
        SELECT *
        FROM article
        </script>
        """)
    List<Article> getArticles();
}