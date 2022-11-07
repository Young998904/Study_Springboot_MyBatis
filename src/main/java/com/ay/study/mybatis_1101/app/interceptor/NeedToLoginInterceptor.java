package com.ay.study.mybatis_1101.app.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

@Configuration
@Slf4j
public class NeedToLoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.debug("NeedToLoginInterceptor::preHandle 실행됨");

        // Session 활용
        HttpSession session = request.getSession();
        Long loginedMemberId = (Long) session.getAttribute("loginedMemberId");

        boolean isLogined = loginedMemberId != null;

        if(!isLogined) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().append("로그인 후 이용바랍니다.");

            return false; // Controller 진입 못해보고 종료됨
        }

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
