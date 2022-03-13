package com.erp.member.controller.dto;

import com.erp.member.domain.Member;
import com.erp.member.domain.Role;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class MemberSingUpDto {


    private String id;

    @NotBlank(message = "비밀번호를 입력해주세요")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\\\d)[A-Za-z\\\\d]{8,}$",
             message = "영문, 숫자를 포함한 8자 이상의 비밀번호를 입력해주세요")
    private String password;

    @NotBlank(message = "이름을 입력해주세요")
    private String name;

    @Email(message = "올바른 이메일 주소가 아닙니다.")
    @NotBlank(message = "이메일을 입력해주세요.")
    private String email;

    @NotBlank(message = "전화번호를 입력해주세요")
    private String phone;

    private Role role;

    public Member toMember() {
        return Member.builder()
                .id(id)
                .password(password)
                .name(name)
                .email(email)
                .phone(phone)
                .role(Role.ROLE_STAFF)
                .build();
    }
}
