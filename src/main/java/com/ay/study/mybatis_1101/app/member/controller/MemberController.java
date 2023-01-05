package com.ay.study.mybatis_1101.app.member.controller;

import com.ay.study.mybatis_1101.app.base.Rq;
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
    private final Rq rq;

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

        rq.setLoginDone(member);

        return "redirect:/?msg=loginSuccess";
    }
}
