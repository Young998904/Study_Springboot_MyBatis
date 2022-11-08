package com.ay.study.mybatis_1101.app.base;

import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component // Bean 등록
@SessionScope // 브라우저 당 1개
public class Rq {
    @Getter
    private int count = 0;

    @Getter
    private String name;

    public void increaseCount() {
        this.count ++;
    }
}
