package com.ay.study.mybatis_1101.app.member.service;

import com.ay.study.mybatis_1101.app.member.dto.Member;
import com.ay.study.mybatis_1101.app.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    public Member getMemberByUsername(String username) {
        return memberRepository.getMemberByUserName(username);
    }
}
