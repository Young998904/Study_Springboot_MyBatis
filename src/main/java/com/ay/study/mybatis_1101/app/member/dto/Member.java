package com.ay.study.mybatis_1101.app.member.dto;

import java.util.Arrays;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Member {
    private long id;
    private String username;
    private String password;
    private String name;
    private String email;

    private String roles;

    public boolean matchPassword(String password) {
        return this.password.substring("{noop}".length()).equals(password);
    }

    public boolean hasRole(String role) { // 원하는 권한이 있는지 확인
        return Arrays
            .stream(roles.split(","))
            .anyMatch(role_ -> role_.equals(role));
    }
}
