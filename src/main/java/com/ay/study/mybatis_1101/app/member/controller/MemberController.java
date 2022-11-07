package com.ay.study.mybatis_1101.app.member.controller;

import com.ay.study.mybatis_1101.app.member.dto.Member;
import com.ay.study.mybatis_1101.app.member.service.MemberService;
import javax.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/login")
    public String showLogin() {
        return "member/login";
    }

    @PostMapping("/login")
    public String login(String username, String password, HttpSession session ) {
        Member member = memberService.getMemberByUsername(username);

        if (member == null) {
            return "redirect:/?msg=NotFoundMember";
        }

        if (!member.matchPassword(password)) {
            return "redirect:/?msg=passwordError";
        }

        // login 관련 인터셉터에게 로그인 정보를 전달
        // 단순히 logined 에 T/F 를 보내면 로그인한 유저가 누군지 알 수 없음
        session.setAttribute("loginedMemberId", member.getId());

        return "redirect:/?msg=loginSuccess";
    }
}
