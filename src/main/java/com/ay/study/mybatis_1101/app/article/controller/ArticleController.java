package com.ay.study.mybatis_1101.app.article.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/article")
public class ArticleController {
    @GetMapping("/list")
    public String showMain() {
        return "article/list";
    }

    @GetMapping("/write")
    public String showWrite() {
        return "/article/write";
    }
}
