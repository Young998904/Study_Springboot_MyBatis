package com.ay.study.mybatis_1101.app.interceptor;

import com.ay.study.mybatis_1101.app.base.Rq;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
@RequiredArgsConstructor
public class NeedToAdminInterceptor implements HandlerInterceptor {
    private final Rq rq;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (rq.isAdmin() == false) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().append("관리자만 이용할 수 있습니다.");
            return false;
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
