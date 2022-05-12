package com.erp.member.controller.dto;

import com.erp.member.domain.Member;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class MemberLoginDto {

    private Long no;
    private String email;
    private String password;


    public Member toMember() {
        return Member.builder()
                .email(email)
                .password(password)
                .build();
    }
}
