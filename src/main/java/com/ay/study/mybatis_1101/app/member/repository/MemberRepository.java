package com.ay.study.mybatis_1101.app.member.repository;

import com.ay.study.mybatis_1101.app.member.dto.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MemberRepository {
    @Select("""
        SELECT *
        FROM member
        WHERE username = #{username}
        """)
    Member getMemberByUserName(String username);
}
