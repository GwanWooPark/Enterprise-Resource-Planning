package com.erp.member.controller.dto;

import com.erp.member.domain.Address;
import com.erp.member.domain.Member;
import com.erp.member.domain.Role;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.Embedded;
import javax.validation.Valid;
import javax.validation.constraints.*;

@Getter
@Setter
public class MemberRequestDto {

    @Email(message = "올바른 이메일 주소가 아닙니다.", regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")
    @NotBlank(message = "이메일을 입력해주세요.")
    private String email;
    @NotBlank(message = "비밀번호를 입력해주세요")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,16}$",
             message = "영문, 숫자를 포함한 8자 이상 16자 이하의 비밀번호를 입력해주세요")
    private String password;

    @NotBlank(message = "이름을 입력해주세요")
    private String name;

    @NotBlank(message = "전화번호를 입력해주세요")
    private String phone;

    private Role role;

    @Valid
    @Embedded
    private Address address;


    public MemberRequestDto encodePassword(PasswordEncoder passwordEncoder) {
        password = passwordEncoder.encode(password);
        return this;
    }
    public Member toMember() {
        return Member.builder()
                .email(email)
                .password(password)
                .name(name)
                .phone(phone)
                .role(Role.ROLE_STAFF)
                .address(address)
                .build();
    }
}
