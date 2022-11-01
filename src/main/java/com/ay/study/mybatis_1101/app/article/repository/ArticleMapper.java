package com.ay.study.mybatis_1101.app.article.repository;

import com.ay.study.mybatis_1101.app.article.dto.Article;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper {
    List<Article> getArticles();
}
