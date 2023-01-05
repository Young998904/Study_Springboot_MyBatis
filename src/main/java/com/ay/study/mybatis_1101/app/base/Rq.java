package com.ay.study.mybatis_1101.app.base;

import com.ay.study.mybatis_1101.app.member.dto.Member;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component // Bean 등록
@RequestScope // 브라우저 당 1개
@RequiredArgsConstructor
public class Rq {
    @Getter
    private int count = 0;

    @Getter
    private String name;
    private final HttpServletRequest req;
    private final HttpSession session;

    public void increaseCount() {
        this.count ++;
    }

    public String getCurrentUrl() {
        String url = req.getRequestURL().toString();
        String queryString = req.getQueryString();

        if (queryString != null && queryString.length() > 0) {
            url += "?" + queryString;
        }

        return url;
    }

    public long getLoginedMemberId() {
        Long id =  (Long) session.getAttribute("loginedMemberId");
        if (id == null) {
            return -1;
        }
        return id;
    }

    public String getLoginedMemberName() {
        return (String) session.getAttribute("loginedMemberName");
    }

    public String getLoginedMemberRoles() {
        return (String) session.getAttribute("loginedMemberRoles");
    }

    public Member getLoginedMember() {
        long id = getLoginedMemberId();
        String name = getLoginedMemberName();
        String roles = getLoginedMemberRoles();
        Member member = Member.builder()
            .id(id)
            .name(name)
            .roles(roles)
            .build();
        return member;
    }

    public boolean isLogined() {
        return getLoginedMemberId() >= 0;
    }
    public boolean isLogout() {
        return !isLogined();
    }

    public void setLoginDone(Member member) {
        // login 관련 인터셉터에게 로그인 정보를 전달
        // 단순히 logined 에 T/F 를 보내면 로그인한 유저가 누군지 알 수 없음
        session.setAttribute("loginedMemberId", member.getId());
        session.setAttribute("loginedMemberName", member.getName());
        session.setAttribute("loginedMemberRoles", member.getRoles());
        // 이메일 등등 등록 가능
    }

    public void setLogoutDone() {
        session.removeAttribute("loginedMemberId");
        session.removeAttribute("loginedMemberName");
        session.removeAttribute("loginedMemberRoles");
    }

    public boolean isAdmin() {
        if (isLogout()) return false;

        return getLoginedMember().hasRole("ADMIN");
    }
}
