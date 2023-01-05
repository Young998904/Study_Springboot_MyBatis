package com.ay.study.mybatis_1101.app.article.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/article")
public class AdminController {
    @GetMapping("/list")
    public String showMain() {
        return "/adm.article/list";
    }

    @GetMapping("/write")
    public String showWrite() {
        return "/adm.article/write";
    }
}
