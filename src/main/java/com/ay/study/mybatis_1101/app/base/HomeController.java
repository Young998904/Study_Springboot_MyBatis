package com.ay.study.mybatis_1101.app.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class HomeController {
    @GetMapping("")
    public String showMain() {
        return "/home/main";
    }
}
