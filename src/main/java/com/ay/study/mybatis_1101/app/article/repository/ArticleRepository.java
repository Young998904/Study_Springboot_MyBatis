package com.ay.study.mybatis_1101.app.article.repository;

import com.ay.study.mybatis_1101.app.article.dto.Article;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
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

    @Insert("""
        <script>
        INSERT INTO article
        SET createDate = NOW(),
        modifyDate = NOW(),
        subject = #{subject},
        content = #{content}
        </script>
        """)
    void writeArticle(String subject, String content);

    @Select("""
        SELECT LAST_INSERT_ID()
        """)
    long getLastInsertId();
}