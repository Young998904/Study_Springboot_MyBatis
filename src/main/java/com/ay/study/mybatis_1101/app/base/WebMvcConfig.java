package com.ay.study.mybatis_1101.app.base;

import com.ay.study.mybatis_1101.app.interceptor.BeforeActionInterceptor;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@RequiredArgsConstructor
public class WebMvcConfig implements WebMvcConfigurer {
    private final BeforeActionInterceptor beforeActionInterceptor;

    @Value("${resources.notload.list}") // application.yml에 설정된 값을 가지고 오기
    private List<String> notLoadList;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        InterceptorRegistration ir;
        ir = registry.addInterceptor(beforeActionInterceptor);

//        // 방법 (1)
//        // interceptor 작동 기준 추가
//        ir.addPathPatterns("/**");
//
//        // 예외 경우들
//        ir.excludePathPatterns("/favicon.ico");
//        ir.excludePathPatterns("/resource/**");
//        ir.excludePathPatterns("/gen/**");
//        ir.excludePathPatterns("/error");

        // 방법(2) : yml 파일 활용
        notLoadList.add("/article/test"); // 예외 경로 추가
        ir.addPathPatterns("/**").excludePathPatterns(notLoadList);
    }
}
